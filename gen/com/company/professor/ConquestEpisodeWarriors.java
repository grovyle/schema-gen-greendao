package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "conquest_episode_warriors".
 */
public class ConquestEpisodeWarriors {

    private long EpisodeId;
    private long WarriorId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ConquestEpisodeWarriorsDao myDao;

    private ConquestEpisodes ConquestEpisodes;
    private Long ConquestEpisodes__resolvedKey;

    private ConquestWarriors ConquestWarriors;
    private Long ConquestWarriors__resolvedKey;


    public ConquestEpisodeWarriors() {
    }

    public ConquestEpisodeWarriors(long EpisodeId) {
        this.EpisodeId = EpisodeId;
    }

    public ConquestEpisodeWarriors(long EpisodeId, long WarriorId) {
        this.EpisodeId = EpisodeId;
        this.WarriorId = WarriorId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getConquestEpisodeWarriorsDao() : null;
    }

    public long getEpisodeId() {
        return EpisodeId;
    }

    public void setEpisodeId(long EpisodeId) {
        this.EpisodeId = EpisodeId;
    }

    public long getWarriorId() {
        return WarriorId;
    }

    public void setWarriorId(long WarriorId) {
        this.WarriorId = WarriorId;
    }

    /** To-one relationship, resolved on first access. */
    public ConquestEpisodes getConquestEpisodes() {
        long __key = this.EpisodeId;
        if (ConquestEpisodes__resolvedKey == null || !ConquestEpisodes__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ConquestEpisodesDao targetDao = daoSession.getConquestEpisodesDao();
            ConquestEpisodes ConquestEpisodesNew = targetDao.load(__key);
            synchronized (this) {
                ConquestEpisodes = ConquestEpisodesNew;
            	ConquestEpisodes__resolvedKey = __key;
            }
        }
        return ConquestEpisodes;
    }

    public void setConquestEpisodes(ConquestEpisodes ConquestEpisodes) {
        if (ConquestEpisodes == null) {
            throw new DaoException("To-one property 'EpisodeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.ConquestEpisodes = ConquestEpisodes;
            EpisodeId = ConquestEpisodes.getId();
            ConquestEpisodes__resolvedKey = EpisodeId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public ConquestWarriors getConquestWarriors() {
        long __key = this.WarriorId;
        if (ConquestWarriors__resolvedKey == null || !ConquestWarriors__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ConquestWarriorsDao targetDao = daoSession.getConquestWarriorsDao();
            ConquestWarriors ConquestWarriorsNew = targetDao.load(__key);
            synchronized (this) {
                ConquestWarriors = ConquestWarriorsNew;
            	ConquestWarriors__resolvedKey = __key;
            }
        }
        return ConquestWarriors;
    }

    public void setConquestWarriors(ConquestWarriors ConquestWarriors) {
        if (ConquestWarriors == null) {
            throw new DaoException("To-one property 'WarriorId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.ConquestWarriors = ConquestWarriors;
            WarriorId = ConquestWarriors.getId();
            ConquestWarriors__resolvedKey = WarriorId;
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