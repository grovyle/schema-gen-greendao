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

import com.company.professor.VersionGroupRegions;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "version_group_regions".
*/
public class VersionGroupRegionsDao extends AbstractDao<VersionGroupRegions, Long> {

    public static final String TABLENAME = "version_group_regions";

    /**
     * Properties of entity VersionGroupRegions.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property VersionGroupId = new Property(0, long.class, "VersionGroupId", true, "version_group_id");
        public final static Property RegionId = new Property(1, long.class, "RegionId", false, "region_id");
    };

    private DaoSession daoSession;


    public VersionGroupRegionsDao(DaoConfig config) {
        super(config);
    }
    
    public VersionGroupRegionsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"version_group_regions\" (" + //
                "\"version_group_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: VersionGroupId
                "\"region_id\" INTEGER NOT NULL );"); // 1: RegionId
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_version_group_regions_version_group_id_region_id ON version_group_regions" +
                " (\"version_group_id\",\"region_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"version_group_regions\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, VersionGroupRegions entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getVersionGroupId());
        stmt.bindLong(2, entity.getRegionId());
    }

    @Override
    protected void attachEntity(VersionGroupRegions entity) {
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
    public VersionGroupRegions readEntity(Cursor cursor, int offset) {
        VersionGroupRegions entity = new VersionGroupRegions( //
            cursor.getLong(offset + 0), // VersionGroupId
            cursor.getLong(offset + 1) // RegionId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, VersionGroupRegions entity, int offset) {
        entity.setVersionGroupId(cursor.getLong(offset + 0));
        entity.setRegionId(cursor.getLong(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(VersionGroupRegions entity, long rowId) {
        entity.setVersionGroupId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(VersionGroupRegions entity) {
        if(entity != null) {
            return entity.getVersionGroupId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getVersionGroupsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getRegionsDao().getAllColumns());
            builder.append(" FROM version_group_regions T");
            builder.append(" LEFT JOIN version_groups T0 ON T.\"version_group_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN regions T1 ON T.\"region_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected VersionGroupRegions loadCurrentDeep(Cursor cursor, boolean lock) {
        VersionGroupRegions entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        VersionGroups VersionGroups = loadCurrentOther(daoSession.getVersionGroupsDao(), cursor, offset);
         if(VersionGroups != null) {
            entity.setVersionGroups(VersionGroups);
        }
        offset += daoSession.getVersionGroupsDao().getAllColumns().length;

        Regions Regions = loadCurrentOther(daoSession.getRegionsDao(), cursor, offset);
         if(Regions != null) {
            entity.setRegions(Regions);
        }

        return entity;    
    }

    public VersionGroupRegions loadDeep(Long key) {
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
    public List<VersionGroupRegions> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<VersionGroupRegions> list = new ArrayList<VersionGroupRegions>(count);
        
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
    
    protected List<VersionGroupRegions> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<VersionGroupRegions> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}