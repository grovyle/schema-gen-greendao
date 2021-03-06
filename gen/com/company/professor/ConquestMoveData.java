package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "conquest_move_data".
 */
public class ConquestMoveData {

    private long MoveId;
    private Long Power;
    private Long Accuracy;
    private Long EffectChance;
    private long EffectId;
    private long RangeId;
    private Long DisplacementId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ConquestMoveDataDao myDao;

    private Moves Moves;
    private Long Moves__resolvedKey;

    private ConquestMoveEffects ConquestMoveEffects;
    private Long ConquestMoveEffects__resolvedKey;

    private ConquestMoveRanges ConquestMoveRanges;
    private Long ConquestMoveRanges__resolvedKey;

    private ConquestMoveDisplacements ConquestMoveDisplacements;
    private Long ConquestMoveDisplacements__resolvedKey;


    public ConquestMoveData() {
    }

    public ConquestMoveData(long MoveId) {
        this.MoveId = MoveId;
    }

    public ConquestMoveData(long MoveId, Long Power, Long Accuracy, Long EffectChance, long EffectId, long RangeId, Long DisplacementId) {
        this.MoveId = MoveId;
        this.Power = Power;
        this.Accuracy = Accuracy;
        this.EffectChance = EffectChance;
        this.EffectId = EffectId;
        this.RangeId = RangeId;
        this.DisplacementId = DisplacementId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getConquestMoveDataDao() : null;
    }

    public long getMoveId() {
        return MoveId;
    }

    public void setMoveId(long MoveId) {
        this.MoveId = MoveId;
    }

    public Long getPower() {
        return Power;
    }

    public void setPower(Long Power) {
        this.Power = Power;
    }

    public Long getAccuracy() {
        return Accuracy;
    }

    public void setAccuracy(Long Accuracy) {
        this.Accuracy = Accuracy;
    }

    public Long getEffectChance() {
        return EffectChance;
    }

    public void setEffectChance(Long EffectChance) {
        this.EffectChance = EffectChance;
    }

    public long getEffectId() {
        return EffectId;
    }

    public void setEffectId(long EffectId) {
        this.EffectId = EffectId;
    }

    public long getRangeId() {
        return RangeId;
    }

    public void setRangeId(long RangeId) {
        this.RangeId = RangeId;
    }

    public Long getDisplacementId() {
        return DisplacementId;
    }

    public void setDisplacementId(Long DisplacementId) {
        this.DisplacementId = DisplacementId;
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
    public ConquestMoveEffects getConquestMoveEffects() {
        long __key = this.EffectId;
        if (ConquestMoveEffects__resolvedKey == null || !ConquestMoveEffects__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ConquestMoveEffectsDao targetDao = daoSession.getConquestMoveEffectsDao();
            ConquestMoveEffects ConquestMoveEffectsNew = targetDao.load(__key);
            synchronized (this) {
                ConquestMoveEffects = ConquestMoveEffectsNew;
            	ConquestMoveEffects__resolvedKey = __key;
            }
        }
        return ConquestMoveEffects;
    }

    public void setConquestMoveEffects(ConquestMoveEffects ConquestMoveEffects) {
        if (ConquestMoveEffects == null) {
            throw new DaoException("To-one property 'EffectId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.ConquestMoveEffects = ConquestMoveEffects;
            EffectId = ConquestMoveEffects.getId();
            ConquestMoveEffects__resolvedKey = EffectId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public ConquestMoveRanges getConquestMoveRanges() {
        long __key = this.RangeId;
        if (ConquestMoveRanges__resolvedKey == null || !ConquestMoveRanges__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ConquestMoveRangesDao targetDao = daoSession.getConquestMoveRangesDao();
            ConquestMoveRanges ConquestMoveRangesNew = targetDao.load(__key);
            synchronized (this) {
                ConquestMoveRanges = ConquestMoveRangesNew;
            	ConquestMoveRanges__resolvedKey = __key;
            }
        }
        return ConquestMoveRanges;
    }

    public void setConquestMoveRanges(ConquestMoveRanges ConquestMoveRanges) {
        if (ConquestMoveRanges == null) {
            throw new DaoException("To-one property 'RangeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.ConquestMoveRanges = ConquestMoveRanges;
            RangeId = ConquestMoveRanges.getId();
            ConquestMoveRanges__resolvedKey = RangeId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public ConquestMoveDisplacements getConquestMoveDisplacements() {
        Long __key = this.DisplacementId;
        if (ConquestMoveDisplacements__resolvedKey == null || !ConquestMoveDisplacements__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ConquestMoveDisplacementsDao targetDao = daoSession.getConquestMoveDisplacementsDao();
            ConquestMoveDisplacements ConquestMoveDisplacementsNew = targetDao.load(__key);
            synchronized (this) {
                ConquestMoveDisplacements = ConquestMoveDisplacementsNew;
            	ConquestMoveDisplacements__resolvedKey = __key;
            }
        }
        return ConquestMoveDisplacements;
    }

    public void setConquestMoveDisplacements(ConquestMoveDisplacements ConquestMoveDisplacements) {
        synchronized (this) {
            this.ConquestMoveDisplacements = ConquestMoveDisplacements;
            DisplacementId = ConquestMoveDisplacements == null ? null : ConquestMoveDisplacements.getId();
            ConquestMoveDisplacements__resolvedKey = DisplacementId;
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
