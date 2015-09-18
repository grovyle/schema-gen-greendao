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

import com.company.professor.ItemFlavorText;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "item_flavor_text".
*/
public class ItemFlavorTextDao extends AbstractDao<ItemFlavorText, Long> {

    public static final String TABLENAME = "item_flavor_text";

    /**
     * Properties of entity ItemFlavorText.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ItemId = new Property(0, long.class, "ItemId", true, "item_id");
        public final static Property VersionGroupId = new Property(1, long.class, "VersionGroupId", false, "version_group_id");
        public final static Property LanguageId = new Property(2, long.class, "LanguageId", false, "language_id");
        public final static Property FlavorText = new Property(3, String.class, "FlavorText", false, "flavor_text");
    };

    private DaoSession daoSession;


    public ItemFlavorTextDao(DaoConfig config) {
        super(config);
    }
    
    public ItemFlavorTextDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"item_flavor_text\" (" + //
                "\"item_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: ItemId
                "\"version_group_id\" INTEGER NOT NULL ," + // 1: VersionGroupId
                "\"language_id\" INTEGER NOT NULL ," + // 2: LanguageId
                "\"flavor_text\" TEXT NOT NULL );"); // 3: FlavorText
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_item_flavor_text_item_id_version_group_id_language_id ON item_flavor_text" +
                " (\"item_id\",\"version_group_id\",\"language_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"item_flavor_text\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ItemFlavorText entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getItemId());
        stmt.bindLong(2, entity.getVersionGroupId());
        stmt.bindLong(3, entity.getLanguageId());
        stmt.bindString(4, entity.getFlavorText());
    }

    @Override
    protected void attachEntity(ItemFlavorText entity) {
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
    public ItemFlavorText readEntity(Cursor cursor, int offset) {
        ItemFlavorText entity = new ItemFlavorText( //
            cursor.getLong(offset + 0), // ItemId
            cursor.getLong(offset + 1), // VersionGroupId
            cursor.getLong(offset + 2), // LanguageId
            cursor.getString(offset + 3) // FlavorText
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ItemFlavorText entity, int offset) {
        entity.setItemId(cursor.getLong(offset + 0));
        entity.setVersionGroupId(cursor.getLong(offset + 1));
        entity.setLanguageId(cursor.getLong(offset + 2));
        entity.setFlavorText(cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ItemFlavorText entity, long rowId) {
        entity.setItemId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ItemFlavorText entity) {
        if(entity != null) {
            return entity.getItemId();
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
            SqlUtils.appendColumns(builder, "T1", daoSession.getVersionGroupsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getLanguagesDao().getAllColumns());
            builder.append(" FROM item_flavor_text T");
            builder.append(" LEFT JOIN items T0 ON T.\"item_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN version_groups T1 ON T.\"version_group_id\"=T1.\"id\"");
            builder.append(" LEFT JOIN languages T2 ON T.\"language_id\"=T2.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ItemFlavorText loadCurrentDeep(Cursor cursor, boolean lock) {
        ItemFlavorText entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Items Items = loadCurrentOther(daoSession.getItemsDao(), cursor, offset);
         if(Items != null) {
            entity.setItems(Items);
        }
        offset += daoSession.getItemsDao().getAllColumns().length;

        VersionGroups VersionGroups = loadCurrentOther(daoSession.getVersionGroupsDao(), cursor, offset);
         if(VersionGroups != null) {
            entity.setVersionGroups(VersionGroups);
        }
        offset += daoSession.getVersionGroupsDao().getAllColumns().length;

        Languages Languages = loadCurrentOther(daoSession.getLanguagesDao(), cursor, offset);
         if(Languages != null) {
            entity.setLanguages(Languages);
        }

        return entity;    
    }

    public ItemFlavorText loadDeep(Long key) {
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
    public List<ItemFlavorText> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ItemFlavorText> list = new ArrayList<ItemFlavorText>(count);
        
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
    
    protected List<ItemFlavorText> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ItemFlavorText> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}