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

import com.company.professor.PalParkAreaNames;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "pal_park_area_names".
*/
public class PalParkAreaNamesDao extends AbstractDao<PalParkAreaNames, Long> {

    public static final String TABLENAME = "pal_park_area_names";

    /**
     * Properties of entity PalParkAreaNames.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property PalParkAreaId = new Property(0, long.class, "PalParkAreaId", true, "pal_park_area_id");
        public final static Property LocalLanguageId = new Property(1, long.class, "LocalLanguageId", false, "local_language_id");
        public final static Property Name = new Property(2, String.class, "Name", false, "name");
    };

    private DaoSession daoSession;


    public PalParkAreaNamesDao(DaoConfig config) {
        super(config);
    }
    
    public PalParkAreaNamesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"pal_park_area_names\" (" + //
                "\"pal_park_area_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: PalParkAreaId
                "\"local_language_id\" INTEGER NOT NULL ," + // 1: LocalLanguageId
                "\"name\" TEXT NOT NULL );"); // 2: Name
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_pal_park_area_names_pal_park_area_id_local_language_id ON pal_park_area_names" +
                " (\"pal_park_area_id\",\"local_language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"pal_park_area_names\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PalParkAreaNames entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPalParkAreaId());
        stmt.bindLong(2, entity.getLocalLanguageId());
        stmt.bindString(3, entity.getName());
    }

    @Override
    protected void attachEntity(PalParkAreaNames entity) {
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
    public PalParkAreaNames readEntity(Cursor cursor, int offset) {
        PalParkAreaNames entity = new PalParkAreaNames( //
            cursor.getLong(offset + 0), // PalParkAreaId
            cursor.getLong(offset + 1), // LocalLanguageId
            cursor.getString(offset + 2) // Name
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PalParkAreaNames entity, int offset) {
        entity.setPalParkAreaId(cursor.getLong(offset + 0));
        entity.setLocalLanguageId(cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PalParkAreaNames entity, long rowId) {
        entity.setPalParkAreaId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PalParkAreaNames entity) {
        if(entity != null) {
            return entity.getPalParkAreaId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getPalParkAreasDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM pal_park_area_names T");
            builder.append(" LEFT JOIN pal_park_areas T0 ON T.\"pal_park_area_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN languages T1 ON T.\"local_language_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PalParkAreaNames loadCurrentDeep(Cursor cursor, boolean lock) {
        PalParkAreaNames entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        PalParkAreas PalParkAreas = loadCurrentOther(daoSession.getPalParkAreasDao(), cursor, offset);
         if(PalParkAreas != null) {
            entity.setPalParkAreas(PalParkAreas);
        }
        offset += daoSession.getPalParkAreasDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public PalParkAreaNames loadDeep(Long key) {
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
    public List<PalParkAreaNames> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PalParkAreaNames> list = new ArrayList<PalParkAreaNames>(count);
        
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
    
    protected List<PalParkAreaNames> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PalParkAreaNames> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}