package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "generation_names".
 */
public class GenerationNames {

    private long GenerationId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient GenerationNamesDao myDao;

    private Generations Generations;
    private Long Generations__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public GenerationNames() {
    }

    public GenerationNames(long GenerationId) {
        this.GenerationId = GenerationId;
    }

    public GenerationNames(long GenerationId, long LocalLanguageId, String Name) {
        this.GenerationId = GenerationId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGenerationNamesDao() : null;
    }

    public long getGenerationId() {
        return GenerationId;
    }

    public void setGenerationId(long GenerationId) {
        this.GenerationId = GenerationId;
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
