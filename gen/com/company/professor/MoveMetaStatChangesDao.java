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

import com.company.professor.MoveMetaStatChanges;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "move_meta_stat_changes".
*/
public class MoveMetaStatChangesDao extends AbstractDao<MoveMetaStatChanges, Long> {

    public static final String TABLENAME = "move_meta_stat_changes";

    /**
     * Properties of entity MoveMetaStatChanges.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property MoveId = new Property(0, long.class, "MoveId", true, "move_id");
        public final static Property StatId = new Property(1, long.class, "StatId", false, "stat_id");
        public final static Property Change = new Property(2, long.class, "Change", false, "change");
    };

    private DaoSession daoSession;


    public MoveMetaStatChangesDao(DaoConfig config) {
        super(config);
    }
    
    public MoveMetaStatChangesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"move_meta_stat_changes\" (" + //
                "\"move_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: MoveId
                "\"stat_id\" INTEGER NOT NULL ," + // 1: StatId
                "\"change\" INTEGER NOT NULL );"); // 2: Change
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_move_meta_stat_changes_move_id_stat_id ON move_meta_stat_changes" +
                " (\"move_id\",\"stat_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"move_meta_stat_changes\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MoveMetaStatChanges entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getMoveId());
        stmt.bindLong(2, entity.getStatId());
        stmt.bindLong(3, entity.getChange());
    }

    @Override
    protected void attachEntity(MoveMetaStatChanges entity) {
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
    public MoveMetaStatChanges readEntity(Cursor cursor, int offset) {
        MoveMetaStatChanges entity = new MoveMetaStatChanges( //
            cursor.getLong(offset + 0), // MoveId
            cursor.getLong(offset + 1), // StatId
            cursor.getLong(offset + 2) // Change
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MoveMetaStatChanges entity, int offset) {
        entity.setMoveId(cursor.getLong(offset + 0));
        entity.setStatId(cursor.getLong(offset + 1));
        entity.setChange(cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MoveMetaStatChanges entity, long rowId) {
        entity.setMoveId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MoveMetaStatChanges entity) {
        if(entity != null) {
            return entity.getMoveId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getMovesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getStatsDao().getAllColumns());
            builder.append(" FROM move_meta_stat_changes T");
            builder.append(" LEFT JOIN moves T0 ON T.\"move_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN stats T1 ON T.\"stat_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected MoveMetaStatChanges loadCurrentDeep(Cursor cursor, boolean lock) {
        MoveMetaStatChanges entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Moves Moves = loadCurrentOther(daoSession.getMovesDao(), cursor, offset);
         if(Moves != null) {
            entity.setMoves(Moves);
        }
        offset += daoSession.getMovesDao().getAllColumns().length;

        Stats Stats = loadCurrentOther(daoSession.getStatsDao(), cursor, offset);
         if(Stats != null) {
            entity.setStats(Stats);
        }

        return entity;    
    }

    public MoveMetaStatChanges loadDeep(Long key) {
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
    public List<MoveMetaStatChanges> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<MoveMetaStatChanges> list = new ArrayList<MoveMetaStatChanges>(count);
        
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
    
    protected List<MoveMetaStatChanges> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<MoveMetaStatChanges> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
