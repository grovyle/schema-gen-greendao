package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "move_battle_style_prose".
 */
public class MoveBattleStyleProse {

    private long MoveBattleStyleId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MoveBattleStyleProseDao myDao;

    private MoveBattleStyles MoveBattleStyles;
    private Long MoveBattleStyles__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public MoveBattleStyleProse() {
    }

    public MoveBattleStyleProse(long MoveBattleStyleId) {
        this.MoveBattleStyleId = MoveBattleStyleId;
    }

    public MoveBattleStyleProse(long MoveBattleStyleId, long LocalLanguageId, String Name) {
        this.MoveBattleStyleId = MoveBattleStyleId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMoveBattleStyleProseDao() : null;
    }

    public long getMoveBattleStyleId() {
        return MoveBattleStyleId;
    }

    public void setMoveBattleStyleId(long MoveBattleStyleId) {
        this.MoveBattleStyleId = MoveBattleStyleId;
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
    public MoveBattleStyles getMoveBattleStyles() {
        long __key = this.MoveBattleStyleId;
        if (MoveBattleStyles__resolvedKey == null || !MoveBattleStyles__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MoveBattleStylesDao targetDao = daoSession.getMoveBattleStylesDao();
            MoveBattleStyles MoveBattleStylesNew = targetDao.load(__key);
            synchronized (this) {
                MoveBattleStyles = MoveBattleStylesNew;
            	MoveBattleStyles__resolvedKey = __key;
            }
        }
        return MoveBattleStyles;
    }

    public void setMoveBattleStyles(MoveBattleStyles MoveBattleStyles) {
        if (MoveBattleStyles == null) {
            throw new DaoException("To-one property 'MoveBattleStyleId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.MoveBattleStyles = MoveBattleStyles;
            MoveBattleStyleId = MoveBattleStyles.getId();
            MoveBattleStyles__resolvedKey = MoveBattleStyleId;
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