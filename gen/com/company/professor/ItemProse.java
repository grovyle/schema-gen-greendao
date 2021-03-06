package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "item_prose".
 */
public class ItemProse {

    private long ItemId;
    private long LocalLanguageId;
    private String ShortEffect;
    private String Effect;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ItemProseDao myDao;

    private Items Items;
    private Long Items__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public ItemProse() {
    }

    public ItemProse(long ItemId) {
        this.ItemId = ItemId;
    }

    public ItemProse(long ItemId, long LocalLanguageId, String ShortEffect, String Effect) {
        this.ItemId = ItemId;
        this.LocalLanguageId = LocalLanguageId;
        this.ShortEffect = ShortEffect;
        this.Effect = Effect;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getItemProseDao() : null;
    }

    public long getItemId() {
        return ItemId;
    }

    public void setItemId(long ItemId) {
        this.ItemId = ItemId;
    }

    public long getLocalLanguageId() {
        return LocalLanguageId;
    }

    public void setLocalLanguageId(long LocalLanguageId) {
        this.LocalLanguageId = LocalLanguageId;
    }

    public String getShortEffect() {
        return ShortEffect;
    }

    public void setShortEffect(String ShortEffect) {
        this.ShortEffect = ShortEffect;
    }

    public String getEffect() {
        return Effect;
    }

    public void setEffect(String Effect) {
        this.Effect = Effect;
    }

    /** To-one relationship, resolved on first access. */
    public Items getItems() {
        long __key = this.ItemId;
        if (Items__resolvedKey == null || !Items__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ItemsDao targetDao = daoSession.getItemsDao();
            Items ItemsNew = targetDao.load(__key);
            synchronized (this) {
                Items = ItemsNew;
            	Items__resolvedKey = __key;
            }
        }
        return Items;
    }

    public void setItems(Items Items) {
        if (Items == null) {
            throw new DaoException("To-one property 'ItemId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Items = Items;
            ItemId = Items.getId();
            Items__resolvedKey = ItemId;
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
