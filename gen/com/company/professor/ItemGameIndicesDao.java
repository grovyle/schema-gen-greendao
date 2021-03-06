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

import com.company.professor.ItemGameIndices;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "item_game_indices".
*/
public class ItemGameIndicesDao extends AbstractDao<ItemGameIndices, Long> {

    public static final String TABLENAME = "item_game_indices";

    /**
     * Properties of entity ItemGameIndices.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ItemId = new Property(0, long.class, "ItemId", true, "item_id");
        public final static Property GenerationId = new Property(1, long.class, "GenerationId", false, "generation_id");
        public final static Property GameIndex = new Property(2, long.class, "GameIndex", false, "game_index");
    };

    private DaoSession daoSession;


    public ItemGameIndicesDao(DaoConfig config) {
        super(config);
    }
    
    public ItemGameIndicesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"item_game_indices\" (" + //
                "\"item_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: ItemId
                "\"generation_id\" INTEGER NOT NULL ," + // 1: GenerationId
                "\"game_index\" INTEGER NOT NULL );"); // 2: GameIndex
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_item_game_indices_item_id_generation_id ON item_game_indices" +
                " (\"item_id\",\"generation_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"item_game_indices\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ItemGameIndices entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getItemId());
        stmt.bindLong(2, entity.getGenerationId());
        stmt.bindLong(3, entity.getGameIndex());
    }

    @Override
    protected void attachEntity(ItemGameIndices entity) {
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
    public ItemGameIndices readEntity(Cursor cursor, int offset) {
        ItemGameIndices entity = new ItemGameIndices( //
            cursor.getLong(offset + 0), // ItemId
            cursor.getLong(offset + 1), // GenerationId
            cursor.getLong(offset + 2) // GameIndex
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ItemGameIndices entity, int offset) {
        entity.setItemId(cursor.getLong(offset + 0));
        entity.setGenerationId(cursor.getLong(offset + 1));
        entity.setGameIndex(cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ItemGameIndices entity, long rowId) {
        entity.setItemId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ItemGameIndices entity) {
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
            SqlUtils.appendColumns(builder, "T1", daoSession.getGenerationsDao().getAllColumns());
            builder.append(" FROM item_game_indices T");
            builder.append(" LEFT JOIN items T0 ON T.\"item_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN generations T1 ON T.\"generation_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ItemGameIndices loadCurrentDeep(Cursor cursor, boolean lock) {
        ItemGameIndices entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Items Items = loadCurrentOther(daoSession.getItemsDao(), cursor, offset);
         if(Items != null) {
            entity.setItems(Items);
        }
        offset += daoSession.getItemsDao().getAllColumns().length;

        Generations Generations = loadCurrentOther(daoSession.getGenerationsDao(), cursor, offset);
         if(Generations != null) {
            entity.setGenerations(Generations);
        }

        return entity;    
    }

    public ItemGameIndices loadDeep(Long key) {
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
    public List<ItemGameIndices> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ItemGameIndices> list = new ArrayList<ItemGameIndices>(count);
        
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
    
    protected List<ItemGameIndices> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ItemGameIndices> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
