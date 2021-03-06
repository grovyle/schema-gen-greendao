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

import com.company.professor.ItemCategories;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "item_categories".
*/
public class ItemCategoriesDao extends AbstractDao<ItemCategories, Long> {

    public static final String TABLENAME = "item_categories";

    /**
     * Properties of entity ItemCategories.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property PocketId = new Property(1, long.class, "PocketId", false, "pocket_id");
        public final static Property Identifier = new Property(2, String.class, "Identifier", false, "identifier");
    };

    private DaoSession daoSession;


    public ItemCategoriesDao(DaoConfig config) {
        super(config);
    }
    
    public ItemCategoriesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"item_categories\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"pocket_id\" INTEGER NOT NULL ," + // 1: PocketId
                "\"identifier\" TEXT NOT NULL );"); // 2: Identifier
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"item_categories\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ItemCategories entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getPocketId());
        stmt.bindString(3, entity.getIdentifier());
    }

    @Override
    protected void attachEntity(ItemCategories entity) {
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
    public ItemCategories readEntity(Cursor cursor, int offset) {
        ItemCategories entity = new ItemCategories( //
            cursor.getLong(offset + 0), // Id
            cursor.getLong(offset + 1), // PocketId
            cursor.getString(offset + 2) // Identifier
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ItemCategories entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setPocketId(cursor.getLong(offset + 1));
        entity.setIdentifier(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ItemCategories entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ItemCategories entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getItemPocketsDao().getAllColumns());
            builder.append(" FROM item_categories T");
            builder.append(" LEFT JOIN item_pockets T0 ON T.\"pocket_id\"=T0.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ItemCategories loadCurrentDeep(Cursor cursor, boolean lock) {
        ItemCategories entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        ItemPockets ItemPockets = loadCurrentOther(daoSession.getItemPocketsDao(), cursor, offset);
         if(ItemPockets != null) {
            entity.setItemPockets(ItemPockets);
        }

        return entity;    
    }

    public ItemCategories loadDeep(Long key) {
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
    public List<ItemCategories> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ItemCategories> list = new ArrayList<ItemCategories>(count);
        
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
    
    protected List<ItemCategories> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ItemCategories> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
