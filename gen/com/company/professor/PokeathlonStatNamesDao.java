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

import com.company.professor.PokeathlonStatNames;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "pokeathlon_stat_names".
*/
public class PokeathlonStatNamesDao extends AbstractDao<PokeathlonStatNames, Long> {

    public static final String TABLENAME = "pokeathlon_stat_names";

    /**
     * Properties of entity PokeathlonStatNames.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property PokeathlonStatId = new Property(0, long.class, "PokeathlonStatId", true, "pokeathlon_stat_id");
        public final static Property LocalLanguageId = new Property(1, long.class, "LocalLanguageId", false, "local_language_id");
        public final static Property Name = new Property(2, String.class, "Name", false, "name");
    };

    private DaoSession daoSession;


    public PokeathlonStatNamesDao(DaoConfig config) {
        super(config);
    }
    
    public PokeathlonStatNamesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"pokeathlon_stat_names\" (" + //
                "\"pokeathlon_stat_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: PokeathlonStatId
                "\"local_language_id\" INTEGER NOT NULL ," + // 1: LocalLanguageId
                "\"name\" TEXT NOT NULL );"); // 2: Name
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_pokeathlon_stat_names_pokeathlon_stat_id_local_language_id ON pokeathlon_stat_names" +
                " (\"pokeathlon_stat_id\",\"local_language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"pokeathlon_stat_names\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PokeathlonStatNames entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPokeathlonStatId());
        stmt.bindLong(2, entity.getLocalLanguageId());
        stmt.bindString(3, entity.getName());
    }

    @Override
    protected void attachEntity(PokeathlonStatNames entity) {
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
    public PokeathlonStatNames readEntity(Cursor cursor, int offset) {
        PokeathlonStatNames entity = new PokeathlonStatNames( //
            cursor.getLong(offset + 0), // PokeathlonStatId
            cursor.getLong(offset + 1), // LocalLanguageId
            cursor.getString(offset + 2) // Name
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PokeathlonStatNames entity, int offset) {
        entity.setPokeathlonStatId(cursor.getLong(offset + 0));
        entity.setLocalLanguageId(cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PokeathlonStatNames entity, long rowId) {
        entity.setPokeathlonStatId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PokeathlonStatNames entity) {
        if(entity != null) {
            return entity.getPokeathlonStatId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getPokeathlonStatsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM pokeathlon_stat_names T");
            builder.append(" LEFT JOIN pokeathlon_stats T0 ON T.\"pokeathlon_stat_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN languages T1 ON T.\"local_language_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PokeathlonStatNames loadCurrentDeep(Cursor cursor, boolean lock) {
        PokeathlonStatNames entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        PokeathlonStats PokeathlonStats = loadCurrentOther(daoSession.getPokeathlonStatsDao(), cursor, offset);
         if(PokeathlonStats != null) {
            entity.setPokeathlonStats(PokeathlonStats);
        }
        offset += daoSession.getPokeathlonStatsDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public PokeathlonStatNames loadDeep(Long key) {
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
    public List<PokeathlonStatNames> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PokeathlonStatNames> list = new ArrayList<PokeathlonStatNames>(count);
        
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
    
    protected List<PokeathlonStatNames> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PokeathlonStatNames> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
