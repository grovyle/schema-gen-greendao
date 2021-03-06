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

import com.company.professor.Locations;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "locations".
*/
public class LocationsDao extends AbstractDao<Locations, Long> {

    public static final String TABLENAME = "locations";

    /**
     * Properties of entity Locations.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property RegionId = new Property(1, Long.class, "RegionId", false, "region_id");
        public final static Property Identifier = new Property(2, String.class, "Identifier", false, "identifier");
    };

    private DaoSession daoSession;


    public LocationsDao(DaoConfig config) {
        super(config);
    }
    
    public LocationsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"locations\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"region_id\" INTEGER," + // 1: RegionId
                "\"identifier\" TEXT NOT NULL );"); // 2: Identifier
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"locations\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Locations entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long RegionId = entity.getRegionId();
        if (RegionId != null) {
            stmt.bindLong(2, RegionId);
        }
        stmt.bindString(3, entity.getIdentifier());
    }

    @Override
    protected void attachEntity(Locations entity) {
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
    public Locations readEntity(Cursor cursor, int offset) {
        Locations entity = new Locations( //
            cursor.getLong(offset + 0), // Id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // RegionId
            cursor.getString(offset + 2) // Identifier
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Locations entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setRegionId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setIdentifier(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Locations entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Locations entity) {
        if(entity != null) {
            return entity.getId();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getRegionsDao().getAllColumns());
            builder.append(" FROM locations T");
            builder.append(" LEFT JOIN regions T0 ON T.\"region_id\"=T0.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Locations loadCurrentDeep(Cursor cursor, boolean lock) {
        Locations entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Regions Regions = loadCurrentOther(daoSession.getRegionsDao(), cursor, offset);
        entity.setRegions(Regions);

        return entity;    
    }

    public Locations loadDeep(Long key) {
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
    public List<Locations> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Locations> list = new ArrayList<Locations>(count);
        
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
    
    protected List<Locations> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Locations> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
