package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "move_meta_category_prose".
 */
public class MoveMetaCategoryProse {

    private long MoveMetaCategoryId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Description;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MoveMetaCategoryProseDao myDao;

    private MoveMetaCategories MoveMetaCategories;
    private Long MoveMetaCategories__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public MoveMetaCategoryProse() {
    }

    public MoveMetaCategoryProse(long MoveMetaCategoryId) {
        this.MoveMetaCategoryId = MoveMetaCategoryId;
    }

    public MoveMetaCategoryProse(long MoveMetaCategoryId, long LocalLanguageId, String Description) {
        this.MoveMetaCategoryId = MoveMetaCategoryId;
        this.LocalLanguageId = LocalLanguageId;
        this.Description = Description;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMoveMetaCategoryProseDao() : null;
    }

    public long getMoveMetaCategoryId() {
        return MoveMetaCategoryId;
    }

    public void setMoveMetaCategoryId(long MoveMetaCategoryId) {
        this.MoveMetaCategoryId = MoveMetaCategoryId;
    }

    public long getLocalLanguageId() {
        return LocalLanguageId;
    }

    public void setLocalLanguageId(long LocalLanguageId) {
        this.LocalLanguageId = LocalLanguageId;
    }

    /** Not-null value. */
    public String getDescription() {
        return Description;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /** To-one relationship, resolved on first access. */
    public MoveMetaCategories getMoveMetaCategories() {
        long __key = this.MoveMetaCategoryId;
        if (MoveMetaCategories__resolvedKey == null || !MoveMetaCategories__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MoveMetaCategoriesDao targetDao = daoSession.getMoveMetaCategoriesDao();
            MoveMetaCategories MoveMetaCategoriesNew = targetDao.load(__key);
            synchronized (this) {
                MoveMetaCategories = MoveMetaCategoriesNew;
            	MoveMetaCategories__resolvedKey = __key;
            }
        }
        return MoveMetaCategories;
    }

    public void setMoveMetaCategories(MoveMetaCategories MoveMetaCategories) {
        if (MoveMetaCategories == null) {
            throw new DaoException("To-one property 'MoveMetaCategoryId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.MoveMetaCategories = MoveMetaCategories;
            MoveMetaCategoryId = MoveMetaCategories.getId();
            MoveMetaCategories__resolvedKey = MoveMetaCategoryId;
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