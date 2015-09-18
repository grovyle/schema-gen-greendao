package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "natures".
 */
public class Natures {

    private long Id;
    /** Not-null value. */
    private String Identifier;
    private long DecreasedStatId;
    private long IncreasedStatId;
    private long HatesFlavorId;
    private long LikesFlavorId;
    private long GameIndex;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient NaturesDao myDao;

    private Stats DecreasedStat;
    private Long DecreasedStat__resolvedKey;

    private Stats IncreasedStat;
    private Long IncreasedStat__resolvedKey;

    private ContestTypes HatesFlavor;
    private Long HatesFlavor__resolvedKey;

    private ContestTypes LikesFlavor;
    private Long LikesFlavor__resolvedKey;


    public Natures() {
    }

    public Natures(long Id) {
        this.Id = Id;
    }

    public Natures(long Id, String Identifier, long DecreasedStatId, long IncreasedStatId, long HatesFlavorId, long LikesFlavorId, long GameIndex) {
        this.Id = Id;
        this.Identifier = Identifier;
        this.DecreasedStatId = DecreasedStatId;
        this.IncreasedStatId = IncreasedStatId;
        this.HatesFlavorId = HatesFlavorId;
        this.LikesFlavorId = LikesFlavorId;
        this.GameIndex = GameIndex;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getNaturesDao() : null;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    /** Not-null value. */
    public String getIdentifier() {
        return Identifier;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    public long getDecreasedStatId() {
        return DecreasedStatId;
    }

    public void setDecreasedStatId(long DecreasedStatId) {
        this.DecreasedStatId = DecreasedStatId;
    }

    public long getIncreasedStatId() {
        return IncreasedStatId;
    }

    public void setIncreasedStatId(long IncreasedStatId) {
        this.IncreasedStatId = IncreasedStatId;
    }

    public long getHatesFlavorId() {
        return HatesFlavorId;
    }

    public void setHatesFlavorId(long HatesFlavorId) {
        this.HatesFlavorId = HatesFlavorId;
    }

    public long getLikesFlavorId() {
        return LikesFlavorId;
    }

    public void setLikesFlavorId(long LikesFlavorId) {
        this.LikesFlavorId = LikesFlavorId;
    }

    public long getGameIndex() {
        return GameIndex;
    }

    public void setGameIndex(long GameIndex) {
        this.GameIndex = GameIndex;
    }

    /** To-one relationship, resolved on first access. */
    public Stats getDecreasedStat() {
        long __key = this.DecreasedStatId;
        if (DecreasedStat__resolvedKey == null || !DecreasedStat__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StatsDao targetDao = daoSession.getStatsDao();
            Stats DecreasedStatNew = targetDao.load(__key);
            synchronized (this) {
                DecreasedStat = DecreasedStatNew;
            	DecreasedStat__resolvedKey = __key;
            }
        }
        return DecreasedStat;
    }

    public void setDecreasedStat(Stats DecreasedStat) {
        if (DecreasedStat == null) {
            throw new DaoException("To-one property 'DecreasedStatId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.DecreasedStat = DecreasedStat;
            DecreasedStatId = DecreasedStat.getId();
            DecreasedStat__resolvedKey = DecreasedStatId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Stats getIncreasedStat() {
        long __key = this.IncreasedStatId;
        if (IncreasedStat__resolvedKey == null || !IncreasedStat__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StatsDao targetDao = daoSession.getStatsDao();
            Stats IncreasedStatNew = targetDao.load(__key);
            synchronized (this) {
                IncreasedStat = IncreasedStatNew;
            	IncreasedStat__resolvedKey = __key;
            }
        }
        return IncreasedStat;
    }

    public void setIncreasedStat(Stats IncreasedStat) {
        if (IncreasedStat == null) {
            throw new DaoException("To-one property 'IncreasedStatId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.IncreasedStat = IncreasedStat;
            IncreasedStatId = IncreasedStat.getId();
            IncreasedStat__resolvedKey = IncreasedStatId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public ContestTypes getHatesFlavor() {
        long __key = this.HatesFlavorId;
        if (HatesFlavor__resolvedKey == null || !HatesFlavor__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContestTypesDao targetDao = daoSession.getContestTypesDao();
            ContestTypes HatesFlavorNew = targetDao.load(__key);
            synchronized (this) {
                HatesFlavor = HatesFlavorNew;
            	HatesFlavor__resolvedKey = __key;
            }
        }
        return HatesFlavor;
    }

    public void setHatesFlavor(ContestTypes HatesFlavor) {
        if (HatesFlavor == null) {
            throw new DaoException("To-one property 'HatesFlavorId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.HatesFlavor = HatesFlavor;
            HatesFlavorId = HatesFlavor.getId();
            HatesFlavor__resolvedKey = HatesFlavorId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public ContestTypes getLikesFlavor() {
        long __key = this.LikesFlavorId;
        if (LikesFlavor__resolvedKey == null || !LikesFlavor__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContestTypesDao targetDao = daoSession.getContestTypesDao();
            ContestTypes LikesFlavorNew = targetDao.load(__key);
            synchronized (this) {
                LikesFlavor = LikesFlavorNew;
            	LikesFlavor__resolvedKey = __key;
            }
        }
        return LikesFlavor;
    }

    public void setLikesFlavor(ContestTypes LikesFlavor) {
        if (LikesFlavor == null) {
            throw new DaoException("To-one property 'LikesFlavorId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.LikesFlavor = LikesFlavor;
            LikesFlavorId = LikesFlavor.getId();
            LikesFlavor__resolvedKey = LikesFlavorId;
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
