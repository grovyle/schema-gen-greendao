package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "type_game_indices".
 */
public class TypeGameIndices {

    private long TypeId;
    private long GenerationId;
    private long GameIndex;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient TypeGameIndicesDao myDao;

    private Types Types;
    private Long Types__resolvedKey;

    private Generations Generations;
    private Long Generations__resolvedKey;


    public TypeGameIndices() {
    }

    public TypeGameIndices(long TypeId) {
        this.TypeId = TypeId;
    }

    public TypeGameIndices(long TypeId, long GenerationId, long GameIndex) {
        this.TypeId = TypeId;
        this.GenerationId = GenerationId;
        this.GameIndex = GameIndex;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTypeGameIndicesDao() : null;
    }

    public long getTypeId() {
        return TypeId;
    }

    public void setTypeId(long TypeId) {
        this.TypeId = TypeId;
    }

    public long getGenerationId() {
        return GenerationId;
    }

    public void setGenerationId(long GenerationId) {
        this.GenerationId = GenerationId;
    }

    public long getGameIndex() {
        return GameIndex;
    }

    public void setGameIndex(long GameIndex) {
        this.GameIndex = GameIndex;
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

    /** To-one relationship, resolved on first access. */
    public Generations getGenerations() {
        long __key = this.GenerationId;
        if (Generations__resolvedKey == null || !Generations__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GenerationsDao targetDao = daoSession.getGenerationsDao();
            Generations GenerationsNew = targetDao.load(__key);
            synchronized (this) {
                Generations = GenerationsNew;
            	Generations__resolvedKey = __key;
            }
        }
        return Generations;
    }

    public void setGenerations(Generations Generations) {
        if (Generations == null) {
            throw new DaoException("To-one property 'GenerationId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Generations = Generations;
            GenerationId = Generations.getId();
            Generations__resolvedKey = GenerationId;
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
