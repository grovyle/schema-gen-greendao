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

import com.company.professor.MoveEffectProse;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "move_effect_prose".
*/
public class MoveEffectProseDao extends AbstractDao<MoveEffectProse, Long> {

    public static final String TABLENAME = "move_effect_prose";

    /**
     * Properties of entity MoveEffectProse.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property MoveEffectId = new Property(0, long.class, "MoveEffectId", true, "move_effect_id");
        public final static Property LocalLanguageId = new Property(1, long.class, "LocalLanguageId", false, "local_language_id");
        public final static Property ShortEffect = new Property(2, String.class, "ShortEffect", false, "short_effect");
        public final static Property Effect = new Property(3, String.class, "Effect", false, "effect");
    };

    private DaoSession daoSession;


    public MoveEffectProseDao(DaoConfig config) {
        super(config);
    }
    
    public MoveEffectProseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"move_effect_prose\" (" + //
                "\"move_effect_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: MoveEffectId
                "\"local_language_id\" INTEGER NOT NULL ," + // 1: LocalLanguageId
                "\"short_effect\" TEXT," + // 2: ShortEffect
                "\"effect\" TEXT);"); // 3: Effect
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_move_effect_prose_move_effect_id_local_language_id ON move_effect_prose" +
                " (\"move_effect_id\",\"local_language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"move_effect_prose\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MoveEffectProse entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getMoveEffectId());
        stmt.bindLong(2, entity.getLocalLanguageId());
 
        String ShortEffect = entity.getShortEffect();
        if (ShortEffect != null) {
            stmt.bindString(3, ShortEffect);
        }
 
        String Effect = entity.getEffect();
        if (Effect != null) {
            stmt.bindString(4, Effect);
        }
    }

    @Override
    protected void attachEntity(MoveEffectProse entity) {
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
    public MoveEffectProse readEntity(Cursor cursor, int offset) {
        MoveEffectProse entity = new MoveEffectProse( //
            cursor.getLong(offset + 0), // MoveEffectId
            cursor.getLong(offset + 1), // LocalLanguageId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // ShortEffect
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // Effect
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MoveEffectProse entity, int offset) {
        entity.setMoveEffectId(cursor.getLong(offset + 0));
        entity.setLocalLanguageId(cursor.getLong(offset + 1));
        entity.setShortEffect(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setEffect(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MoveEffectProse entity, long rowId) {
        entity.setMoveEffectId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MoveEffectProse entity) {
        if(entity != null) {
            return entity.getMoveEffectId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getMoveEffectsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM move_effect_prose T");
            builder.append(" LEFT JOIN move_effects T0 ON T.\"move_effect_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN languages T1 ON T.\"local_language_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected MoveEffectProse loadCurrentDeep(Cursor cursor, boolean lock) {
        MoveEffectProse entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        MoveEffects MoveEffects = loadCurrentOther(daoSession.getMoveEffectsDao(), cursor, offset);
         if(MoveEffects != null) {
            entity.setMoveEffects(MoveEffects);
        }
        offset += daoSession.getMoveEffectsDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public MoveEffectProse loadDeep(Long key) {
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
    public List<MoveEffectProse> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<MoveEffectProse> list = new ArrayList<MoveEffectProse>(count);
        
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
    
    protected List<MoveEffectProse> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<MoveEffectProse> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
