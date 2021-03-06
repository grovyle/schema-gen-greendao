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

import com.company.professor.ConquestPokemonStats;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "conquest_pokemon_stats".
*/
public class ConquestPokemonStatsDao extends AbstractDao<ConquestPokemonStats, Long> {

    public static final String TABLENAME = "conquest_pokemon_stats";

    /**
     * Properties of entity ConquestPokemonStats.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property PokemonSpeciesId = new Property(0, long.class, "PokemonSpeciesId", true, "pokemon_species_id");
        public final static Property ConquestStatId = new Property(1, long.class, "ConquestStatId", false, "conquest_stat_id");
        public final static Property BaseStat = new Property(2, long.class, "BaseStat", false, "base_stat");
    };

    private DaoSession daoSession;


    public ConquestPokemonStatsDao(DaoConfig config) {
        super(config);
    }
    
    public ConquestPokemonStatsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"conquest_pokemon_stats\" (" + //
                "\"pokemon_species_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: PokemonSpeciesId
                "\"conquest_stat_id\" INTEGER NOT NULL ," + // 1: ConquestStatId
                "\"base_stat\" INTEGER NOT NULL );"); // 2: BaseStat
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_conquest_pokemon_stats_pokemon_species_id_conquest_stat_id ON conquest_pokemon_stats" +
                " (\"pokemon_species_id\",\"conquest_stat_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"conquest_pokemon_stats\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ConquestPokemonStats entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPokemonSpeciesId());
        stmt.bindLong(2, entity.getConquestStatId());
        stmt.bindLong(3, entity.getBaseStat());
    }

    @Override
    protected void attachEntity(ConquestPokemonStats entity) {
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
    public ConquestPokemonStats readEntity(Cursor cursor, int offset) {
        ConquestPokemonStats entity = new ConquestPokemonStats( //
            cursor.getLong(offset + 0), // PokemonSpeciesId
            cursor.getLong(offset + 1), // ConquestStatId
            cursor.getLong(offset + 2) // BaseStat
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ConquestPokemonStats entity, int offset) {
        entity.setPokemonSpeciesId(cursor.getLong(offset + 0));
        entity.setConquestStatId(cursor.getLong(offset + 1));
        entity.setBaseStat(cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ConquestPokemonStats entity, long rowId) {
        entity.setPokemonSpeciesId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ConquestPokemonStats entity) {
        if(entity != null) {
            return entity.getPokemonSpeciesId();
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
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getConquestStatsDao().getAllColumns());
            builder.append(" FROM conquest_pokemon_stats T");
            builder.append(" LEFT JOIN pokemon_species T0 ON T.\"pokemon_species_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN conquest_stats T1 ON T.\"conquest_stat_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ConquestPokemonStats loadCurrentDeep(Cursor cursor, boolean lock) {
        ConquestPokemonStats entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        PokemonSpecies PokemonSpecies = loadCurrentOther(daoSession.getPokemonSpeciesDao(), cursor, offset);
         if(PokemonSpecies != null) {
            entity.setPokemonSpecies(PokemonSpecies);
        }
        offset += daoSession.getPokemonSpeciesDao().getAllColumns().length;

        ConquestStats ConquestStats = loadCurrentOther(daoSession.getConquestStatsDao(), cursor, offset);
         if(ConquestStats != null) {
            entity.setConquestStats(ConquestStats);
        }

        return entity;    
    }

    public ConquestPokemonStats loadDeep(Long key) {
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
    public List<ConquestPokemonStats> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ConquestPokemonStats> list = new ArrayList<ConquestPokemonStats>(count);
        
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
    
    protected List<ConquestPokemonStats> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ConquestPokemonStats> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
