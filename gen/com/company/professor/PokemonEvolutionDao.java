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

import com.company.professor.PokemonEvolution;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "pokemon_evolution".
*/
public class PokemonEvolutionDao extends AbstractDao<PokemonEvolution, Long> {

    public static final String TABLENAME = "pokemon_evolution";

    /**
     * Properties of entity PokemonEvolution.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property EvolvedSpeciesId = new Property(1, long.class, "EvolvedSpeciesId", false, "evolved_species_id");
        public final static Property EvolutionTriggerId = new Property(2, long.class, "EvolutionTriggerId", false, "evolution_trigger_id");
        public final static Property TriggerItemId = new Property(3, Long.class, "TriggerItemId", false, "trigger_item_id");
        public final static Property MinimumLevel = new Property(4, Long.class, "MinimumLevel", false, "minimum_level");
        public final static Property GenderId = new Property(5, Long.class, "GenderId", false, "gender_id");
        public final static Property LocationId = new Property(6, Long.class, "LocationId", false, "location_id");
        public final static Property HeldItemId = new Property(7, Long.class, "HeldItemId", false, "held_item_id");
        public final static Property TimeOfDay = new Property(8, String.class, "TimeOfDay", false, "time_of_day");
        public final static Property KnownMoveId = new Property(9, Long.class, "KnownMoveId", false, "known_move_id");
        public final static Property KnownMoveTypeId = new Property(10, Long.class, "KnownMoveTypeId", false, "known_move_type_id");
        public final static Property MinimumHappiness = new Property(11, Long.class, "MinimumHappiness", false, "minimum_happiness");
        public final static Property MinimumBeauty = new Property(12, Long.class, "MinimumBeauty", false, "minimum_beauty");
        public final static Property MinimumAffection = new Property(13, Long.class, "MinimumAffection", false, "minimum_affection");
        public final static Property RelativePhysicalStats = new Property(14, Long.class, "RelativePhysicalStats", false, "relative_physical_stats");
        public final static Property PartySpeciesId = new Property(15, Long.class, "PartySpeciesId", false, "party_species_id");
        public final static Property PartyTypeId = new Property(16, Long.class, "PartyTypeId", false, "party_type_id");
        public final static Property TradeSpeciesId = new Property(17, Long.class, "TradeSpeciesId", false, "trade_species_id");
        public final static Property NeedsOverworldRain = new Property(18, boolean.class, "NeedsOverworldRain", false, "needs_overworld_rain");
        public final static Property TurnUpsideDown = new Property(19, boolean.class, "TurnUpsideDown", false, "turn_upside_down");
    };

    private DaoSession daoSession;


    public PokemonEvolutionDao(DaoConfig config) {
        super(config);
    }
    
    public PokemonEvolutionDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"pokemon_evolution\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"evolved_species_id\" INTEGER NOT NULL ," + // 1: EvolvedSpeciesId
                "\"evolution_trigger_id\" INTEGER NOT NULL ," + // 2: EvolutionTriggerId
                "\"trigger_item_id\" INTEGER," + // 3: TriggerItemId
                "\"minimum_level\" INTEGER," + // 4: MinimumLevel
                "\"gender_id\" INTEGER," + // 5: GenderId
                "\"location_id\" INTEGER," + // 6: LocationId
                "\"held_item_id\" INTEGER," + // 7: HeldItemId
                "\"time_of_day\" TEXT," + // 8: TimeOfDay
                "\"known_move_id\" INTEGER," + // 9: KnownMoveId
                "\"known_move_type_id\" INTEGER," + // 10: KnownMoveTypeId
                "\"minimum_happiness\" INTEGER," + // 11: MinimumHappiness
                "\"minimum_beauty\" INTEGER," + // 12: MinimumBeauty
                "\"minimum_affection\" INTEGER," + // 13: MinimumAffection
                "\"relative_physical_stats\" INTEGER," + // 14: RelativePhysicalStats
                "\"party_species_id\" INTEGER," + // 15: PartySpeciesId
                "\"party_type_id\" INTEGER," + // 16: PartyTypeId
                "\"trade_species_id\" INTEGER," + // 17: TradeSpeciesId
                "\"needs_overworld_rain\" INTEGER NOT NULL ," + // 18: NeedsOverworldRain
                "\"turn_upside_down\" INTEGER NOT NULL );"); // 19: TurnUpsideDown
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"pokemon_evolution\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PokemonEvolution entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getEvolvedSpeciesId());
        stmt.bindLong(3, entity.getEvolutionTriggerId());
 
        Long TriggerItemId = entity.getTriggerItemId();
        if (TriggerItemId != null) {
            stmt.bindLong(4, TriggerItemId);
        }
 
        Long MinimumLevel = entity.getMinimumLevel();
        if (MinimumLevel != null) {
            stmt.bindLong(5, MinimumLevel);
        }
 
        Long GenderId = entity.getGenderId();
        if (GenderId != null) {
            stmt.bindLong(6, GenderId);
        }
 
        Long LocationId = entity.getLocationId();
        if (LocationId != null) {
            stmt.bindLong(7, LocationId);
        }
 
        Long HeldItemId = entity.getHeldItemId();
        if (HeldItemId != null) {
            stmt.bindLong(8, HeldItemId);
        }
 
        String TimeOfDay = entity.getTimeOfDay();
        if (TimeOfDay != null) {
            stmt.bindString(9, TimeOfDay);
        }
 
        Long KnownMoveId = entity.getKnownMoveId();
        if (KnownMoveId != null) {
            stmt.bindLong(10, KnownMoveId);
        }
 
        Long KnownMoveTypeId = entity.getKnownMoveTypeId();
        if (KnownMoveTypeId != null) {
            stmt.bindLong(11, KnownMoveTypeId);
        }
 
        Long MinimumHappiness = entity.getMinimumHappiness();
        if (MinimumHappiness != null) {
            stmt.bindLong(12, MinimumHappiness);
        }
 
        Long MinimumBeauty = entity.getMinimumBeauty();
        if (MinimumBeauty != null) {
            stmt.bindLong(13, MinimumBeauty);
        }
 
        Long MinimumAffection = entity.getMinimumAffection();
        if (MinimumAffection != null) {
            stmt.bindLong(14, MinimumAffection);
        }
 
        Long RelativePhysicalStats = entity.getRelativePhysicalStats();
        if (RelativePhysicalStats != null) {
            stmt.bindLong(15, RelativePhysicalStats);
        }
 
        Long PartySpeciesId = entity.getPartySpeciesId();
        if (PartySpeciesId != null) {
            stmt.bindLong(16, PartySpeciesId);
        }
 
        Long PartyTypeId = entity.getPartyTypeId();
        if (PartyTypeId != null) {
            stmt.bindLong(17, PartyTypeId);
        }
 
        Long TradeSpeciesId = entity.getTradeSpeciesId();
        if (TradeSpeciesId != null) {
            stmt.bindLong(18, TradeSpeciesId);
        }
        stmt.bindLong(19, entity.getNeedsOverworldRain() ? 1L: 0L);
        stmt.bindLong(20, entity.getTurnUpsideDown() ? 1L: 0L);
    }

    @Override
    protected void attachEntity(PokemonEvolution entity) {
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
    public PokemonEvolution readEntity(Cursor cursor, int offset) {
        PokemonEvolution entity = new PokemonEvolution( //
            cursor.getLong(offset + 0), // Id
            cursor.getLong(offset + 1), // EvolvedSpeciesId
            cursor.getLong(offset + 2), // EvolutionTriggerId
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // TriggerItemId
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // MinimumLevel
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // GenderId
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // LocationId
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // HeldItemId
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // TimeOfDay
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9), // KnownMoveId
            cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10), // KnownMoveTypeId
            cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11), // MinimumHappiness
            cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12), // MinimumBeauty
            cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13), // MinimumAffection
            cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14), // RelativePhysicalStats
            cursor.isNull(offset + 15) ? null : cursor.getLong(offset + 15), // PartySpeciesId
            cursor.isNull(offset + 16) ? null : cursor.getLong(offset + 16), // PartyTypeId
            cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17), // TradeSpeciesId
            cursor.getShort(offset + 18) != 0, // NeedsOverworldRain
            cursor.getShort(offset + 19) != 0 // TurnUpsideDown
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PokemonEvolution entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setEvolvedSpeciesId(cursor.getLong(offset + 1));
        entity.setEvolutionTriggerId(cursor.getLong(offset + 2));
        entity.setTriggerItemId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setMinimumLevel(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setGenderId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setLocationId(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setHeldItemId(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setTimeOfDay(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setKnownMoveId(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
        entity.setKnownMoveTypeId(cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10));
        entity.setMinimumHappiness(cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11));
        entity.setMinimumBeauty(cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12));
        entity.setMinimumAffection(cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13));
        entity.setRelativePhysicalStats(cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14));
        entity.setPartySpeciesId(cursor.isNull(offset + 15) ? null : cursor.getLong(offset + 15));
        entity.setPartyTypeId(cursor.isNull(offset + 16) ? null : cursor.getLong(offset + 16));
        entity.setTradeSpeciesId(cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17));
        entity.setNeedsOverworldRain(cursor.getShort(offset + 18) != 0);
        entity.setTurnUpsideDown(cursor.getShort(offset + 19) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PokemonEvolution entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PokemonEvolution entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getPokemonSpeciesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getEvolutionTriggersDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getItemsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T3", daoSession.getGendersDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T4", daoSession.getLocationsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T5", daoSession.getItemsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T6", daoSession.getMovesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T7", daoSession.getTypesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T8", daoSession.getPokemonSpeciesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T9", daoSession.getTypesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T10", daoSession.getPokemonSpeciesDao().getAllColumns());
            builder.append(" FROM pokemon_evolution T");
            builder.append(" LEFT JOIN pokemon_species T0 ON T.\"evolved_species_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN evolution_triggers T1 ON T.\"evolution_trigger_id\"=T1.\"id\"");
            builder.append(" LEFT JOIN items T2 ON T.\"trigger_item_id\"=T2.\"id\"");
            builder.append(" LEFT JOIN genders T3 ON T.\"gender_id\"=T3.\"id\"");
            builder.append(" LEFT JOIN locations T4 ON T.\"location_id\"=T4.\"id\"");
            builder.append(" LEFT JOIN items T5 ON T.\"held_item_id\"=T5.\"id\"");
            builder.append(" LEFT JOIN moves T6 ON T.\"known_move_id\"=T6.\"id\"");
            builder.append(" LEFT JOIN types T7 ON T.\"known_move_type_id\"=T7.\"id\"");
            builder.append(" LEFT JOIN pokemon_species T8 ON T.\"party_species_id\"=T8.\"id\"");
            builder.append(" LEFT JOIN types T9 ON T.\"party_type_id\"=T9.\"id\"");
            builder.append(" LEFT JOIN pokemon_species T10 ON T.\"trade_species_id\"=T10.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PokemonEvolution loadCurrentDeep(Cursor cursor, boolean lock) {
        PokemonEvolution entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        PokemonSpecies EvolvedSpecies = loadCurrentOther(daoSession.getPokemonSpeciesDao(), cursor, offset);
         if(EvolvedSpecies != null) {
            entity.setEvolvedSpecies(EvolvedSpecies);
        }
        offset += daoSession.getPokemonSpeciesDao().getAllColumns().length;

        EvolutionTriggers EvolutionTriggers = loadCurrentOther(daoSession.getEvolutionTriggersDao(), cursor, offset);
         if(EvolutionTriggers != null) {
            entity.setEvolutionTriggers(EvolutionTriggers);
        }
        offset += daoSession.getEvolutionTriggersDao().getAllColumns().length;

        Items TriggerItem = loadCurrentOther(daoSession.getItemsDao(), cursor, offset);
        entity.setTriggerItem(TriggerItem);
        offset += daoSession.getItemsDao().getAllColumns().length;

        Genders Genders = loadCurrentOther(daoSession.getGendersDao(), cursor, offset);
        entity.setGenders(Genders);
        offset += daoSession.getGendersDao().getAllColumns().length;

        Locations Locations = loadCurrentOther(daoSession.getLocationsDao(), cursor, offset);
        entity.setLocations(Locations);
        offset += daoSession.getLocationsDao().getAllColumns().length;

        Items HeldItem = loadCurrentOther(daoSession.getItemsDao(), cursor, offset);
        entity.setHeldItem(HeldItem);
        offset += daoSession.getItemsDao().getAllColumns().length;

        Moves Moves = loadCurrentOther(daoSession.getMovesDao(), cursor, offset);
        entity.setMoves(Moves);
        offset += daoSession.getMovesDao().getAllColumns().length;

        Types KnownMoveType = loadCurrentOther(daoSession.getTypesDao(), cursor, offset);
        entity.setKnownMoveType(KnownMoveType);
        offset += daoSession.getTypesDao().getAllColumns().length;

        PokemonSpecies PartySpecies = loadCurrentOther(daoSession.getPokemonSpeciesDao(), cursor, offset);
        entity.setPartySpecies(PartySpecies);
        offset += daoSession.getPokemonSpeciesDao().getAllColumns().length;

        Types PartyType = loadCurrentOther(daoSession.getTypesDao(), cursor, offset);
        entity.setPartyType(PartyType);
        offset += daoSession.getTypesDao().getAllColumns().length;

        PokemonSpecies TradeSpecies = loadCurrentOther(daoSession.getPokemonSpeciesDao(), cursor, offset);
        entity.setTradeSpecies(TradeSpecies);

        return entity;    
    }

    public PokemonEvolution loadDeep(Long key) {
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
    public List<PokemonEvolution> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PokemonEvolution> list = new ArrayList<PokemonEvolution>(count);
        
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
    
    protected List<PokemonEvolution> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PokemonEvolution> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
