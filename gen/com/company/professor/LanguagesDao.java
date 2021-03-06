package com.company.professor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.company.professor.Languages;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "languages".
*/
public class LanguagesDao extends AbstractDao<Languages, Long> {

    public static final String TABLENAME = "languages";

    /**
     * Properties of entity Languages.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property Iso639 = new Property(1, String.class, "Iso639", false, "iso639");
        public final static Property Iso3166 = new Property(2, String.class, "Iso3166", false, "iso3166");
        public final static Property Identifier = new Property(3, String.class, "Identifier", false, "identifier");
        public final static Property Official = new Property(4, boolean.class, "Official", false, "official");
        public final static Property Order = new Property(5, Long.class, "Order", false, "order");
    };


    public LanguagesDao(DaoConfig config) {
        super(config);
    }
    
    public LanguagesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"languages\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"iso639\" TEXT NOT NULL ," + // 1: Iso639
                "\"iso3166\" TEXT NOT NULL ," + // 2: Iso3166
                "\"identifier\" TEXT NOT NULL ," + // 3: Identifier
                "\"official\" INTEGER NOT NULL ," + // 4: Official
                "\"order\" INTEGER);"); // 5: Order
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"languages\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Languages entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getIso639());
        stmt.bindString(3, entity.getIso3166());
        stmt.bindString(4, entity.getIdentifier());
        stmt.bindLong(5, entity.getOfficial() ? 1L: 0L);
 
        Long Order = entity.getOrder();
        if (Order != null) {
            stmt.bindLong(6, Order);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Languages readEntity(Cursor cursor, int offset) {
        Languages entity = new Languages( //
            cursor.getLong(offset + 0), // Id
            cursor.getString(offset + 1), // Iso639
            cursor.getString(offset + 2), // Iso3166
            cursor.getString(offset + 3), // Identifier
            cursor.getShort(offset + 4) != 0, // Official
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // Order
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Languages entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setIso639(cursor.getString(offset + 1));
        entity.setIso3166(cursor.getString(offset + 2));
        entity.setIdentifier(cursor.getString(offset + 3));
        entity.setOfficial(cursor.getShort(offset + 4) != 0);
        entity.setOrder(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Languages entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Languages entity) {
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
    
}
