package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "conquest_episode_names".
 */
public class ConquestEpisodeNames {

    private long EpisodeId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ConquestEpisodeNamesDao myDao;

    private ConquestEpisodes ConquestEpisodes;
    private Long ConquestEpisodes__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public ConquestEpisodeNames() {
    }

    public ConquestEpisodeNames(long EpisodeId) {
        this.EpisodeId = EpisodeId;
    }

    public ConquestEpisodeNames(long EpisodeId, long LocalLanguageId, String Name) {
        this.EpisodeId = EpisodeId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getConquestEpisodeNamesDao() : null;
    }

    public long getEpisodeId() {
        return EpisodeId;
    }

    public void setEpisodeId(long EpisodeId) {
        this.EpisodeId = EpisodeId;
    }

    public long getLocalLanguageId() {
        return LocalLanguageId;
    }

    public void setLocalLanguageId(long LocalLanguageId) {
        this.LocalLanguageId = LocalLanguageId;
    }

    /** Not-null value. */
    public String getName() {
        return Name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String Name) {
        this.Name = Name;
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
    public Languages getLanguages() {
        long __key = this.LocalLanguageId;
        if (Languages__resolvedKey == null || !Languages__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LanguagesDao targetDao = daoSession.getLanguagesDao();
            Languages LanguagesNew = targetDao.load(__key);
            synchronized (this) {
                Languages = LanguagesNew;
            	Languages__resolvedKey = __key;
            }
        }
        return Languages;
    }

    public void setLanguages(Languages Languages) {
        if (Languages == null) {
            throw new DaoException("To-one property 'LocalLanguageId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Languages = Languages;
            LocalLanguageId = Languages.getId();
            Languages__resolvedKey = LocalLanguageId;
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
