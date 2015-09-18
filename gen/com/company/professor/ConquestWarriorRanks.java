package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "conquest_warrior_ranks".
 */
public class ConquestWarriorRanks {

    private long Id;
    private long WarriorId;
    private long Rank;
    private long SkillId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ConquestWarriorRanksDao myDao;

    private ConquestWarriors ConquestWarriors;
    private Long ConquestWarriors__resolvedKey;

    private ConquestWarriorSkills ConquestWarriorSkills;
    private Long ConquestWarriorSkills__resolvedKey;


    public ConquestWarriorRanks() {
    }

    public ConquestWarriorRanks(long Id) {
        this.Id = Id;
    }

    public ConquestWarriorRanks(long Id, long WarriorId, long Rank, long SkillId) {
        this.Id = Id;
        this.WarriorId = WarriorId;
        this.Rank = Rank;
        this.SkillId = SkillId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getConquestWarriorRanksDao() : null;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getWarriorId() {
        return WarriorId;
    }

    public void setWarriorId(long WarriorId) {
        this.WarriorId = WarriorId;
    }

    public long getRank() {
        return Rank;
    }

    public void setRank(long Rank) {
        this.Rank = Rank;
    }

    public long getSkillId() {
        return SkillId;
    }

    public void setSkillId(long SkillId) {
        this.SkillId = SkillId;
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
    public ConquestWarriorSkills getConquestWarriorSkills() {
        long __key = this.SkillId;
        if (ConquestWarriorSkills__resolvedKey == null || !ConquestWarriorSkills__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ConquestWarriorSkillsDao targetDao = daoSession.getConquestWarriorSkillsDao();
            ConquestWarriorSkills ConquestWarriorSkillsNew = targetDao.load(__key);
            synchronized (this) {
                ConquestWarriorSkills = ConquestWarriorSkillsNew;
            	ConquestWarriorSkills__resolvedKey = __key;
            }
        }
        return ConquestWarriorSkills;
    }

    public void setConquestWarriorSkills(ConquestWarriorSkills ConquestWarriorSkills) {
        if (ConquestWarriorSkills == null) {
            throw new DaoException("To-one property 'SkillId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.ConquestWarriorSkills = ConquestWarriorSkills;
            SkillId = ConquestWarriorSkills.getId();
            ConquestWarriorSkills__resolvedKey = SkillId;
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