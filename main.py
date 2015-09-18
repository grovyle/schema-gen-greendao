#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  main.py
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
from sqlhandler import SQLHandler
from sqlparser import SQLParser
from daotranslater import DAOTranslator
import json


def generate_java_class(name, body, path):
    path_template = 'DAOGenerator.java'
    with open(path_template, 'r') as f:
        template = f.read()

    content = template.replace("$schema_name$", name).replace(
        "$schema_body$", body).replace("$schema_path$", path)

    with open('My' + path_template, 'w') as f:
        f.write(content)

    return


def main():
    with SQLHandler('pokedex.sqlite') as h:
        tables = h.get_schema()

    p = SQLParser()

    metas = {}
    for name, sql in tables.iteritems():
        meta = p.get_metadata(sql)
        metas[meta[p._KEY_table]] = meta

    with open('meta.json', 'w') as f:
        f.write(
            json.dumps(
                metas, sort_keys=True, indent=4, separators=(',', ': ')
            )
        )

    t = DAOTranslator()
    name = 'com.kevinramdath.professor'
    body = t.translate_metadata(metas)
    path = 'gen'

    generate_java_class(name, body, path)

    return 0

if __name__ == '__main__':
    main()
