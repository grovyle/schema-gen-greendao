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

import com.company.professor.Machines;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "machines".
*/
public class MachinesDao extends AbstractDao<Machines, Long> {

    public static final String TABLENAME = "machines";

    /**
     * Properties of entity Machines.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property MachineNumber = new Property(0, long.class, "MachineNumber", true, "machine_number");
        public final static Property VersionGroupId = new Property(1, long.class, "VersionGroupId", false, "version_group_id");
        public final static Property ItemId = new Property(2, long.class, "ItemId", false, "item_id");
        public final static Property MoveId = new Property(3, long.class, "MoveId", false, "move_id");
    };

    private DaoSession daoSession;


    public MachinesDao(DaoConfig config) {
        super(config);
    }
    
    public MachinesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"machines\" (" + //
                "\"machine_number\" INTEGER PRIMARY KEY NOT NULL ," + // 0: MachineNumber
                "\"version_group_id\" INTEGER NOT NULL ," + // 1: VersionGroupId
                "\"item_id\" INTEGER NOT NULL ," + // 2: ItemId
                "\"move_id\" INTEGER NOT NULL );"); // 3: MoveId
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_machines_machine_number_version_group_id ON machines" +
                " (\"machine_number\",\"version_group_id\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"machines\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Machines entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getMachineNumber());
        stmt.bindLong(2, entity.getVersionGroupId());
        stmt.bindLong(3, entity.getItemId());
        stmt.bindLong(4, entity.getMoveId());
    }

    @Override
    protected void attachEntity(Machines entity) {
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
    public Machines readEntity(Cursor cursor, int offset) {
        Machines entity = new Machines( //
            cursor.getLong(offset + 0), // MachineNumber
            cursor.getLong(offset + 1), // VersionGroupId
            cursor.getLong(offset + 2), // ItemId
            cursor.getLong(offset + 3) // MoveId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Machines entity, int offset) {
        entity.setMachineNumber(cursor.getLong(offset + 0));
        entity.setVersionGroupId(cursor.getLong(offset + 1));
        entity.setItemId(cursor.getLong(offset + 2));
        entity.setMoveId(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Machines entity, long rowId) {
        entity.setMachineNumber(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Machines entity) {
        if(entity != null) {
            return entity.getMachineNumber();
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
            SqlUtils.appendColumns(builder, "T1", daoSession.getItemsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getMovesDao().getAllColumns());
            builder.append(" FROM machines T");
            builder.append(" LEFT JOIN version_groups T0 ON T.\"version_group_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN items T1 ON T.\"item_id\"=T1.\"id\"");
            builder.append(" LEFT JOIN moves T2 ON T.\"move_id\"=T2.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Machines loadCurrentDeep(Cursor cursor, boolean lock) {
        Machines entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        VersionGroups VersionGroups = loadCurrentOther(daoSession.getVersionGroupsDao(), cursor, offset);
         if(VersionGroups != null) {
            entity.setVersionGroups(VersionGroups);
        }
        offset += daoSession.getVersionGroupsDao().getAllColumns().length;

        Items Items = loadCurrentOther(daoSession.getItemsDao(), cursor, offset);
         if(Items != null) {
            entity.setItems(Items);
        }
        offset += daoSession.getItemsDao().getAllColumns().length;

        Moves Moves = loadCurrentOther(daoSession.getMovesDao(), cursor, offset);
         if(Moves != null) {
            entity.setMoves(Moves);
        }

        return entity;    
    }

    public Machines loadDeep(Long key) {
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
    public List<Machines> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Machines> list = new ArrayList<Machines>(count);
        
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
    
    protected List<Machines> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Machines> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
