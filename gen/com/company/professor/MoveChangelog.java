package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "move_changelog".
 */
public class MoveChangelog {

    private long MoveId;
    private long ChangedInVersionGroupId;
    private Long TypeId;
    private Integer Power;
    private Integer Pp;
    private Integer Accuracy;
    private Long EffectId;
    private Long EffectChance;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MoveChangelogDao myDao;

    private Moves Moves;
    private Long Moves__resolvedKey;

    private VersionGroups VersionGroups;
    private Long VersionGroups__resolvedKey;

    private Types Types;
    private Long Types__resolvedKey;

    private MoveEffects MoveEffects;
    private Long MoveEffects__resolvedKey;


    public MoveChangelog() {
    }

    public MoveChangelog(long MoveId) {
        this.MoveId = MoveId;
    }

    public MoveChangelog(long MoveId, long ChangedInVersionGroupId, Long TypeId, Integer Power, Integer Pp, Integer Accuracy, Long EffectId, Long EffectChance) {
        this.MoveId = MoveId;
        this.ChangedInVersionGroupId = ChangedInVersionGroupId;
        this.TypeId = TypeId;
        this.Power = Power;
        this.Pp = Pp;
        this.Accuracy = Accuracy;
        this.EffectId = EffectId;
        this.EffectChance = EffectChance;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMoveChangelogDao() : null;
    }

    public long getMoveId() {
        return MoveId;
    }

    public void setMoveId(long MoveId) {
        this.MoveId = MoveId;
    }

    public long getChangedInVersionGroupId() {
        return ChangedInVersionGroupId;
    }

    public void setChangedInVersionGroupId(long ChangedInVersionGroupId) {
        this.ChangedInVersionGroupId = ChangedInVersionGroupId;
    }

    public Long getTypeId() {
        return TypeId;
    }

    public void setTypeId(Long TypeId) {
        this.TypeId = TypeId;
    }

    public Integer getPower() {
        return Power;
    }

    public void setPower(Integer Power) {
        this.Power = Power;
    }

    public Integer getPp() {
        return Pp;
    }

    public void setPp(Integer Pp) {
        this.Pp = Pp;
    }

    public Integer getAccuracy() {
        return Accuracy;
    }

    public void setAccuracy(Integer Accuracy) {
        this.Accuracy = Accuracy;
    }

    public Long getEffectId() {
        return EffectId;
    }

    public void setEffectId(Long EffectId) {
        this.EffectId = EffectId;
    }

    public Long getEffectChance() {
        return EffectChance;
    }

    public void setEffectChance(Long EffectChance) {
        this.EffectChance = EffectChance;
    }

    /** To-one relationship, resolved on first access. */
    public Moves getMoves() {
        long __key = this.MoveId;
        if (Moves__resolvedKey == null || !Moves__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MovesDao targetDao = daoSession.getMovesDao();
            Moves MovesNew = targetDao.load(__key);
            synchronized (this) {
                Moves = MovesNew;
            	Moves__resolvedKey = __key;
            }
        }
        return Moves;
    }

    public void setMoves(Moves Moves) {
        if (Moves == null) {
            throw new DaoException("To-one property 'MoveId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Moves = Moves;
            MoveId = Moves.getId();
            Moves__resolvedKey = MoveId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public VersionGroups getVersionGroups() {
        long __key = this.ChangedInVersionGroupId;
        if (VersionGroups__resolvedKey == null || !VersionGroups__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VersionGroupsDao targetDao = daoSession.getVersionGroupsDao();
            VersionGroups VersionGroupsNew = targetDao.load(__key);
            synchronized (this) {
                VersionGroups = VersionGroupsNew;
            	VersionGroups__resolvedKey = __key;
            }
        }
        return VersionGroups;
    }

    public void setVersionGroups(VersionGroups VersionGroups) {
        if (VersionGroups == null) {
            throw new DaoException("To-one property 'ChangedInVersionGroupId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.VersionGroups = VersionGroups;
            ChangedInVersionGroupId = VersionGroups.getId();
            VersionGroups__resolvedKey = ChangedInVersionGroupId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Types getTypes() {
        Long __key = this.TypeId;
        if (Types__resolvedKey == null || !Types__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypesDao targetDao = daoSession.getTypesDao();
            Types TypesNew = targetDao.load(__key);
            synchronized (this) {
                Types = TypesNew;
            	Types__resolvedKey = __key;
            }
        }
        return Types;
    }

    public void setTypes(Types Types) {
        synchronized (this) {
            this.Types = Types;
            TypeId = Types == null ? null : Types.getId();
            Types__resolvedKey = TypeId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public MoveEffects getMoveEffects() {
        Long __key = this.EffectId;
        if (MoveEffects__resolvedKey == null || !MoveEffects__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MoveEffectsDao targetDao = daoSession.getMoveEffectsDao();
            MoveEffects MoveEffectsNew = targetDao.load(__key);
            synchronized (this) {
                MoveEffects = MoveEffectsNew;
            	MoveEffects__resolvedKey = __key;
            }
        }
        return MoveEffects;
    }

    public void setMoveEffects(MoveEffects MoveEffects) {
        synchronized (this) {
            this.MoveEffects = MoveEffects;
            EffectId = MoveEffects == null ? null : MoveEffects.getId();
            MoveEffects__resolvedKey = EffectId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
