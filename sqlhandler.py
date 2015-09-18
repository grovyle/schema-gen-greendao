#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  sqlitehandler.py
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
import sqlite3 as lite


class SQLHandler(object):
    path_db = ""
    conn = None
    cursor = None

    def __init__(self, path):
        self.path_db = path
        return

    def __enter__(self):
        return self

    def __exit__(self, exc_type, exc_value, traceback):
        if self.conn:
            self.conn.close()
        return

    def get_connection(self):
        if not self.conn:
            self.conn = lite.connect(self.path_db)
            self.conn.row_factory = lite.Row
        return self.conn

    def get_cursor(self):
        if not self.cursor:
            self.cursor = self.get_connection().cursor()
        return self.cursor

    def _execute(self, sql):
        try:
            self.get_cursor().execute(sql)
            return self.get_cursor().fetchall()

        except lite.Error, e:
            print "Error %s:" % e.args[0]
            return None

    def get_tables(self):
        return self._execute(
            "SELECT * FROM sqlite_master WHERE type = 'table';"
        )

    def get_schema(self):
        return {t['name']: t['sql'] for t in self.get_tables()}


def main():
    h = SQLHandler('pokedex.sqlite')

    print h.get_schema()

    return 0

if __name__ == '__main__':
    main()
