#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  daotranslater.py
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
from sqlparser import SQLParser as sqlp


class DAOTranslator(object):
    _NAME_TABLE = 'T{0}'
    _NAME_COLUMN = 'T{0}C{1}'
    _NAME_INDEX = 'I_T{0}_C{1}'
    _NAME_TOONE = 'TO_FT{0}_TT{1}_BC{2}'
    _NAME_TOMANY = 'TM_FT{0}_TT{1}_BC{2}'

    def __init__(self):
        return

    def translate_metadata(self, metas):
        order = self._resolve_order(metas)

        body = []
        for table in order:
            meta = metas[table]

            section = ['//{0} {1} {2}'.format('='*5, table, '='*32)]
            section.extend(self._translate_metadata_table(meta))
            section.extend(self._translate_metadata_columns(meta))
            section.extend(self._translate_metadata_primary_keys(meta))
            section.extend(self._translate_metadata_unique_keys(meta))
            section.append('')

            body.extend(section)

        for table in order:
            meta = metas[table]

            foreign_keys = self._translate_metadata_foreign_keys(meta)
            if foreign_keys:
                foreign_keys.insert(
                    0, '//{0} {1} {2}'.format('='*5, table, '='*32)
                )
                body.extend(foreign_keys)

        # Indent lines
        body = ['\t'+line for line in body]

        return '\n'.join(body)

    def _resolve_order(self, metas):
        order = metas.keys()
        for table, meta in metas.iteritems():
            if not sqlp._KEY_foreign in meta or not meta[sqlp._KEY_foreign]:
                continue

            dependent_tables = []
            for fkey in meta[sqlp._KEY_foreign]:
                dependent_tables.append(fkey[sqlp._KEY_foreign_table])

            minimum = None
            for dependent in dependent_tables:
                dependent_index = order.index(dependent)
                if minimum is None or dependent_index < minimum:
                    minimum = dependent_index

            index = order.index(table)
            if minimum < index:
                order.remove(table)
                order.insert(minimum, table)

        return order

    def _translate_metadata_table(self, meta):
        table = meta[sqlp._KEY_table]
        qal_name = self._get_normalized_name(table)
        var_name = self._get_name_table(table)
        return [
            'Entity {0} = schema.addEntity("{1}");'.format(
                var_name, qal_name
            ),
            '{0}.setTableName("{1}");'.format(var_name, table)
        ]

    def _translate_metadata_columns(self, meta):
        lines = []
        for column in meta[sqlp._KEY_column]:
            lines.extend(
                self._translate_metadata_column(
                    meta[sqlp._KEY_table], column, meta
                )
            )
        return lines

    def _translate_metadata_column(self, table, column, meta):
        name = column[sqlp._KEY_column_name]

        var_table = self._get_name_table(table)
        var_column = self._get_name_column(table, name)

        data_type = self._translate_sql_datatype(column[sqlp._KEY_column_type])

        null = '.notNull()' if not column[sqlp._KEY_column_null] else ''

        primary_key = ''
        pk_column = self._primary_key_for_table(meta)
        if pk_column == name:
            primary_key = '.primaryKey()'

        return [
            'Property {0} = {1}.add{2}Property("{3}").columnName("{4}")'
            '{5}{6}.getProperty();'.format(
                var_column, var_table, data_type,
                self._get_normalized_name(name), name,
                primary_key, null
            )
        ]

    def _translate_metadata_primary_keys(self, meta):
        if not sqlp._KEY_primary in meta:
            return []

        lines = ['']
        for primary_key in meta[sqlp._KEY_primary]:
            lines.extend(
                self._translate_metadata_primary_key(
                    meta[sqlp._KEY_table], primary_key
                )
            )
        return lines

    def _translate_metadata_primary_key(self, table, primary_key):
        if len(primary_key) == 1:
            return []

        return self._create_unique_index(table, primary_key)

    def _translate_metadata_foreign_keys(self, meta):
        if not sqlp._KEY_foreign in meta:
            return []

        counts = self._count_foreign_key_tables(meta)

        lines = []
        for foreign_key in meta[sqlp._KEY_foreign]:
            lines.extend(
                self._translate_metadata_foreign_key(
                    meta[sqlp._KEY_table], foreign_key, counts
                )
            )
        return lines

    def _translate_metadata_foreign_key(self, table, foreign_key, counts):
        is_one = self._is_foreign_key_to_one(foreign_key)

        if is_one:
            var_type = 'ToOne'
            f_name = self._get_name_toone
        else:
            var_type = 'ToMany'
            f_name = self._get_name_tomany

        foreign_table = foreign_key[sqlp._KEY_foreign_table]
        foreign_table_name = self._get_name_table(foreign_table)

        column = foreign_key[sqlp._KEY_foreign_local]
        column_name = self._get_name_column(table, column)

        var_rel = f_name(table, foreign_table, column)

        if counts[foreign_table] > 1:
            join_name = self._get_stripped_name(column)
        else:
            join_name = self._get_normalized_name(foreign_table)

        return [
            '{0} {1} = {2}.add{0}({3}, {4});'.format(
                var_type, var_rel, self._get_name_table(table),
                foreign_table_name, column_name
            ),
            '{0}.setName("{1}");\n'.format(
                var_rel, join_name
            )
        ]

    def _translate_metadata_unique_keys(self, meta):
        if not sqlp._KEY_unique in meta:
            return []

        lines = ['']
        for unique_key in meta[sqlp._KEY_unique]:
            lines.extend(
                self._create_unique_index(
                    meta[sqlp._KEY_table], unique_key
                )
            )
        return lines

    def _count_foreign_key_tables(self, meta):
        count = {}
        for foreign_key in meta[sqlp._KEY_foreign]:
            table = foreign_key[sqlp._KEY_foreign_table]
            if not table in count:
                count[table] = 0
            count[table] += 1
        return count

    def _create_unique_index(self, table, columns):
        var_index = self._get_name_index(table, columns)

        lines = ['Index {0} = new Index();'.format(var_index)]
        for column in columns:
            lines.append(
                '{0}.addProperty({1});'.format(
                    var_index, self._get_name_column(table, column)
                )
            )

        lines.extend([
            '{0}.makeUnique();'.format(var_index),
            '{0}.addIndex({1});'.format(
                self._get_name_table(table), var_index
            )
        ])
        return lines

    def _is_column_sole_primary_key(self, column, meta):
        search = [column[sqlp._KEY_column_name]]
        for primary_key in meta[sqlp._KEY_primary]:
            if search == primary_key:
                return True
        return False

    def _primary_key_for_table(self, meta):
        for column in meta[sqlp._KEY_column]:
            if self._is_column_sole_primary_key(column, meta):
                return column[sqlp._KEY_column_name]
        if sqlp._KEY_primary in meta and meta[sqlp._KEY_primary]:
            return meta[sqlp._KEY_primary][0][0]

        return None

    def _is_foreign_key_to_one(self, foreign_key):
        return foreign_key[sqlp._KEY_foreign_field].lower() == 'id'

    def _translate_sql_datatype(self, datatype):
        if 'SMALLINT' in datatype:
            return 'Int'
        elif 'INTEGER' in datatype:
            return 'Long'
        elif 'BOOLEAN' in datatype:
            return 'Boolean'
        elif 'VARCHAR' in datatype:
            return 'String'
        elif 'TEXT' in datatype:
            return 'String'
        else:
            raise ValueError("Could not determine field type: " + datatype)

    def _get_stripped_name(self, name):
        stripped = name.replace('_id', '')
        return self._get_normalized_name(stripped)

    def _get_normalized_name(self, name):
        return ''.join([i[0].upper() + i[1:] for i in name.split('_')])

    def _get_name_table(self, table):
        return self._NAME_TABLE.format(self._get_normalized_name(table))

    def _get_name_column(self, table, column):
        return self._NAME_COLUMN.format(
            self._get_normalized_name(table),
            self._get_normalized_name(column)
        )

    def _get_name_index(self, table, columns):
        return self._NAME_INDEX.format(
            self._get_normalized_name(table),
            ''.join([self._get_normalized_name(c) for c in columns])
        )

    def _get_name_toone(self, from_table, to_table, by_column):
        return self._NAME_TOONE.format(
            self._get_normalized_name(from_table),
            self._get_normalized_name(to_table),
            self._get_normalized_name(by_column)
        )

    def _get_name_tomany(self, from_table, to_table, by_column):
        return self._NAME_TOMANY.format(
            self._get_normalized_name(from_table),
            self._get_normalized_name(to_table),
            self._get_normalized_name(by_column)
        )


def main():
    data = {
        "abilities": {
            "checks": [
                "CHECK (is_main_series IN (0, 1))"
            ],
            "columns": [
                {
                    "name": "id",
                    "null": False,
                    "type": "INTEGER"
                },
                {
                    "name": "identifier",
                    "null": False,
                    "type": "VARCHAR(79)"
                },
                {
                    "name": "generation_id",
                    "null": False,
                    "type": "INTEGER"
                },
                {
                    "name": "is_main_series",
                    "null": False,
                    "type": "BOOLEAN"
                }
            ],
            "foregin_keys": [
                {
                    "field": "id",
                    "local": "generation_id",
                    "table": "generations"
                }
            ],
            "primary_keys": [
                [
                    "id"
                ]
            ],
            "table": "abilities"
        }
    }

    t = DAOTranslator()

    print t.translate_metadata(data)

    return 0

if __name__ == '__main__':
    main()
