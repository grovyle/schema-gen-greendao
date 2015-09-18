package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "nature_pokeathlon_stats".
 */
public class NaturePokeathlonStats {

    private long NatureId;
    private long PokeathlonStatId;
    private long MaxChange;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient NaturePokeathlonStatsDao myDao;

    private Natures Natures;
    private Long Natures__resolvedKey;

    private PokeathlonStats PokeathlonStats;
    private Long PokeathlonStats__resolvedKey;


    public NaturePokeathlonStats() {
    }

    public NaturePokeathlonStats(long NatureId) {
        this.NatureId = NatureId;
    }

    public NaturePokeathlonStats(long NatureId, long PokeathlonStatId, long MaxChange) {
        this.NatureId = NatureId;
        this.PokeathlonStatId = PokeathlonStatId;
        this.MaxChange = MaxChange;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getNaturePokeathlonStatsDao() : null;
    }

    public long getNatureId() {
        return NatureId;
    }

    public void setNatureId(long NatureId) {
        this.NatureId = NatureId;
    }

    public long getPokeathlonStatId() {
        return PokeathlonStatId;
    }

    public void setPokeathlonStatId(long PokeathlonStatId) {
        this.PokeathlonStatId = PokeathlonStatId;
    }

    public long getMaxChange() {
        return MaxChange;
    }

    public void setMaxChange(long MaxChange) {
        this.MaxChange = MaxChange;
    }

    /** To-one relationship, resolved on first access. */
    public Natures getNatures() {
        long __key = this.NatureId;
        if (Natures__resolvedKey == null || !Natures__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            NaturesDao targetDao = daoSession.getNaturesDao();
            Natures NaturesNew = targetDao.load(__key);
            synchronized (this) {
                Natures = NaturesNew;
            	Natures__resolvedKey = __key;
            }
        }
        return Natures;
    }

    public void setNatures(Natures Natures) {
        if (Natures == null) {
            throw new DaoException("To-one property 'NatureId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Natures = Natures;
            NatureId = Natures.getId();
            Natures__resolvedKey = NatureId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public PokeathlonStats getPokeathlonStats() {
        long __key = this.PokeathlonStatId;
        if (PokeathlonStats__resolvedKey == null || !PokeathlonStats__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PokeathlonStatsDao targetDao = daoSession.getPokeathlonStatsDao();
            PokeathlonStats PokeathlonStatsNew = targetDao.load(__key);
            synchronized (this) {
                PokeathlonStats = PokeathlonStatsNew;
            	PokeathlonStats__resolvedKey = __key;
            }
        }
        return PokeathlonStats;
    }

    public void setPokeathlonStats(PokeathlonStats PokeathlonStats) {
        if (PokeathlonStats == null) {
            throw new DaoException("To-one property 'PokeathlonStatId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.PokeathlonStats = PokeathlonStats;
            PokeathlonStatId = PokeathlonStats.getId();
            PokeathlonStats__resolvedKey = PokeathlonStatId;
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
