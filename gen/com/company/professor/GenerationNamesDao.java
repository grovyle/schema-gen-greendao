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

import com.company.professor.GenerationNames;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "generation_names".
*/
public class GenerationNamesDao extends AbstractDao<GenerationNames, Long> {

    public static final String TABLENAME = "generation_names";

    /**
     * Properties of entity GenerationNames.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property GenerationId = new Property(0, long.class, "GenerationId", true, "generation_id");
        public final static Property LocalLanguageId = new Property(1, long.class, "LocalLanguageId", false, "local_language_id");
        public final static Property Name = new Property(2, String.class, "Name", false, "name");
    };

    private DaoSession daoSession;


    public GenerationNamesDao(DaoConfig config) {
        super(config);
    }
    
    public GenerationNamesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"generation_names\" (" + //
                "\"generation_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: GenerationId
                "\"local_language_id\" INTEGER NOT NULL ," + // 1: LocalLanguageId
                "\"name\" TEXT NOT NULL );"); // 2: Name
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_generation_names_generation_id_local_language_id ON generation_names" +
                " (\"generation_id\",\"local_language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"generation_names\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, GenerationNames entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getGenerationId());
        stmt.bindLong(2, entity.getLocalLanguageId());
        stmt.bindString(3, entity.getName());
    }

    @Override
    protected void attachEntity(GenerationNames entity) {
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
    public GenerationNames readEntity(Cursor cursor, int offset) {
        GenerationNames entity = new GenerationNames( //
            cursor.getLong(offset + 0), // GenerationId
            cursor.getLong(offset + 1), // LocalLanguageId
            cursor.getString(offset + 2) // Name
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, GenerationNames entity, int offset) {
        entity.setGenerationId(cursor.getLong(offset + 0));
        entity.setLocalLanguageId(cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(GenerationNames entity, long rowId) {
        entity.setGenerationId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(GenerationNames entity) {
        if(entity != null) {
            return entity.getGenerationId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getGenerationsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM generation_names T");
            builder.append(" LEFT JOIN generations T0 ON T.\"generation_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN languages T1 ON T.\"local_language_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected GenerationNames loadCurrentDeep(Cursor cursor, boolean lock) {
        GenerationNames entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Generations Generations = loadCurrentOther(daoSession.getGenerationsDao(), cursor, offset);
         if(Generations != null) {
            entity.setGenerations(Generations);
        }
        offset += daoSession.getGenerationsDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public GenerationNames loadDeep(Long key) {
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
    public List<GenerationNames> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<GenerationNames> list = new ArrayList<GenerationNames>(count);
        
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
    
    protected List<GenerationNames> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<GenerationNames> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
