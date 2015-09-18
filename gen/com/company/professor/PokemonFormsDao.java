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

import com.company.professor.PokemonForms;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "pokemon_forms".
*/
public class PokemonFormsDao extends AbstractDao<PokemonForms, Long> {

    public static final String TABLENAME = "pokemon_forms";

    /**
     * Properties of entity PokemonForms.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property Identifier = new Property(1, String.class, "Identifier", false, "identifier");
        public final static Property FormIdentifier = new Property(2, String.class, "FormIdentifier", false, "form_identifier");
        public final static Property PokemonId = new Property(3, long.class, "PokemonId", false, "pokemon_id");
        public final static Property IntroducedInVersionGroupId = new Property(4, Long.class, "IntroducedInVersionGroupId", false, "introduced_in_version_group_id");
        public final static Property IsDefault = new Property(5, boolean.class, "IsDefault", false, "is_default");
        public final static Property IsBattleOnly = new Property(6, boolean.class, "IsBattleOnly", false, "is_battle_only");
        public final static Property IsMega = new Property(7, boolean.class, "IsMega", false, "is_mega");
        public final static Property FormOrder = new Property(8, long.class, "FormOrder", false, "form_order");
        public final static Property Order = new Property(9, long.class, "Order", false, "order");
    };

    private DaoSession daoSession;


    public PokemonFormsDao(DaoConfig config) {
        super(config);
    }
    
    public PokemonFormsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"pokemon_forms\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"identifier\" TEXT NOT NULL ," + // 1: Identifier
                "\"form_identifier\" TEXT," + // 2: FormIdentifier
                "\"pokemon_id\" INTEGER NOT NULL ," + // 3: PokemonId
                "\"introduced_in_version_group_id\" INTEGER," + // 4: IntroducedInVersionGroupId
                "\"is_default\" INTEGER NOT NULL ," + // 5: IsDefault
                "\"is_battle_only\" INTEGER NOT NULL ," + // 6: IsBattleOnly
                "\"is_mega\" INTEGER NOT NULL ," + // 7: IsMega
                "\"form_order\" INTEGER NOT NULL ," + // 8: FormOrder
                "\"order\" INTEGER NOT NULL );"); // 9: Order
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"pokemon_forms\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PokemonForms entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getIdentifier());
 
        String FormIdentifier = entity.getFormIdentifier();
        if (FormIdentifier != null) {
            stmt.bindString(3, FormIdentifier);
        }
        stmt.bindLong(4, entity.getPokemonId());
 
        Long IntroducedInVersionGroupId = entity.getIntroducedInVersionGroupId();
        if (IntroducedInVersionGroupId != null) {
            stmt.bindLong(5, IntroducedInVersionGroupId);
        }
        stmt.bindLong(6, entity.getIsDefault() ? 1L: 0L);
        stmt.bindLong(7, entity.getIsBattleOnly() ? 1L: 0L);
        stmt.bindLong(8, entity.getIsMega() ? 1L: 0L);
        stmt.bindLong(9, entity.getFormOrder());
        stmt.bindLong(10, entity.getOrder());
    }

    @Override
    protected void attachEntity(PokemonForms entity) {
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
    public PokemonForms readEntity(Cursor cursor, int offset) {
        PokemonForms entity = new PokemonForms( //
            cursor.getLong(offset + 0), // Id
            cursor.getString(offset + 1), // Identifier
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // FormIdentifier
            cursor.getLong(offset + 3), // PokemonId
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // IntroducedInVersionGroupId
            cursor.getShort(offset + 5) != 0, // IsDefault
            cursor.getShort(offset + 6) != 0, // IsBattleOnly
            cursor.getShort(offset + 7) != 0, // IsMega
            cursor.getLong(offset + 8), // FormOrder
            cursor.getLong(offset + 9) // Order
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PokemonForms entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setIdentifier(cursor.getString(offset + 1));
        entity.setFormIdentifier(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPokemonId(cursor.getLong(offset + 3));
        entity.setIntroducedInVersionGroupId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setIsDefault(cursor.getShort(offset + 5) != 0);
        entity.setIsBattleOnly(cursor.getShort(offset + 6) != 0);
        entity.setIsMega(cursor.getShort(offset + 7) != 0);
        entity.setFormOrder(cursor.getLong(offset + 8));
        entity.setOrder(cursor.getLong(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PokemonForms entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PokemonForms entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getPokemonDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getVersionGroupsDao().getAllColumns());
            builder.append(" FROM pokemon_forms T");
            builder.append(" LEFT JOIN pokemon T0 ON T.\"pokemon_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN version_groups T1 ON T.\"introduced_in_version_group_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PokemonForms loadCurrentDeep(Cursor cursor, boolean lock) {
        PokemonForms entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Pokemon Pokemon = loadCurrentOther(daoSession.getPokemonDao(), cursor, offset);
         if(Pokemon != null) {
            entity.setPokemon(Pokemon);
        }
        offset += daoSession.getPokemonDao().getAllColumns().length;

        VersionGroups VersionGroups = loadCurrentOther(daoSession.getVersionGroupsDao(), cursor, offset);
        entity.setVersionGroups(VersionGroups);

        return entity;    
    }

    public PokemonForms loadDeep(Long key) {
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
    public List<PokemonForms> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PokemonForms> list = new ArrayList<PokemonForms>(count);
        
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
    
    protected List<PokemonForms> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PokemonForms> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}