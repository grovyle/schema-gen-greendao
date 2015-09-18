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

import com.company.professor.MoveTargetProse;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "move_target_prose".
*/
public class MoveTargetProseDao extends AbstractDao<MoveTargetProse, Long> {

    public static final String TABLENAME = "move_target_prose";

    /**
     * Properties of entity MoveTargetProse.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property MoveTargetId = new Property(0, long.class, "MoveTargetId", true, "move_target_id");
        public final static Property LocalLanguageId = new Property(1, long.class, "LocalLanguageId", false, "local_language_id");
        public final static Property Name = new Property(2, String.class, "Name", false, "name");
        public final static Property Description = new Property(3, String.class, "Description", false, "description");
    };

    private DaoSession daoSession;


    public MoveTargetProseDao(DaoConfig config) {
        super(config);
    }
    
    public MoveTargetProseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"move_target_prose\" (" + //
                "\"move_target_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: MoveTargetId
                "\"local_language_id\" INTEGER NOT NULL ," + // 1: LocalLanguageId
                "\"name\" TEXT," + // 2: Name
                "\"description\" TEXT);"); // 3: Description
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_move_target_prose_move_target_id_local_language_id ON move_target_prose" +
                " (\"move_target_id\",\"local_language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"move_target_prose\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MoveTargetProse entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getMoveTargetId());
        stmt.bindLong(2, entity.getLocalLanguageId());
 
        String Name = entity.getName();
        if (Name != null) {
            stmt.bindString(3, Name);
        }
 
        String Description = entity.getDescription();
        if (Description != null) {
            stmt.bindString(4, Description);
        }
    }

    @Override
    protected void attachEntity(MoveTargetProse entity) {
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
    public MoveTargetProse readEntity(Cursor cursor, int offset) {
        MoveTargetProse entity = new MoveTargetProse( //
            cursor.getLong(offset + 0), // MoveTargetId
            cursor.getLong(offset + 1), // LocalLanguageId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // Description
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MoveTargetProse entity, int offset) {
        entity.setMoveTargetId(cursor.getLong(offset + 0));
        entity.setLocalLanguageId(cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDescription(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MoveTargetProse entity, long rowId) {
        entity.setMoveTargetId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MoveTargetProse entity) {
        if(entity != null) {
            return entity.getMoveTargetId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getMoveTargetsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM move_target_prose T");
            builder.append(" LEFT JOIN move_targets T0 ON T.\"move_target_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN languages T1 ON T.\"local_language_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected MoveTargetProse loadCurrentDeep(Cursor cursor, boolean lock) {
        MoveTargetProse entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        MoveTargets MoveTargets = loadCurrentOther(daoSession.getMoveTargetsDao(), cursor, offset);
         if(MoveTargets != null) {
            entity.setMoveTargets(MoveTargets);
        }
        offset += daoSession.getMoveTargetsDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public MoveTargetProse loadDeep(Long key) {
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
    public List<MoveTargetProse> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<MoveTargetProse> list = new ArrayList<MoveTargetProse>(count);
        
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
    
    protected List<MoveTargetProse> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<MoveTargetProse> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}