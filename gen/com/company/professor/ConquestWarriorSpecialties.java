package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "conquest_warrior_specialties".
 */
public class ConquestWarriorSpecialties {

    private long WarriorId;
    private long TypeId;
    private long Slot;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ConquestWarriorSpecialtiesDao myDao;

    private ConquestWarriors ConquestWarriors;
    private Long ConquestWarriors__resolvedKey;

    private Types Types;
    private Long Types__resolvedKey;


    public ConquestWarriorSpecialties() {
    }

    public ConquestWarriorSpecialties(long WarriorId) {
        this.WarriorId = WarriorId;
    }

    public ConquestWarriorSpecialties(long WarriorId, long TypeId, long Slot) {
        this.WarriorId = WarriorId;
        this.TypeId = TypeId;
        this.Slot = Slot;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getConquestWarriorSpecialtiesDao() : null;
    }

    public long getWarriorId() {
        return WarriorId;
    }

    public void setWarriorId(long WarriorId) {
        this.WarriorId = WarriorId;
    }

    public long getTypeId() {
        return TypeId;
    }

    public void setTypeId(long TypeId) {
        this.TypeId = TypeId;
    }

    public long getSlot() {
        return Slot;
    }

    public void setSlot(long Slot) {
        this.Slot = Slot;
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

    /** To-one relationship, resolved on first access. */
    public Types getTypes() {
        long __key = this.TypeId;
        if (Types__resolvedKey == null || !Types__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypesDao targetDao = daoSession.getTypesDao();
            Types TypesNew = targetDao.load(__key);
            synchronized (this) {
                Types = TypesNew;
            	Types__resolvedKey = __key;
            }
        }
        return Types;
    }

    public void setTypes(Types Types) {
        if (Types == null) {
            throw new DaoException("To-one property 'TypeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Types = Types;
            TypeId = Types.getId();
            Types__resolvedKey = TypeId;
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
