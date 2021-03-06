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

import com.company.professor.ConquestTransformationPokemon;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "conquest_transformation_pokemon".
*/
public class ConquestTransformationPokemonDao extends AbstractDao<ConquestTransformationPokemon, Long> {

    public static final String TABLENAME = "conquest_transformation_pokemon";

    /**
     * Properties of entity ConquestTransformationPokemon.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property TransformationId = new Property(0, long.class, "TransformationId", true, "transformation_id");
        public final static Property PokemonSpeciesId = new Property(1, long.class, "PokemonSpeciesId", false, "pokemon_species_id");
    };

    private DaoSession daoSession;


    public ConquestTransformationPokemonDao(DaoConfig config) {
        super(config);
    }
    
    public ConquestTransformationPokemonDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"conquest_transformation_pokemon\" (" + //
                "\"transformation_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: TransformationId
                "\"pokemon_species_id\" INTEGER NOT NULL );"); // 1: PokemonSpeciesId
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_conquest_transformation_pokemon_transformation_id_pokemon_species_id ON conquest_transformation_pokemon" +
                " (\"transformation_id\",\"pokemon_species_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"conquest_transformation_pokemon\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ConquestTransformationPokemon entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getTransformationId());
        stmt.bindLong(2, entity.getPokemonSpeciesId());
    }

    @Override
    protected void attachEntity(ConquestTransformationPokemon entity) {
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
    public ConquestTransformationPokemon readEntity(Cursor cursor, int offset) {
        ConquestTransformationPokemon entity = new ConquestTransformationPokemon( //
            cursor.getLong(offset + 0), // TransformationId
            cursor.getLong(offset + 1) // PokemonSpeciesId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ConquestTransformationPokemon entity, int offset) {
        entity.setTransformationId(cursor.getLong(offset + 0));
        entity.setPokemonSpeciesId(cursor.getLong(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ConquestTransformationPokemon entity, long rowId) {
        entity.setTransformationId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ConquestTransformationPokemon entity) {
        if(entity != null) {
            return entity.getTransformationId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getPokemonSpeciesDao().getAllColumns());
            builder.append(" FROM conquest_transformation_pokemon T");
            builder.append(" LEFT JOIN pokemon_species T0 ON T.\"pokemon_species_id\"=T0.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ConquestTransformationPokemon loadCurrentDeep(Cursor cursor, boolean lock) {
        ConquestTransformationPokemon entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        PokemonSpecies PokemonSpecies = loadCurrentOther(daoSession.getPokemonSpeciesDao(), cursor, offset);
         if(PokemonSpecies != null) {
            entity.setPokemonSpecies(PokemonSpecies);
        }

        return entity;    
    }

    public ConquestTransformationPokemon loadDeep(Long key) {
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
    public List<ConquestTransformationPokemon> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ConquestTransformationPokemon> list = new ArrayList<ConquestTransformationPokemon>(count);
        
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
    
    protected List<ConquestTransformationPokemon> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ConquestTransformationPokemon> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
