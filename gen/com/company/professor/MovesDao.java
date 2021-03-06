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

import com.company.professor.Moves;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "moves".
*/
public class MovesDao extends AbstractDao<Moves, Long> {

    public static final String TABLENAME = "moves";

    /**
     * Properties of entity Moves.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "Id", true, "id");
        public final static Property Identifier = new Property(1, String.class, "Identifier", false, "identifier");
        public final static Property GenerationId = new Property(2, long.class, "GenerationId", false, "generation_id");
        public final static Property TypeId = new Property(3, long.class, "TypeId", false, "type_id");
        public final static Property Power = new Property(4, Integer.class, "Power", false, "power");
        public final static Property Pp = new Property(5, Integer.class, "Pp", false, "pp");
        public final static Property Accuracy = new Property(6, Integer.class, "Accuracy", false, "accuracy");
        public final static Property Priority = new Property(7, int.class, "Priority", false, "priority");
        public final static Property TargetId = new Property(8, long.class, "TargetId", false, "target_id");
        public final static Property DamageClassId = new Property(9, long.class, "DamageClassId", false, "damage_class_id");
        public final static Property EffectId = new Property(10, long.class, "EffectId", false, "effect_id");
        public final static Property EffectChance = new Property(11, Long.class, "EffectChance", false, "effect_chance");
        public final static Property ContestTypeId = new Property(12, Long.class, "ContestTypeId", false, "contest_type_id");
        public final static Property ContestEffectId = new Property(13, Long.class, "ContestEffectId", false, "contest_effect_id");
        public final static Property SuperContestEffectId = new Property(14, Long.class, "SuperContestEffectId", false, "super_contest_effect_id");
    };

    private DaoSession daoSession;


    public MovesDao(DaoConfig config) {
        super(config);
    }
    
    public MovesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"moves\" (" + //
                "\"id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"identifier\" TEXT NOT NULL ," + // 1: Identifier
                "\"generation_id\" INTEGER NOT NULL ," + // 2: GenerationId
                "\"type_id\" INTEGER NOT NULL ," + // 3: TypeId
                "\"power\" INTEGER," + // 4: Power
                "\"pp\" INTEGER," + // 5: Pp
                "\"accuracy\" INTEGER," + // 6: Accuracy
                "\"priority\" INTEGER NOT NULL ," + // 7: Priority
                "\"target_id\" INTEGER NOT NULL ," + // 8: TargetId
                "\"damage_class_id\" INTEGER NOT NULL ," + // 9: DamageClassId
                "\"effect_id\" INTEGER NOT NULL ," + // 10: EffectId
                "\"effect_chance\" INTEGER," + // 11: EffectChance
                "\"contest_type_id\" INTEGER," + // 12: ContestTypeId
                "\"contest_effect_id\" INTEGER," + // 13: ContestEffectId
                "\"super_contest_effect_id\" INTEGER);"); // 14: SuperContestEffectId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"moves\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Moves entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getIdentifier());
        stmt.bindLong(3, entity.getGenerationId());
        stmt.bindLong(4, entity.getTypeId());
 
        Integer Power = entity.getPower();
        if (Power != null) {
            stmt.bindLong(5, Power);
        }
 
        Integer Pp = entity.getPp();
        if (Pp != null) {
            stmt.bindLong(6, Pp);
        }
 
        Integer Accuracy = entity.getAccuracy();
        if (Accuracy != null) {
            stmt.bindLong(7, Accuracy);
        }
        stmt.bindLong(8, entity.getPriority());
        stmt.bindLong(9, entity.getTargetId());
        stmt.bindLong(10, entity.getDamageClassId());
        stmt.bindLong(11, entity.getEffectId());
 
        Long EffectChance = entity.getEffectChance();
        if (EffectChance != null) {
            stmt.bindLong(12, EffectChance);
        }
 
        Long ContestTypeId = entity.getContestTypeId();
        if (ContestTypeId != null) {
            stmt.bindLong(13, ContestTypeId);
        }
 
        Long ContestEffectId = entity.getContestEffectId();
        if (ContestEffectId != null) {
            stmt.bindLong(14, ContestEffectId);
        }
 
        Long SuperContestEffectId = entity.getSuperContestEffectId();
        if (SuperContestEffectId != null) {
            stmt.bindLong(15, SuperContestEffectId);
        }
    }

    @Override
    protected void attachEntity(Moves entity) {
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
    public Moves readEntity(Cursor cursor, int offset) {
        Moves entity = new Moves( //
            cursor.getLong(offset + 0), // Id
            cursor.getString(offset + 1), // Identifier
            cursor.getLong(offset + 2), // GenerationId
            cursor.getLong(offset + 3), // TypeId
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // Power
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // Pp
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // Accuracy
            cursor.getInt(offset + 7), // Priority
            cursor.getLong(offset + 8), // TargetId
            cursor.getLong(offset + 9), // DamageClassId
            cursor.getLong(offset + 10), // EffectId
            cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11), // EffectChance
            cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12), // ContestTypeId
            cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13), // ContestEffectId
            cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14) // SuperContestEffectId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Moves entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setIdentifier(cursor.getString(offset + 1));
        entity.setGenerationId(cursor.getLong(offset + 2));
        entity.setTypeId(cursor.getLong(offset + 3));
        entity.setPower(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setPp(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setAccuracy(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setPriority(cursor.getInt(offset + 7));
        entity.setTargetId(cursor.getLong(offset + 8));
        entity.setDamageClassId(cursor.getLong(offset + 9));
        entity.setEffectId(cursor.getLong(offset + 10));
        entity.setEffectChance(cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11));
        entity.setContestTypeId(cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12));
        entity.setContestEffectId(cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13));
        entity.setSuperContestEffectId(cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Moves entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Moves entity) {
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
            SqlUtils.appendColumns(builder, "T1", daoSession.getTypesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getMoveTargetsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T3", daoSession.getMoveDamageClassesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T4", daoSession.getMoveEffectsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T5", daoSession.getContestTypesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T6", daoSession.getContestEffectsDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T7", daoSession.getSuperContestEffectsDao().getAllColumns());
            builder.append(" FROM moves T");
            builder.append(" LEFT JOIN generations T0 ON T.\"generation_id\"=T0.\"id\"");
            builder.append(" LEFT JOIN types T1 ON T.\"type_id\"=T1.\"id\"");
            builder.append(" LEFT JOIN move_targets T2 ON T.\"target_id\"=T2.\"id\"");
            builder.append(" LEFT JOIN move_damage_classes T3 ON T.\"damage_class_id\"=T3.\"id\"");
            builder.append(" LEFT JOIN move_effects T4 ON T.\"effect_id\"=T4.\"id\"");
            builder.append(" LEFT JOIN contest_types T5 ON T.\"contest_type_id\"=T5.\"id\"");
            builder.append(" LEFT JOIN contest_effects T6 ON T.\"contest_effect_id\"=T6.\"id\"");
            builder.append(" LEFT JOIN super_contest_effects T7 ON T.\"super_contest_effect_id\"=T7.\"id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Moves loadCurrentDeep(Cursor cursor, boolean lock) {
        Moves entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Generations Generations = loadCurrentOther(daoSession.getGenerationsDao(), cursor, offset);
         if(Generations != null) {
            entity.setGenerations(Generations);
        }
        offset += daoSession.getGenerationsDao().getAllColumns().length;

        Types Types = loadCurrentOther(daoSession.getTypesDao(), cursor, offset);
         if(Types != null) {
            entity.setTypes(Types);
        }
        offset += daoSession.getTypesDao().getAllColumns().length;

        MoveTargets MoveTargets = loadCurrentOther(daoSession.getMoveTargetsDao(), cursor, offset);
         if(MoveTargets != null) {
            entity.setMoveTargets(MoveTargets);
        }
        offset += daoSession.getMoveTargetsDao().getAllColumns().length;

        MoveDamageClasses MoveDamageClasses = loadCurrentOther(daoSession.getMoveDamageClassesDao(), cursor, offset);
         if(MoveDamageClasses != null) {
            entity.setMoveDamageClasses(MoveDamageClasses);
        }
        offset += daoSession.getMoveDamageClassesDao().getAllColumns().length;

        MoveEffects MoveEffects = loadCurrentOther(daoSession.getMoveEffectsDao(), cursor, offset);
         if(MoveEffects != null) {
            entity.setMoveEffects(MoveEffects);
        }
        offset += daoSession.getMoveEffectsDao().getAllColumns().length;

        ContestTypes ContestTypes = loadCurrentOther(daoSession.getContestTypesDao(), cursor, offset);
        entity.setContestTypes(ContestTypes);
        offset += daoSession.getContestTypesDao().getAllColumns().length;

        ContestEffects ContestEffects = loadCurrentOther(daoSession.getContestEffectsDao(), cursor, offset);
        entity.setContestEffects(ContestEffects);
        offset += daoSession.getContestEffectsDao().getAllColumns().length;

        SuperContestEffects SuperContestEffects = loadCurrentOther(daoSession.getSuperContestEffectsDao(), cursor, offset);
        entity.setSuperContestEffects(SuperContestEffects);

        return entity;    
    }

    public Moves loadDeep(Long key) {
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
    public List<Moves> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Moves> list = new ArrayList<Moves>(count);
        
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
    
    protected List<Moves> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Moves> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
