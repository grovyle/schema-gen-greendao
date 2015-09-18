package com.company.professor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.company.professor.ContestEffects;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "contest_effects".
*/
public class ContestEffectsDao extends AbstractDao<ContestEffects, Long> {

    public static final String TABLENAME = "contest_effects";

    /**
     * Properties of entity ContestEffects.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property Appeal = new Property(1, int.class, "Appeal", false, "appeal");
        public final static Property Jam = new Property(2, int.class, "Jam", false, "jam");
    };


    public ContestEffectsDao(DaoConfig config) {
        super(config);
    }
    
    public ContestEffectsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"contest_effects\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"appeal\" INTEGER NOT NULL ," + // 1: Appeal
                "\"jam\" INTEGER NOT NULL );"); // 2: Jam
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"contest_effects\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ContestEffects entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getAppeal());
        stmt.bindLong(3, entity.getJam());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ContestEffects readEntity(Cursor cursor, int offset) {
        ContestEffects entity = new ContestEffects( //
            cursor.getLong(offset + 0), // Id
            cursor.getInt(offset + 1), // Appeal
            cursor.getInt(offset + 2) // Jam
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ContestEffects entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setAppeal(cursor.getInt(offset + 1));
        entity.setJam(cursor.getInt(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ContestEffects entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ContestEffects entity) {
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