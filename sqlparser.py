#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  sqlparser.py
#
#  Copyright 2015 Kevin Ramdath <hello@kevinramdath.com>
#
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#
#
import re


class SQLParser(object):
    _KEY_table = 'table'
    _KEY_primary = 'primary_keys'
    _KEY_foreign = 'foregin_keys'
    _KEY_unique = 'unique'
    _KEY_check = 'checks'
    _KEY_constraint = 'constraints'
    _KEY_column = 'columns'

    _KEY_foreign_local = 'local'
    _KEY_foreign_field = 'field'
    _KEY_foreign_table = 'table'

    _KEY_column_name = 'name'
    _KEY_column_type = 'type'
    _KEY_column_null = 'null'

    regex = {
        _KEY_table: r'\s*CREATE TABLE ([_\w]*) \(\s*',
        _KEY_primary: r'\s*PRIMARY KEY \(([_,\w\s]*)\),*\s*',
        _KEY_foreign: r'\s*FOREIGN KEY\(([_\w]*)\) REFERENCES ([_\w]*) \(([_\w]*)\),*\s*',
        _KEY_unique: r'\s*UNIQUE \((.*)\),*\s*',
        _KEY_check: r'\s*CHECK .*\s*',
        _KEY_constraint: r'\s*CONSTRAINT.*\s*',
        _KEY_column: r'\s*"*([_\w]*)"* ([\(\)\w]*).*'
    }

    parser_order = [
        _KEY_table, _KEY_primary, _KEY_foreign, _KEY_unique,
        _KEY_check, _KEY_constraint, _KEY_column
    ]
    parsers = None

    def __init__(self):
        self.parsers = {
            self._KEY_table: self._parse_sql_for_table,
            self._KEY_primary: self._parse_sql_for_primary_keys,
            self._KEY_foreign: self._parse_sql_for_foreign_keys,
            self._KEY_unique: self._parse_sql_for_unique_keys,
            self._KEY_check: self._parse_sql_for_checks,
            self._KEY_constraint: self._parse_sql_for_constraints,
            self._KEY_column: self._parse_sql_for_columns
        }
        return

    def get_metadata(self, sql):
        lines = sql.split('\n')

        m = {}
        for line in lines[:-1]:
            m = self._merge_line_metadata(m, self._parse_sql_line(line))

        # check for duplications
        for k, v in m.iteritems():
            for i in v:
                if v.count(i) > 1:
                    raise ValueError(
                        "Duplication with key: '{0}' and item: '{1}'"
                        .format(k, i)
                    )

        self._check_foreign_keys(m)
        self._check_unique_keys(m)

        if not self._KEY_table in m:
            raise ValueError("Table name not found in sql: " + sql)
        if len(m[self._KEY_table]) > 1:
            raise ValueError(
                "Too many table names ({0}) found in sql: {1}"
                .format(','.join(m[self._KEY_table]), sql)
            )
        m[self._KEY_table] = m[self._KEY_table][0]

        return m

    def _check_foreign_keys(self, meta):
        if not self._KEY_foreign in meta:
            return

        # Check that foreign key local field exist
        for fk in meta[self._KEY_foreign]:
            if not self._column_exists(meta, fk[self._KEY_foreign_local]):
                raise ValueError(
                    "Local field '{0}' for foreign key '{1}->{2}' not "
                    "found in table '{3}'".format(
                        fk[self._KEY_foreign_local],
                        fk[self._KEY_foreign_table],
                        fk[self._KEY_foreign_field],
                        meta[self._KEY_table]
                    )
                )
        return

    def _check_unique_keys(self, meta):
        if not self._KEY_unique in meta:
            return

        # Check that unique index fields exist
        for uk in meta[self._KEY_unique]:
            for field in uk:
                if not self._column_exists(meta, field):
                    raise ValueError(
                        "Unique field '{0}' index '{1}' not "
                        "found in table '{2}'".format(
                            field, ','.join(uk), meta[self._KEY_table]
                        )
                    )
        return

    def _column_exists(self, meta, name):
        for column in meta[self._KEY_column]:
            if column[self._KEY_column_name] == name:
                return True
        return False

    def _merge_line_metadata(self, meta, this):
        for k, v in this.iteritems():
            if not v:
                continue

            if not k in meta:
                meta[k] = [v]
            else:
                meta[k].append(v)

        return meta

    def _parse_sql_line(self, line):
        for key in self.parser_order:
            m = self.parsers[key](line)
            if m:
                return {key: m}

    def _parse_sql_for_table(self, line):
        match = re.match(self.regex[self._KEY_table], line)
        if not match:
            return None

        name = match.group(1).replace('"', '').strip()

        if not name:
            raise ValueError("Could not parse table name: " + line)

        return name

    def _parse_sql_for_primary_keys(self, line):
        match = re.match(self.regex[self._KEY_primary], line)
        if not match:
            return None

        fields = [i.strip() for i in match.group(1).split(',')]

        if not fields:
            raise ValueError("Could not parse primary keys: " + line)

        return fields

    def _parse_sql_for_foreign_keys(self, line):
        match = re.match(self.regex[self._KEY_foreign], line)
        if not match:
            return None

        return {
            self._KEY_foreign_local: match.group(1),
            self._KEY_foreign_table: match.group(2),
            self._KEY_foreign_field: match.group(3)
        }

    def _parse_sql_for_unique_keys(self, line):
        match = re.match(self.regex[self._KEY_unique], line)
        if not match:
            return None

        body = match.group(1)
        fields = [i.replace('"', '').strip() for i in body.split(',')]

        if not fields:
            raise ValueError("Could not parse unique key: " + line)

        return fields

    def _parse_sql_for_checks(self, line):
        match = re.match(self.regex[self._KEY_check], line)
        if not match:
            return None

        ### todo

        return line.strip()

    def _parse_sql_for_constraints(self, line):
        match = re.match(self.regex[self._KEY_constraint], line)
        if not match:
            return None

        ### todo

        return line.strip()

    def _parse_sql_for_columns(self, line):
        match = re.match(self.regex[self._KEY_column], line)
        if not match:
            return None

        def clean(name):
            return name.replace('"', '').strip()

        return {
            self._KEY_column_name: clean(match.group(1)),
            self._KEY_column_type: clean(match.group(2)),
            self._KEY_column_null: (not 'NOT NULL' in line)
        }


def main():
    p = SQLParser()

    sql = """CREATE TABLE pokemon_evolution (
        id INTEGER NOT NULL,
        evolved_species_id INTEGER NOT NULL,
        evolution_trigger_id INTEGER NOT NULL,
        trigger_item_id INTEGER,
        minimum_level INTEGER,
        gender_id INTEGER,
        location_id INTEGER,
        held_item_id INTEGER,
        time_of_day VARCHAR(5),
        known_move_id INTEGER,
        known_move_type_id INTEGER,
        minimum_happiness INTEGER,
        minimum_beauty INTEGER,
        minimum_affection INTEGER,
        relative_physical_stats INTEGER,
        party_species_id INTEGER,
        party_type_id INTEGER,
        trade_species_id INTEGER,
        needs_overworld_rain BOOLEAN NOT NULL,
        turn_upside_down BOOLEAN NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY(evolved_species_id) REFERENCES pokemon_species (id),
        FOREIGN KEY(evolution_trigger_id) REFERENCES evolution_triggers (id),
        FOREIGN KEY(trigger_item_id) REFERENCES items (id),
        FOREIGN KEY(gender_id) REFERENCES genders (id),
        FOREIGN KEY(location_id) REFERENCES locations (id),
        FOREIGN KEY(held_item_id) REFERENCES items (id),
        CONSTRAINT pokemon_evolution_time_of_day CHECK (time_of_day IN ('day', 'night')),
        FOREIGN KEY(known_move_id) REFERENCES moves (id),
        FOREIGN KEY(known_move_type_id) REFERENCES types (id),
        FOREIGN KEY(party_species_id) REFERENCES pokemon_species (id),
        FOREIGN KEY(party_type_id) REFERENCES types (id),
        FOREIGN KEY(trade_species_id) REFERENCES pokemon_species (id),
        CHECK (needs_overworld_rain IN (0, 1)),
        CHECK (turn_upside_down IN (0, 1))
    )"""

    print p.get_metadata(sql)

    return 0

if __name__ == '__main__':
    main()
