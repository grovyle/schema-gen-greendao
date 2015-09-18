package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "version_names".
 */
public class VersionNames {

    private long VersionId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient VersionNamesDao myDao;

    private Versions Versions;
    private Long Versions__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public VersionNames() {
    }

    public VersionNames(long VersionId) {
        this.VersionId = VersionId;
    }

    public VersionNames(long VersionId, long LocalLanguageId, String Name) {
        this.VersionId = VersionId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getVersionNamesDao() : null;
    }

    public long getVersionId() {
        return VersionId;
    }

    public void setVersionId(long VersionId) {
        this.VersionId = VersionId;
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
    public Versions getVersions() {
        long __key = this.VersionId;
        if (Versions__resolvedKey == null || !Versions__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VersionsDao targetDao = daoSession.getVersionsDao();
            Versions VersionsNew = targetDao.load(__key);
            synchronized (this) {
                Versions = VersionsNew;
            	Versions__resolvedKey = __key;
            }
        }
        return Versions;
    }

    public void setVersions(Versions Versions) {
        if (Versions == null) {
            throw new DaoException("To-one property 'VersionId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Versions = Versions;
            VersionId = Versions.getId();
            Versions__resolvedKey = VersionId;
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
