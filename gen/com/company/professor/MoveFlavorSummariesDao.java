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

import com.company.professor.MoveFlavorSummaries;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "move_flavor_summaries".
*/
public class MoveFlavorSummariesDao extends AbstractDao<MoveFlavorSummaries, Long> {

    public static final String TABLENAME = "move_flavor_summaries";

    /**
     * Properties of entity MoveFlavorSummaries.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property MoveId = new Property(0, long.class, "MoveId", true, "move_id");
        public final static Property LocalLanguageId = new Property(1, long.class, "LocalLanguageId", false, "local_language_id");
        public final static Property FlavorSummary = new Property(2, String.class, "FlavorSummary", false, "flavor_summary");
    };

    private DaoSession daoSession;


    public MoveFlavorSummariesDao(DaoConfig config) {
        super(config);
    }
    
    public MoveFlavorSummariesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"move_flavor_summaries\" (" + //
                "\"move_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: MoveId
                "\"local_language_id\" INTEGER NOT NULL ," + // 1: LocalLanguageId
                "\"flavor_summary\" TEXT);"); // 2: FlavorSummary
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_move_flavor_summaries_move_id_local_language_id ON move_flavor_summaries" +
                " (\"move_id\",\"local_language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"move_flavor_summaries\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MoveFlavorSummaries entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getMoveId());
        stmt.bindLong(2, entity.getLocalLanguageId());
 
        String FlavorSummary = entity.getFlavorSummary();
        if (FlavorSummary != null) {
            stmt.bindString(3, FlavorSummary);
        }
    }

    @Override
    protected void attachEntity(MoveFlavorSummaries entity) {
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
    public MoveFlavorSummaries readEntity(Cursor cursor, int offset) {
        MoveFlavorSummaries entity = new MoveFlavorSummaries( //
            cursor.getLong(offset + 0), // MoveId
            cursor.getLong(offset + 1), // LocalLanguageId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // FlavorSummary
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MoveFlavorSummaries entity, int offset) {
        entity.setMoveId(cursor.getLong(offset + 0));
        entity.setLocalLanguageId(cursor.getLong(offset + 1));
        entity.setFlavorSummary(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MoveFlavorSummaries entity, long rowId) {
        entity.setMoveId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MoveFlavorSummaries entity) {
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
            SqlUtils.appendColumns(builder, "T1", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM move_flavor_summaries T");
            builder.append(" LEFT JOIN moves T0 ON T.\"move_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN languages T1 ON T.\"local_language_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected MoveFlavorSummaries loadCurrentDeep(Cursor cursor, boolean lock) {
        MoveFlavorSummaries entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Moves Moves = loadCurrentOther(daoSession.getMovesDao(), cursor, offset);
         if(Moves != null) {
            entity.setMoves(Moves);
        }
        offset += daoSession.getMovesDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public MoveFlavorSummaries loadDeep(Long key) {
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
    public List<MoveFlavorSummaries> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<MoveFlavorSummaries> list = new ArrayList<MoveFlavorSummaries>(count);
        
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
    
    protected List<MoveFlavorSummaries> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<MoveFlavorSummaries> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
