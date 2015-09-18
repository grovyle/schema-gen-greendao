package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "location_area_prose".
 */
public class LocationAreaProse {

    private long LocationAreaId;
    private long LocalLanguageId;
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient LocationAreaProseDao myDao;

    private LocationAreas LocationAreas;
    private Long LocationAreas__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public LocationAreaProse() {
    }

    public LocationAreaProse(long LocationAreaId) {
        this.LocationAreaId = LocationAreaId;
    }

    public LocationAreaProse(long LocationAreaId, long LocalLanguageId, String Name) {
        this.LocationAreaId = LocationAreaId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLocationAreaProseDao() : null;
    }

    public long getLocationAreaId() {
        return LocationAreaId;
    }

    public void setLocationAreaId(long LocationAreaId) {
        this.LocationAreaId = LocationAreaId;
    }

    public long getLocalLanguageId() {
        return LocalLanguageId;
    }

    public void setLocalLanguageId(long LocalLanguageId) {
        this.LocalLanguageId = LocalLanguageId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    /** To-one relationship, resolved on first access. */
    public LocationAreas getLocationAreas() {
        long __key = this.LocationAreaId;
        if (LocationAreas__resolvedKey == null || !LocationAreas__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LocationAreasDao targetDao = daoSession.getLocationAreasDao();
            LocationAreas LocationAreasNew = targetDao.load(__key);
            synchronized (this) {
                LocationAreas = LocationAreasNew;
            	LocationAreas__resolvedKey = __key;
            }
        }
        return LocationAreas;
    }

    public void setLocationAreas(LocationAreas LocationAreas) {
        if (LocationAreas == null) {
            throw new DaoException("To-one property 'LocationAreaId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.LocationAreas = LocationAreas;
            LocationAreaId = LocationAreas.getId();
            LocationAreas__resolvedKey = LocationAreaId;
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