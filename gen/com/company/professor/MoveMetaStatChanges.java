package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "move_meta_stat_changes".
 */
public class MoveMetaStatChanges {

    private long MoveId;
    private long StatId;
    private long Change;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MoveMetaStatChangesDao myDao;

    private Moves Moves;
    private Long Moves__resolvedKey;

    private Stats Stats;
    private Long Stats__resolvedKey;


    public MoveMetaStatChanges() {
    }

    public MoveMetaStatChanges(long MoveId) {
        this.MoveId = MoveId;
    }

    public MoveMetaStatChanges(long MoveId, long StatId, long Change) {
        this.MoveId = MoveId;
        this.StatId = StatId;
        this.Change = Change;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMoveMetaStatChangesDao() : null;
    }

    public long getMoveId() {
        return MoveId;
    }

    public void setMoveId(long MoveId) {
        this.MoveId = MoveId;
    }

    public long getStatId() {
        return StatId;
    }

    public void setStatId(long StatId) {
        this.StatId = StatId;
    }

    public long getChange() {
        return Change;
    }

    public void setChange(long Change) {
        this.Change = Change;
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
    public Stats getStats() {
        long __key = this.StatId;
        if (Stats__resolvedKey == null || !Stats__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StatsDao targetDao = daoSession.getStatsDao();
            Stats StatsNew = targetDao.load(__key);
            synchronized (this) {
                Stats = StatsNew;
            	Stats__resolvedKey = __key;
            }
        }
        return Stats;
    }

    public void setStats(Stats Stats) {
        if (Stats == null) {
            throw new DaoException("To-one property 'StatId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Stats = Stats;
            StatId = Stats.getId();
            Stats__resolvedKey = StatId;
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
