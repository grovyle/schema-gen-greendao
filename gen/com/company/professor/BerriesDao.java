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

import com.company.professor.Berries;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "berries".
*/
public class BerriesDao extends AbstractDao<Berries, Long> {

    public static final String TABLENAME = "berries";

    /**
     * Properties of entity Berries.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property ItemId = new Property(1, long.class, "ItemId", false, "item_id");
        public final static Property FirmnessId = new Property(2, long.class, "FirmnessId", false, "firmness_id");
        public final static Property NaturalGiftPower = new Property(3, Long.class, "NaturalGiftPower", false, "natural_gift_power");
        public final static Property NaturalGiftTypeId = new Property(4, Long.class, "NaturalGiftTypeId", false, "natural_gift_type_id");
        public final static Property Size = new Property(5, long.class, "Size", false, "size");
        public final static Property MaxHarvest = new Property(6, long.class, "MaxHarvest", false, "max_harvest");
        public final static Property GrowthTime = new Property(7, long.class, "GrowthTime", false, "growth_time");
        public final static Property SoilDryness = new Property(8, long.class, "SoilDryness", false, "soil_dryness");
        public final static Property Smoothness = new Property(9, long.class, "Smoothness", false, "smoothness");
    };

    private DaoSession daoSession;


    public BerriesDao(DaoConfig config) {
        super(config);
    }
    
    public BerriesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"berries\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"item_id\" INTEGER NOT NULL ," + // 1: ItemId
                "\"firmness_id\" INTEGER NOT NULL ," + // 2: FirmnessId
                "\"natural_gift_power\" INTEGER," + // 3: NaturalGiftPower
                "\"natural_gift_type_id\" INTEGER," + // 4: NaturalGiftTypeId
                "\"size\" INTEGER NOT NULL ," + // 5: Size
                "\"max_harvest\" INTEGER NOT NULL ," + // 6: MaxHarvest
                "\"growth_time\" INTEGER NOT NULL ," + // 7: GrowthTime
                "\"soil_dryness\" INTEGER NOT NULL ," + // 8: SoilDryness
                "\"smoothness\" INTEGER NOT NULL );"); // 9: Smoothness
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"berries\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Berries entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getItemId());
        stmt.bindLong(3, entity.getFirmnessId());
 
        Long NaturalGiftPower = entity.getNaturalGiftPower();
        if (NaturalGiftPower != null) {
            stmt.bindLong(4, NaturalGiftPower);
        }
 
        Long NaturalGiftTypeId = entity.getNaturalGiftTypeId();
        if (NaturalGiftTypeId != null) {
            stmt.bindLong(5, NaturalGiftTypeId);
        }
        stmt.bindLong(6, entity.getSize());
        stmt.bindLong(7, entity.getMaxHarvest());
        stmt.bindLong(8, entity.getGrowthTime());
        stmt.bindLong(9, entity.getSoilDryness());
        stmt.bindLong(10, entity.getSmoothness());
    }

    @Override
    protected void attachEntity(Berries entity) {
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
    public Berries readEntity(Cursor cursor, int offset) {
        Berries entity = new Berries( //
            cursor.getLong(offset + 0), // Id
            cursor.getLong(offset + 1), // ItemId
            cursor.getLong(offset + 2), // FirmnessId
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // NaturalGiftPower
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // NaturalGiftTypeId
            cursor.getLong(offset + 5), // Size
            cursor.getLong(offset + 6), // MaxHarvest
            cursor.getLong(offset + 7), // GrowthTime
            cursor.getLong(offset + 8), // SoilDryness
            cursor.getLong(offset + 9) // Smoothness
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Berries entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setItemId(cursor.getLong(offset + 1));
        entity.setFirmnessId(cursor.getLong(offset + 2));
        entity.setNaturalGiftPower(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setNaturalGiftTypeId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setSize(cursor.getLong(offset + 5));
        entity.setMaxHarvest(cursor.getLong(offset + 6));
        entity.setGrowthTime(cursor.getLong(offset + 7));
        entity.setSoilDryness(cursor.getLong(offset + 8));
        entity.setSmoothness(cursor.getLong(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Berries entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Berries entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getItemsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getBerryFirmnessDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getTypesDao().getAllColumns());
            builder.append(" FROM berries T");
            builder.append(" LEFT JOIN items T0 ON T.\"item_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN berry_firmness T1 ON T.\"firmness_id\"=T1.\"id\"");
            builder.append(" LEFT JOIN types T2 ON T.\"natural_gift_type_id\"=T2.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Berries loadCurrentDeep(Cursor cursor, boolean lock) {
        Berries entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Items Items = loadCurrentOther(daoSession.getItemsDao(), cursor, offset);
         if(Items != null) {
            entity.setItems(Items);
        }
        offset += daoSession.getItemsDao().getAllColumns().length;

        BerryFirmness BerryFirmness = loadCurrentOther(daoSession.getBerryFirmnessDao(), cursor, offset);
         if(BerryFirmness != null) {
            entity.setBerryFirmness(BerryFirmness);
        }
        offset += daoSession.getBerryFirmnessDao().getAllColumns().length;

        Types Types = loadCurrentOther(daoSession.getTypesDao(), cursor, offset);
        entity.setTypes(Types);

        return entity;    
    }

    public Berries loadDeep(Long key) {
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
    public List<Berries> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Berries> list = new ArrayList<Berries>(count);
        
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
    
    protected List<Berries> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Berries> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
