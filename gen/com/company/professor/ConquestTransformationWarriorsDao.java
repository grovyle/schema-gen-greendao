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

import com.company.professor.ConquestTransformationWarriors;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "conquest_transformation_warriors".
*/
public class ConquestTransformationWarriorsDao extends AbstractDao<ConquestTransformationWarriors, Long> {

    public static final String TABLENAME = "conquest_transformation_warriors";

    /**
     * Properties of entity ConquestTransformationWarriors.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property TransformationId = new Property(0, long.class, "TransformationId", true, "transformation_id");
        public final static Property PresentWarriorId = new Property(1, long.class, "PresentWarriorId", false, "present_warrior_id");
    };

    private DaoSession daoSession;


    public ConquestTransformationWarriorsDao(DaoConfig config) {
        super(config);
    }
    
    public ConquestTransformationWarriorsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"conquest_transformation_warriors\" (" + //
                "\"transformation_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: TransformationId
                "\"present_warrior_id\" INTEGER NOT NULL );"); // 1: PresentWarriorId
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_conquest_transformation_warriors_transformation_id_present_warrior_id ON conquest_transformation_warriors" +
                " (\"transformation_id\",\"present_warrior_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"conquest_transformation_warriors\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ConquestTransformationWarriors entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getTransformationId());
        stmt.bindLong(2, entity.getPresentWarriorId());
    }

    @Override
    protected void attachEntity(ConquestTransformationWarriors entity) {
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
    public ConquestTransformationWarriors readEntity(Cursor cursor, int offset) {
        ConquestTransformationWarriors entity = new ConquestTransformationWarriors( //
            cursor.getLong(offset + 0), // TransformationId
            cursor.getLong(offset + 1) // PresentWarriorId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ConquestTransformationWarriors entity, int offset) {
        entity.setTransformationId(cursor.getLong(offset + 0));
        entity.setPresentWarriorId(cursor.getLong(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ConquestTransformationWarriors entity, long rowId) {
        entity.setTransformationId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ConquestTransformationWarriors entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getConquestWarriorsDao().getAllColumns());
            builder.append(" FROM conquest_transformation_warriors T");
            builder.append(" LEFT JOIN conquest_warriors T0 ON T.\"present_warrior_id\"=T0.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ConquestTransformationWarriors loadCurrentDeep(Cursor cursor, boolean lock) {
        ConquestTransformationWarriors entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        ConquestWarriors ConquestWarriors = loadCurrentOther(daoSession.getConquestWarriorsDao(), cursor, offset);
         if(ConquestWarriors != null) {
            entity.setConquestWarriors(ConquestWarriors);
        }

        return entity;    
    }

    public ConquestTransformationWarriors loadDeep(Long key) {
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
    public List<ConquestTransformationWarriors> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ConquestTransformationWarriors> list = new ArrayList<ConquestTransformationWarriors>(count);
        
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
    
    protected List<ConquestTransformationWarriors> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ConquestTransformationWarriors> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}