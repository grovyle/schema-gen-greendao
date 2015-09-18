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

import com.company.professor.PokemonAbilities;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "pokemon_abilities".
*/
public class PokemonAbilitiesDao extends AbstractDao<PokemonAbilities, Long> {

    public static final String TABLENAME = "pokemon_abilities";

    /**
     * Properties of entity PokemonAbilities.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property PokemonId = new Property(0, long.class, "PokemonId", true, "pokemon_id");
        public final static Property AbilityId = new Property(1, long.class, "AbilityId", false, "ability_id");
        public final static Property IsHidden = new Property(2, boolean.class, "IsHidden", false, "is_hidden");
        public final static Property Slot = new Property(3, long.class, "Slot", false, "slot");
    };

    private DaoSession daoSession;


    public PokemonAbilitiesDao(DaoConfig config) {
        super(config);
    }
    
    public PokemonAbilitiesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"pokemon_abilities\" (" + //
                "\"pokemon_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: PokemonId
                "\"ability_id\" INTEGER NOT NULL ," + // 1: AbilityId
                "\"is_hidden\" INTEGER NOT NULL ," + // 2: IsHidden
                "\"slot\" INTEGER NOT NULL );"); // 3: Slot
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_pokemon_abilities_pokemon_id_slot ON pokemon_abilities" +
                " (\"pokemon_id\",\"slot\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"pokemon_abilities\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PokemonAbilities entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPokemonId());
        stmt.bindLong(2, entity.getAbilityId());
        stmt.bindLong(3, entity.getIsHidden() ? 1L: 0L);
        stmt.bindLong(4, entity.getSlot());
    }

    @Override
    protected void attachEntity(PokemonAbilities entity) {
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
    public PokemonAbilities readEntity(Cursor cursor, int offset) {
        PokemonAbilities entity = new PokemonAbilities( //
            cursor.getLong(offset + 0), // PokemonId
            cursor.getLong(offset + 1), // AbilityId
            cursor.getShort(offset + 2) != 0, // IsHidden
            cursor.getLong(offset + 3) // Slot
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PokemonAbilities entity, int offset) {
        entity.setPokemonId(cursor.getLong(offset + 0));
        entity.setAbilityId(cursor.getLong(offset + 1));
        entity.setIsHidden(cursor.getShort(offset + 2) != 0);
        entity.setSlot(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PokemonAbilities entity, long rowId) {
        entity.setPokemonId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PokemonAbilities entity) {
        if(entity != null) {
            return entity.getPokemonId();
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
            SqlUtils.appendColumns(builder, "T1", daoSession.getAbilitiesDao().getAllColumns());
            builder.append(" FROM pokemon_abilities T");
            builder.append(" LEFT JOIN pokemon T0 ON T.\"pokemon_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN abilities T1 ON T.\"ability_id\"=T1.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PokemonAbilities loadCurrentDeep(Cursor cursor, boolean lock) {
        PokemonAbilities entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Pokemon Pokemon = loadCurrentOther(daoSession.getPokemonDao(), cursor, offset);
         if(Pokemon != null) {
            entity.setPokemon(Pokemon);
        }
        offset += daoSession.getPokemonDao().getAllColumns().length;

        Abilities Abilities = loadCurrentOther(daoSession.getAbilitiesDao(), cursor, offset);
         if(Abilities != null) {
            entity.setAbilities(Abilities);
        }

        return entity;    
    }

    public PokemonAbilities loadDeep(Long key) {
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
    public List<PokemonAbilities> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PokemonAbilities> list = new ArrayList<PokemonAbilities>(count);
        
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
    
    protected List<PokemonAbilities> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PokemonAbilities> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
