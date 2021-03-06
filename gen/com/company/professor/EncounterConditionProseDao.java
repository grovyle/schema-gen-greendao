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

import com.company.professor.EncounterConditionProse;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "encounter_condition_prose".
*/
public class EncounterConditionProseDao extends AbstractDao<EncounterConditionProse, Long> {

    public static final String TABLENAME = "encounter_condition_prose";

    /**
     * Properties of entity EncounterConditionProse.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property EncounterConditionId = new Property(0, long.class, "EncounterConditionId", true, "encounter_condition_id");
        public final static Property LocalLanguageId = new Property(1, long.class, "LocalLanguageId", false, "local_language_id");
        public final static Property Name = new Property(2, String.class, "Name", false, "name");
    };

    private DaoSession daoSession;


    public EncounterConditionProseDao(DaoConfig config) {
        super(config);
    }
    
    public EncounterConditionProseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"encounter_condition_prose\" (" + //
                "\"encounter_condition_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: EncounterConditionId
                "\"local_language_id\" INTEGER NOT NULL ," + // 1: LocalLanguageId
                "\"name\" TEXT NOT NULL );"); // 2: Name
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_encounter_condition_prose_encounter_condition_id_local_language_id ON encounter_condition_prose" +
                " (\"encounter_condition_id\",\"local_language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"encounter_condition_prose\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, EncounterConditionProse entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getEncounterConditionId());
        stmt.bindLong(2, entity.getLocalLanguageId());
        stmt.bindString(3, entity.getName());
    }

    @Override
    protected void attachEntity(EncounterConditionProse entity) {
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
    public EncounterConditionProse readEntity(Cursor cursor, int offset) {
        EncounterConditionProse entity = new EncounterConditionProse( //
            cursor.getLong(offset + 0), // EncounterConditionId
            cursor.getLong(offset + 1), // LocalLanguageId
            cursor.getString(offset + 2) // Name
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, EncounterConditionProse entity, int offset) {
        entity.setEncounterConditionId(cursor.getLong(offset + 0));
        entity.setLocalLanguageId(cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(EncounterConditionProse entity, long rowId) {
        entity.setEncounterConditionId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(EncounterConditionProse entity) {
        if(entity != null) {
            return entity.getEncounterConditionId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getEncounterConditionsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM encounter_condition_prose T");
            builder.append(" LEFT JOIN encounter_conditions T0 ON T.\"encounter_condition_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN languages T1 ON T.\"local_language_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected EncounterConditionProse loadCurrentDeep(Cursor cursor, boolean lock) {
        EncounterConditionProse entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        EncounterConditions EncounterConditions = loadCurrentOther(daoSession.getEncounterConditionsDao(), cursor, offset);
         if(EncounterConditions != null) {
            entity.setEncounterConditions(EncounterConditions);
        }
        offset += daoSession.getEncounterConditionsDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public EncounterConditionProse loadDeep(Long key) {
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
    public List<EncounterConditionProse> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<EncounterConditionProse> list = new ArrayList<EncounterConditionProse>(count);
        
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
    
    protected List<EncounterConditionProse> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<EncounterConditionProse> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
