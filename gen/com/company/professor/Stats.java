package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "stats".
 */
public class Stats {

    private long Id;
    private Long DamageClassId;
    /** Not-null value. */
    private String Identifier;
    private boolean IsBattleOnly;
    private Long GameIndex;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient StatsDao myDao;

    private MoveDamageClasses MoveDamageClasses;
    private Long MoveDamageClasses__resolvedKey;


    public Stats() {
    }

    public Stats(long Id) {
        this.Id = Id;
    }

    public Stats(long Id, Long DamageClassId, String Identifier, boolean IsBattleOnly, Long GameIndex) {
        this.Id = Id;
        this.DamageClassId = DamageClassId;
        this.Identifier = Identifier;
        this.IsBattleOnly = IsBattleOnly;
        this.GameIndex = GameIndex;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStatsDao() : null;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Long getDamageClassId() {
        return DamageClassId;
    }

    public void setDamageClassId(Long DamageClassId) {
        this.DamageClassId = DamageClassId;
    }

    /** Not-null value. */
    public String getIdentifier() {
        return Identifier;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    public boolean getIsBattleOnly() {
        return IsBattleOnly;
    }

    public void setIsBattleOnly(boolean IsBattleOnly) {
        this.IsBattleOnly = IsBattleOnly;
    }

    public Long getGameIndex() {
        return GameIndex;
    }

    public void setGameIndex(Long GameIndex) {
        this.GameIndex = GameIndex;
    }

    /** To-one relationship, resolved on first access. */
    public MoveDamageClasses getMoveDamageClasses() {
        Long __key = this.DamageClassId;
        if (MoveDamageClasses__resolvedKey == null || !MoveDamageClasses__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MoveDamageClassesDao targetDao = daoSession.getMoveDamageClassesDao();
            MoveDamageClasses MoveDamageClassesNew = targetDao.load(__key);
            synchronized (this) {
                MoveDamageClasses = MoveDamageClassesNew;
            	MoveDamageClasses__resolvedKey = __key;
            }
        }
        return MoveDamageClasses;
    }

    public void setMoveDamageClasses(MoveDamageClasses MoveDamageClasses) {
        synchronized (this) {
            this.MoveDamageClasses = MoveDamageClasses;
            DamageClassId = MoveDamageClasses == null ? null : MoveDamageClasses.getId();
            MoveDamageClasses__resolvedKey = DamageClassId;
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
