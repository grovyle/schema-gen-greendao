package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "stat_hint_names".
 */
public class StatHintNames {

    private long StatHintId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Message;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient StatHintNamesDao myDao;

    private StatHints StatHints;
    private Long StatHints__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public StatHintNames() {
    }

    public StatHintNames(long StatHintId) {
        this.StatHintId = StatHintId;
    }

    public StatHintNames(long StatHintId, long LocalLanguageId, String Message) {
        this.StatHintId = StatHintId;
        this.LocalLanguageId = LocalLanguageId;
        this.Message = Message;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStatHintNamesDao() : null;
    }

    public long getStatHintId() {
        return StatHintId;
    }

    public void setStatHintId(long StatHintId) {
        this.StatHintId = StatHintId;
    }

    public long getLocalLanguageId() {
        return LocalLanguageId;
    }

    public void setLocalLanguageId(long LocalLanguageId) {
        this.LocalLanguageId = LocalLanguageId;
    }

    /** Not-null value. */
    public String getMessage() {
        return Message;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setMessage(String Message) {
        this.Message = Message;
    }

    /** To-one relationship, resolved on first access. */
    public StatHints getStatHints() {
        long __key = this.StatHintId;
        if (StatHints__resolvedKey == null || !StatHints__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StatHintsDao targetDao = daoSession.getStatHintsDao();
            StatHints StatHintsNew = targetDao.load(__key);
            synchronized (this) {
                StatHints = StatHintsNew;
            	StatHints__resolvedKey = __key;
            }
        }
        return StatHints;
    }

    public void setStatHints(StatHints StatHints) {
        if (StatHints == null) {
            throw new DaoException("To-one property 'StatHintId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.StatHints = StatHints;
            StatHintId = StatHints.getId();
            StatHints__resolvedKey = StatHintId;
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