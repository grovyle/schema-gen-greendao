package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "location_area_encounter_rates".
 */
public class LocationAreaEncounterRates {

    private long LocationAreaId;
    private long EncounterMethodId;
    private long VersionId;
    private Long Rate;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient LocationAreaEncounterRatesDao myDao;

    private LocationAreas LocationAreas;
    private Long LocationAreas__resolvedKey;

    private EncounterMethods EncounterMethods;
    private Long EncounterMethods__resolvedKey;

    private Versions Versions;
    private Long Versions__resolvedKey;


    public LocationAreaEncounterRates() {
    }

    public LocationAreaEncounterRates(long LocationAreaId) {
        this.LocationAreaId = LocationAreaId;
    }

    public LocationAreaEncounterRates(long LocationAreaId, long EncounterMethodId, long VersionId, Long Rate) {
        this.LocationAreaId = LocationAreaId;
        this.EncounterMethodId = EncounterMethodId;
        this.VersionId = VersionId;
        this.Rate = Rate;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLocationAreaEncounterRatesDao() : null;
    }

    public long getLocationAreaId() {
        return LocationAreaId;
    }

    public void setLocationAreaId(long LocationAreaId) {
        this.LocationAreaId = LocationAreaId;
    }

    public long getEncounterMethodId() {
        return EncounterMethodId;
    }

    public void setEncounterMethodId(long EncounterMethodId) {
        this.EncounterMethodId = EncounterMethodId;
    }

    public long getVersionId() {
        return VersionId;
    }

    public void setVersionId(long VersionId) {
        this.VersionId = VersionId;
    }

    public Long getRate() {
        return Rate;
    }

    public void setRate(Long Rate) {
        this.Rate = Rate;
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
    public EncounterMethods getEncounterMethods() {
        long __key = this.EncounterMethodId;
        if (EncounterMethods__resolvedKey == null || !EncounterMethods__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EncounterMethodsDao targetDao = daoSession.getEncounterMethodsDao();
            EncounterMethods EncounterMethodsNew = targetDao.load(__key);
            synchronized (this) {
                EncounterMethods = EncounterMethodsNew;
            	EncounterMethods__resolvedKey = __key;
            }
        }
        return EncounterMethods;
    }

    public void setEncounterMethods(EncounterMethods EncounterMethods) {
        if (EncounterMethods == null) {
            throw new DaoException("To-one property 'EncounterMethodId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.EncounterMethods = EncounterMethods;
            EncounterMethodId = EncounterMethods.getId();
            EncounterMethods__resolvedKey = EncounterMethodId;
        }
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
