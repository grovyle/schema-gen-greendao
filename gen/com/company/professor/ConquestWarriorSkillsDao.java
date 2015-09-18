package com.company.professor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.company.professor.ConquestWarriorSkills;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "conquest_warrior_skills".
*/
public class ConquestWarriorSkillsDao extends AbstractDao<ConquestWarriorSkills, Long> {

    public static final String TABLENAME = "conquest_warrior_skills";

    /**
     * Properties of entity ConquestWarriorSkills.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property Identifier = new Property(1, String.class, "Identifier", false, "identifier");
    };


    public ConquestWarriorSkillsDao(DaoConfig config) {
        super(config);
    }
    
    public ConquestWarriorSkillsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"conquest_warrior_skills\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"identifier\" TEXT NOT NULL );"); // 1: Identifier
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"conquest_warrior_skills\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ConquestWarriorSkills entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getIdentifier());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ConquestWarriorSkills readEntity(Cursor cursor, int offset) {
        ConquestWarriorSkills entity = new ConquestWarriorSkills( //
            cursor.getLong(offset + 0), // Id
            cursor.getString(offset + 1) // Identifier
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ConquestWarriorSkills entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setIdentifier(cursor.getString(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ConquestWarriorSkills entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ConquestWarriorSkills entity) {
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
