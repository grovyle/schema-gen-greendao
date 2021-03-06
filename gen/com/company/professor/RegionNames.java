package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "region_names".
 */
public class RegionNames {

    private long RegionId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RegionNamesDao myDao;

    private Regions Regions;
    private Long Regions__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public RegionNames() {
    }

    public RegionNames(long RegionId) {
        this.RegionId = RegionId;
    }

    public RegionNames(long RegionId, long LocalLanguageId, String Name) {
        this.RegionId = RegionId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRegionNamesDao() : null;
    }

    public long getRegionId() {
        return RegionId;
    }

    public void setRegionId(long RegionId) {
        this.RegionId = RegionId;
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
    public Regions getRegions() {
        long __key = this.RegionId;
        if (Regions__resolvedKey == null || !Regions__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RegionsDao targetDao = daoSession.getRegionsDao();
            Regions RegionsNew = targetDao.load(__key);
            synchronized (this) {
                Regions = RegionsNew;
            	Regions__resolvedKey = __key;
            }
        }
        return Regions;
    }

    public void setRegions(Regions Regions) {
        if (Regions == null) {
            throw new DaoException("To-one property 'RegionId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Regions = Regions;
            RegionId = Regions.getId();
            Regions__resolvedKey = RegionId;
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
