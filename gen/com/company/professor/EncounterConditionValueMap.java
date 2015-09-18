package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "encounter_condition_value_map".
 */
public class EncounterConditionValueMap {

    private long EncounterId;
    private long EncounterConditionValueId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient EncounterConditionValueMapDao myDao;

    private Encounters Encounters;
    private Long Encounters__resolvedKey;

    private EncounterConditionValues EncounterConditionValues;
    private Long EncounterConditionValues__resolvedKey;


    public EncounterConditionValueMap() {
    }

    public EncounterConditionValueMap(long EncounterId) {
        this.EncounterId = EncounterId;
    }

    public EncounterConditionValueMap(long EncounterId, long EncounterConditionValueId) {
        this.EncounterId = EncounterId;
        this.EncounterConditionValueId = EncounterConditionValueId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEncounterConditionValueMapDao() : null;
    }

    public long getEncounterId() {
        return EncounterId;
    }

    public void setEncounterId(long EncounterId) {
        this.EncounterId = EncounterId;
    }

    public long getEncounterConditionValueId() {
        return EncounterConditionValueId;
    }

    public void setEncounterConditionValueId(long EncounterConditionValueId) {
        this.EncounterConditionValueId = EncounterConditionValueId;
    }

    /** To-one relationship, resolved on first access. */
    public Encounters getEncounters() {
        long __key = this.EncounterId;
        if (Encounters__resolvedKey == null || !Encounters__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EncountersDao targetDao = daoSession.getEncountersDao();
            Encounters EncountersNew = targetDao.load(__key);
            synchronized (this) {
                Encounters = EncountersNew;
            	Encounters__resolvedKey = __key;
            }
        }
        return Encounters;
    }

    public void setEncounters(Encounters Encounters) {
        if (Encounters == null) {
            throw new DaoException("To-one property 'EncounterId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Encounters = Encounters;
            EncounterId = Encounters.getId();
            Encounters__resolvedKey = EncounterId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public EncounterConditionValues getEncounterConditionValues() {
        long __key = this.EncounterConditionValueId;
        if (EncounterConditionValues__resolvedKey == null || !EncounterConditionValues__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EncounterConditionValuesDao targetDao = daoSession.getEncounterConditionValuesDao();
            EncounterConditionValues EncounterConditionValuesNew = targetDao.load(__key);
            synchronized (this) {
                EncounterConditionValues = EncounterConditionValuesNew;
            	EncounterConditionValues__resolvedKey = __key;
            }
        }
        return EncounterConditionValues;
    }

    public void setEncounterConditionValues(EncounterConditionValues EncounterConditionValues) {
        if (EncounterConditionValues == null) {
            throw new DaoException("To-one property 'EncounterConditionValueId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.EncounterConditionValues = EncounterConditionValues;
            EncounterConditionValueId = EncounterConditionValues.getId();
            EncounterConditionValues__resolvedKey = EncounterConditionValueId;
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
