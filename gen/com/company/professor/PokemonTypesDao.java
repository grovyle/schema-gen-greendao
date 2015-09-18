package com.company.professor;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import com.company.professor.PokemonTypes;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "pokemon_types".
*/
public class PokemonTypesDao extends AbstractDao<PokemonTypes, Long> {

    public static final String TABLENAME = "pokemon_types";

    /**
     * Properties of entity PokemonTypes.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property PokemonId = new Property(0, long.class, "PokemonId", true, "pokemon_id");
        public final static Property TypeId = new Property(1, long.class, "TypeId", false, "type_id");
        public final static Property Slot = new Property(2, long.class, "Slot", false, "slot");
    };

    private DaoSession daoSession;


    public PokemonTypesDao(DaoConfig config) {
        super(config);
    }
    
    public PokemonTypesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"pokemon_types\" (" + //
                "\"pokemon_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: PokemonId
                "\"type_id\" INTEGER NOT NULL ," + // 1: TypeId
                "\"slot\" INTEGER NOT NULL );"); // 2: Slot
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_pokemon_types_pokemon_id_slot ON pokemon_types" +
                " (\"pokemon_id\",\"slot\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"pokemon_types\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PokemonTypes entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPokemonId());
        stmt.bindLong(2, entity.getTypeId());
        stmt.bindLong(3, entity.getSlot());
    }

    @Override
    protected void attachEntity(PokemonTypes entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public PokemonTypes readEntity(Cursor cursor, int offset) {
        PokemonTypes entity = new PokemonTypes( //
            cursor.getLong(offset + 0), // PokemonId
            cursor.getLong(offset + 1), // TypeId
            cursor.getLong(offset + 2) // Slot
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PokemonTypes entity, int offset) {
        entity.setPokemonId(cursor.getLong(offset + 0));
        entity.setTypeId(cursor.getLong(offset + 1));
        entity.setSlot(cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PokemonTypes entity, long rowId) {
        entity.setPokemonId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PokemonTypes entity) {
        if(entity != null) {
            return entity.getPokemonId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getPokemonDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getTypesDao().getAllColumns());
            builder.append(" FROM pokemon_types T");
            builder.append(" LEFT JOIN pokemon T0 ON T.\"pokemon_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN types T1 ON T.\"type_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PokemonTypes loadCurrentDeep(Cursor cursor, boolean lock) {
        PokemonTypes entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Pokemon Pokemon = loadCurrentOther(daoSession.getPokemonDao(), cursor, offset);
         if(Pokemon != null) {
            entity.setPokemon(Pokemon);
        }
        offset += daoSession.getPokemonDao().getAllColumns().length;

        Types Types = loadCurrentOther(daoSession.getTypesDao(), cursor, offset);
         if(Types != null) {
            entity.setTypes(Types);
        }

        return entity;    
    }

    public PokemonTypes loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<PokemonTypes> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PokemonTypes> list = new ArrayList<PokemonTypes>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<PokemonTypes> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PokemonTypes> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}