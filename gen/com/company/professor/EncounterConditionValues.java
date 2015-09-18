package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "encounter_condition_values".
 */
public class EncounterConditionValues {

    private long Id;
    private long EncounterConditionId;
    /** Not-null value. */
    private String Identifier;
    private boolean IsDefault;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient EncounterConditionValuesDao myDao;

    private EncounterConditions EncounterConditions;
    private Long EncounterConditions__resolvedKey;


    public EncounterConditionValues() {
    }

    public EncounterConditionValues(long Id) {
        this.Id = Id;
    }

    public EncounterConditionValues(long Id, long EncounterConditionId, String Identifier, boolean IsDefault) {
        this.Id = Id;
        this.EncounterConditionId = EncounterConditionId;
        this.Identifier = Identifier;
        this.IsDefault = IsDefault;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEncounterConditionValuesDao() : null;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getEncounterConditionId() {
        return EncounterConditionId;
    }

    public void setEncounterConditionId(long EncounterConditionId) {
        this.EncounterConditionId = EncounterConditionId;
    }

    /** Not-null value. */
    public String getIdentifier() {
        return Identifier;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    public boolean getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(boolean IsDefault) {
        this.IsDefault = IsDefault;
    }

    /** To-one relationship, resolved on first access. */
    public EncounterConditions getEncounterConditions() {
        long __key = this.EncounterConditionId;
        if (EncounterConditions__resolvedKey == null || !EncounterConditions__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EncounterConditionsDao targetDao = daoSession.getEncounterConditionsDao();
            EncounterConditions EncounterConditionsNew = targetDao.load(__key);
            synchronized (this) {
                EncounterConditions = EncounterConditionsNew;
            	EncounterConditions__resolvedKey = __key;
            }
        }
        return EncounterConditions;
    }

    public void setEncounterConditions(EncounterConditions EncounterConditions) {
        if (EncounterConditions == null) {
            throw new DaoException("To-one property 'EncounterConditionId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.EncounterConditions = EncounterConditions;
            EncounterConditionId = EncounterConditions.getId();
            EncounterConditions__resolvedKey = EncounterConditionId;
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