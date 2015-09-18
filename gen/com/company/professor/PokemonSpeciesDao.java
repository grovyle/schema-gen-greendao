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

import com.company.professor.PokemonSpecies;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "pokemon_species".
*/
public class PokemonSpeciesDao extends AbstractDao<PokemonSpecies, Long> {

    public static final String TABLENAME = "pokemon_species";

    /**
     * Properties of entity PokemonSpecies.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property Identifier = new Property(1, String.class, "Identifier", false, "identifier");
        public final static Property GenerationId = new Property(2, Long.class, "GenerationId", false, "generation_id");
        public final static Property EvolvesFromSpeciesId = new Property(3, Long.class, "EvolvesFromSpeciesId", false, "evolves_from_species_id");
        public final static Property EvolutionChainId = new Property(4, Long.class, "EvolutionChainId", false, "evolution_chain_id");
        public final static Property ColorId = new Property(5, long.class, "ColorId", false, "color_id");
        public final static Property ShapeId = new Property(6, long.class, "ShapeId", false, "shape_id");
        public final static Property HabitatId = new Property(7, Long.class, "HabitatId", false, "habitat_id");
        public final static Property GenderRate = new Property(8, long.class, "GenderRate", false, "gender_rate");
        public final static Property CaptureRate = new Property(9, long.class, "CaptureRate", false, "capture_rate");
        public final static Property BaseHappiness = new Property(10, long.class, "BaseHappiness", false, "base_happiness");
        public final static Property IsBaby = new Property(11, boolean.class, "IsBaby", false, "is_baby");
        public final static Property HatchCounter = new Property(12, long.class, "HatchCounter", false, "hatch_counter");
        public final static Property HasGenderDifferences = new Property(13, boolean.class, "HasGenderDifferences", false, "has_gender_differences");
        public final static Property GrowthRateId = new Property(14, long.class, "GrowthRateId", false, "growth_rate_id");
        public final static Property FormsSwitchable = new Property(15, boolean.class, "FormsSwitchable", false, "forms_switchable");
        public final static Property Order = new Property(16, long.class, "Order", false, "order");
        public final static Property ConquestOrder = new Property(17, Long.class, "ConquestOrder", false, "conquest_order");
    };

    private DaoSession daoSession;


    public PokemonSpeciesDao(DaoConfig config) {
        super(config);
    }
    
    public PokemonSpeciesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"pokemon_species\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"identifier\" TEXT NOT NULL ," + // 1: Identifier
                "\"generation_id\" INTEGER," + // 2: GenerationId
                "\"evolves_from_species_id\" INTEGER," + // 3: EvolvesFromSpeciesId
                "\"evolution_chain_id\" INTEGER," + // 4: EvolutionChainId
                "\"color_id\" INTEGER NOT NULL ," + // 5: ColorId
                "\"shape_id\" INTEGER NOT NULL ," + // 6: ShapeId
                "\"habitat_id\" INTEGER," + // 7: HabitatId
                "\"gender_rate\" INTEGER NOT NULL ," + // 8: GenderRate
                "\"capture_rate\" INTEGER NOT NULL ," + // 9: CaptureRate
                "\"base_happiness\" INTEGER NOT NULL ," + // 10: BaseHappiness
                "\"is_baby\" INTEGER NOT NULL ," + // 11: IsBaby
                "\"hatch_counter\" INTEGER NOT NULL ," + // 12: HatchCounter
                "\"has_gender_differences\" INTEGER NOT NULL ," + // 13: HasGenderDifferences
                "\"growth_rate_id\" INTEGER NOT NULL ," + // 14: GrowthRateId
                "\"forms_switchable\" INTEGER NOT NULL ," + // 15: FormsSwitchable
                "\"order\" INTEGER NOT NULL ," + // 16: Order
                "\"conquest_order\" INTEGER);"); // 17: ConquestOrder
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"pokemon_species\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PokemonSpecies entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getIdentifier());
 
        Long GenerationId = entity.getGenerationId();
        if (GenerationId != null) {
            stmt.bindLong(3, GenerationId);
        }
 
        Long EvolvesFromSpeciesId = entity.getEvolvesFromSpeciesId();
        if (EvolvesFromSpeciesId != null) {
            stmt.bindLong(4, EvolvesFromSpeciesId);
        }
 
        Long EvolutionChainId = entity.getEvolutionChainId();
        if (EvolutionChainId != null) {
            stmt.bindLong(5, EvolutionChainId);
        }
        stmt.bindLong(6, entity.getColorId());
        stmt.bindLong(7, entity.getShapeId());
 
        Long HabitatId = entity.getHabitatId();
        if (HabitatId != null) {
            stmt.bindLong(8, HabitatId);
        }
        stmt.bindLong(9, entity.getGenderRate());
        stmt.bindLong(10, entity.getCaptureRate());
        stmt.bindLong(11, entity.getBaseHappiness());
        stmt.bindLong(12, entity.getIsBaby() ? 1L: 0L);
        stmt.bindLong(13, entity.getHatchCounter());
        stmt.bindLong(14, entity.getHasGenderDifferences() ? 1L: 0L);
        stmt.bindLong(15, entity.getGrowthRateId());
        stmt.bindLong(16, entity.getFormsSwitchable() ? 1L: 0L);
        stmt.bindLong(17, entity.getOrder());
 
        Long ConquestOrder = entity.getConquestOrder();
        if (ConquestOrder != null) {
            stmt.bindLong(18, ConquestOrder);
        }
    }

    @Override
    protected void attachEntity(PokemonSpecies entity) {
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
    public PokemonSpecies readEntity(Cursor cursor, int offset) {
        PokemonSpecies entity = new PokemonSpecies( //
            cursor.getLong(offset + 0), // Id
            cursor.getString(offset + 1), // Identifier
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // GenerationId
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // EvolvesFromSpeciesId
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // EvolutionChainId
            cursor.getLong(offset + 5), // ColorId
            cursor.getLong(offset + 6), // ShapeId
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // HabitatId
            cursor.getLong(offset + 8), // GenderRate
            cursor.getLong(offset + 9), // CaptureRate
            cursor.getLong(offset + 10), // BaseHappiness
            cursor.getShort(offset + 11) != 0, // IsBaby
            cursor.getLong(offset + 12), // HatchCounter
            cursor.getShort(offset + 13) != 0, // HasGenderDifferences
            cursor.getLong(offset + 14), // GrowthRateId
            cursor.getShort(offset + 15) != 0, // FormsSwitchable
            cursor.getLong(offset + 16), // Order
            cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17) // ConquestOrder
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PokemonSpecies entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setIdentifier(cursor.getString(offset + 1));
        entity.setGenerationId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setEvolvesFromSpeciesId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setEvolutionChainId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setColorId(cursor.getLong(offset + 5));
        entity.setShapeId(cursor.getLong(offset + 6));
        entity.setHabitatId(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setGenderRate(cursor.getLong(offset + 8));
        entity.setCaptureRate(cursor.getLong(offset + 9));
        entity.setBaseHappiness(cursor.getLong(offset + 10));
        entity.setIsBaby(cursor.getShort(offset + 11) != 0);
        entity.setHatchCounter(cursor.getLong(offset + 12));
        entity.setHasGenderDifferences(cursor.getShort(offset + 13) != 0);
        entity.setGrowthRateId(cursor.getLong(offset + 14));
        entity.setFormsSwitchable(cursor.getShort(offset + 15) != 0);
        entity.setOrder(cursor.getLong(offset + 16));
        entity.setConquestOrder(cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PokemonSpecies entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PokemonSpecies entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getGenerationsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getPokemonSpeciesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getEvolutionChainsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T3", daoSession.getPokemonColorsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T4", daoSession.getPokemonShapesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T5", daoSession.getPokemonHabitatsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T6", daoSession.getGrowthRatesDao().getAllColumns());
            builder.append(" FROM pokemon_species T");
            builder.append(" LEFT JOIN generations T0 ON T.\"generation_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN pokemon_species T1 ON T.\"evolves_from_species_id\"=T1.\"id\"");
            builder.append(" LEFT JOIN evolution_chains T2 ON T.\"evolution_chain_id\"=T2.\"id\"");
            builder.append(" LEFT JOIN pokemon_colors T3 ON T.\"color_id\"=T3.\"id\"");
            builder.append(" LEFT JOIN pokemon_shapes T4 ON T.\"shape_id\"=T4.\"id\"");
            builder.append(" LEFT JOIN pokemon_habitats T5 ON T.\"habitat_id\"=T5.\"id\"");
            builder.append(" LEFT JOIN growth_rates T6 ON T.\"growth_rate_id\"=T6.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PokemonSpecies loadCurrentDeep(Cursor cursor, boolean lock) {
        PokemonSpecies entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Generations Generations = loadCurrentOther(daoSession.getGenerationsDao(), cursor, offset);
        entity.setGenerations(Generations);
        offset += daoSession.getGenerationsDao().getAllColumns().length;

        PokemonSpecies PokemonSpecies = loadCurrentOther(daoSession.getPokemonSpeciesDao(), cursor, offset);
        entity.setPokemonSpecies(PokemonSpecies);
        offset += daoSession.getPokemonSpeciesDao().getAllColumns().length;

        EvolutionChains EvolutionChains = loadCurrentOther(daoSession.getEvolutionChainsDao(), cursor, offset);
        entity.setEvolutionChains(EvolutionChains);
        offset += daoSession.getEvolutionChainsDao().getAllColumns().length;

        PokemonColors PokemonColors = loadCurrentOther(daoSession.getPokemonColorsDao(), cursor, offset);
         if(PokemonColors != null) {
            entity.setPokemonColors(PokemonColors);
        }
        offset += daoSession.getPokemonColorsDao().getAllColumns().length;

        PokemonShapes PokemonShapes = loadCurrentOther(daoSession.getPokemonShapesDao(), cursor, offset);
         if(PokemonShapes != null) {
            entity.setPokemonShapes(PokemonShapes);
        }
        offset += daoSession.getPokemonShapesDao().getAllColumns().length;

        PokemonHabitats PokemonHabitats = loadCurrentOther(daoSession.getPokemonHabitatsDao(), cursor, offset);
        entity.setPokemonHabitats(PokemonHabitats);
        offset += daoSession.getPokemonHabitatsDao().getAllColumns().length;

        GrowthRates GrowthRates = loadCurrentOther(daoSession.getGrowthRatesDao(), cursor, offset);
         if(GrowthRates != null) {
            entity.setGrowthRates(GrowthRates);
        }

        return entity;    
    }

    public PokemonSpecies loadDeep(Long key) {
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
    public List<PokemonSpecies> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PokemonSpecies> list = new ArrayList<PokemonSpecies>(count);
        
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
    
    protected List<PokemonSpecies> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PokemonSpecies> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
