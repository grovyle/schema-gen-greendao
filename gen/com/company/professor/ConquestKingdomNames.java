package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "conquest_kingdom_names".
 */
public class ConquestKingdomNames {

    private long KingdomId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ConquestKingdomNamesDao myDao;

    private ConquestKingdoms ConquestKingdoms;
    private Long ConquestKingdoms__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public ConquestKingdomNames() {
    }

    public ConquestKingdomNames(long KingdomId) {
        this.KingdomId = KingdomId;
    }

    public ConquestKingdomNames(long KingdomId, long LocalLanguageId, String Name) {
        this.KingdomId = KingdomId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getConquestKingdomNamesDao() : null;
    }

    public long getKingdomId() {
        return KingdomId;
    }

    public void setKingdomId(long KingdomId) {
        this.KingdomId = KingdomId;
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
    public ConquestKingdoms getConquestKingdoms() {
        long __key = this.KingdomId;
        if (ConquestKingdoms__resolvedKey == null || !ConquestKingdoms__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ConquestKingdomsDao targetDao = daoSession.getConquestKingdomsDao();
            ConquestKingdoms ConquestKingdomsNew = targetDao.load(__key);
            synchronized (this) {
                ConquestKingdoms = ConquestKingdomsNew;
            	ConquestKingdoms__resolvedKey = __key;
            }
        }
        return ConquestKingdoms;
    }

    public void setConquestKingdoms(ConquestKingdoms ConquestKingdoms) {
        if (ConquestKingdoms == null) {
            throw new DaoException("To-one property 'KingdomId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.ConquestKingdoms = ConquestKingdoms;
            KingdomId = ConquestKingdoms.getId();
            ConquestKingdoms__resolvedKey = KingdomId;
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
