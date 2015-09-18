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

import com.company.professor.ConquestMoveDisplacementProse;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "conquest_move_displacement_prose".
*/
public class ConquestMoveDisplacementProseDao extends AbstractDao<ConquestMoveDisplacementProse, Long> {

    public static final String TABLENAME = "conquest_move_displacement_prose";

    /**
     * Properties of entity ConquestMoveDisplacementProse.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property MoveDisplacementId = new Property(0, long.class, "MoveDisplacementId", true, "move_displacement_id");
        public final static Property LocalLanguageId = new Property(1, long.class, "LocalLanguageId", false, "local_language_id");
        public final static Property Name = new Property(2, String.class, "Name", false, "name");
        public final static Property ShortEffect = new Property(3, String.class, "ShortEffect", false, "short_effect");
        public final static Property Effect = new Property(4, String.class, "Effect", false, "effect");
    };

    private DaoSession daoSession;


    public ConquestMoveDisplacementProseDao(DaoConfig config) {
        super(config);
    }
    
    public ConquestMoveDisplacementProseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"conquest_move_displacement_prose\" (" + //
                "\"move_displacement_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: MoveDisplacementId
                "\"local_language_id\" INTEGER NOT NULL ," + // 1: LocalLanguageId
                "\"name\" TEXT," + // 2: Name
                "\"short_effect\" TEXT," + // 3: ShortEffect
                "\"effect\" TEXT);"); // 4: Effect
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_conquest_move_displacement_prose_move_displacement_id_local_language_id ON conquest_move_displacement_prose" +
                " (\"move_displacement_id\",\"local_language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"conquest_move_displacement_prose\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ConquestMoveDisplacementProse entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getMoveDisplacementId());
        stmt.bindLong(2, entity.getLocalLanguageId());
 
        String Name = entity.getName();
        if (Name != null) {
            stmt.bindString(3, Name);
        }
 
        String ShortEffect = entity.getShortEffect();
        if (ShortEffect != null) {
            stmt.bindString(4, ShortEffect);
        }
 
        String Effect = entity.getEffect();
        if (Effect != null) {
            stmt.bindString(5, Effect);
        }
    }

    @Override
    protected void attachEntity(ConquestMoveDisplacementProse entity) {
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
    public ConquestMoveDisplacementProse readEntity(Cursor cursor, int offset) {
        ConquestMoveDisplacementProse entity = new ConquestMoveDisplacementProse( //
            cursor.getLong(offset + 0), // MoveDisplacementId
            cursor.getLong(offset + 1), // LocalLanguageId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // ShortEffect
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // Effect
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ConquestMoveDisplacementProse entity, int offset) {
        entity.setMoveDisplacementId(cursor.getLong(offset + 0));
        entity.setLocalLanguageId(cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setShortEffect(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEffect(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ConquestMoveDisplacementProse entity, long rowId) {
        entity.setMoveDisplacementId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ConquestMoveDisplacementProse entity) {
        if(entity != null) {
            return entity.getMoveDisplacementId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getConquestMoveDisplacementsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM conquest_move_displacement_prose T");
            builder.append(" LEFT JOIN conquest_move_displacements T0 ON T.\"move_displacement_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN languages T1 ON T.\"local_language_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ConquestMoveDisplacementProse loadCurrentDeep(Cursor cursor, boolean lock) {
        ConquestMoveDisplacementProse entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        ConquestMoveDisplacements ConquestMoveDisplacements = loadCurrentOther(daoSession.getConquestMoveDisplacementsDao(), cursor, offset);
         if(ConquestMoveDisplacements != null) {
            entity.setConquestMoveDisplacements(ConquestMoveDisplacements);
        }
        offset += daoSession.getConquestMoveDisplacementsDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public ConquestMoveDisplacementProse loadDeep(Long key) {
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
    public List<ConquestMoveDisplacementProse> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ConquestMoveDisplacementProse> list = new ArrayList<ConquestMoveDisplacementProse>(count);
        
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
    
    protected List<ConquestMoveDisplacementProse> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ConquestMoveDisplacementProse> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}