package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "pokedex_version_groups".
 */
public class PokedexVersionGroups {

    private long PokedexId;
    private long VersionGroupId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient PokedexVersionGroupsDao myDao;

    private Pokedexes Pokedexes;
    private Long Pokedexes__resolvedKey;

    private VersionGroups VersionGroups;
    private Long VersionGroups__resolvedKey;


    public PokedexVersionGroups() {
    }

    public PokedexVersionGroups(long PokedexId) {
        this.PokedexId = PokedexId;
    }

    public PokedexVersionGroups(long PokedexId, long VersionGroupId) {
        this.PokedexId = PokedexId;
        this.VersionGroupId = VersionGroupId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPokedexVersionGroupsDao() : null;
    }

    public long getPokedexId() {
        return PokedexId;
    }

    public void setPokedexId(long PokedexId) {
        this.PokedexId = PokedexId;
    }

    public long getVersionGroupId() {
        return VersionGroupId;
    }

    public void setVersionGroupId(long VersionGroupId) {
        this.VersionGroupId = VersionGroupId;
    }

    /** To-one relationship, resolved on first access. */
    public Pokedexes getPokedexes() {
        long __key = this.PokedexId;
        if (Pokedexes__resolvedKey == null || !Pokedexes__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PokedexesDao targetDao = daoSession.getPokedexesDao();
            Pokedexes PokedexesNew = targetDao.load(__key);
            synchronized (this) {
                Pokedexes = PokedexesNew;
            	Pokedexes__resolvedKey = __key;
            }
        }
        return Pokedexes;
    }

    public void setPokedexes(Pokedexes Pokedexes) {
        if (Pokedexes == null) {
            throw new DaoException("To-one property 'PokedexId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Pokedexes = Pokedexes;
            PokedexId = Pokedexes.getId();
            Pokedexes__resolvedKey = PokedexId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public VersionGroups getVersionGroups() {
        long __key = this.VersionGroupId;
        if (VersionGroups__resolvedKey == null || !VersionGroups__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VersionGroupsDao targetDao = daoSession.getVersionGroupsDao();
            VersionGroups VersionGroupsNew = targetDao.load(__key);
            synchronized (this) {
                VersionGroups = VersionGroupsNew;
            	VersionGroups__resolvedKey = __key;
            }
        }
        return VersionGroups;
    }

    public void setVersionGroups(VersionGroups VersionGroups) {
        if (VersionGroups == null) {
            throw new DaoException("To-one property 'VersionGroupId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.VersionGroups = VersionGroups;
            VersionGroupId = VersionGroups.getId();
            VersionGroups__resolvedKey = VersionGroupId;
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
