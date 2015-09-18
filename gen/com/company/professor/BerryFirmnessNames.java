package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "berry_firmness_names".
 */
public class BerryFirmnessNames {

    private long BerryFirmnessId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BerryFirmnessNamesDao myDao;

    private BerryFirmness BerryFirmness;
    private Long BerryFirmness__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public BerryFirmnessNames() {
    }

    public BerryFirmnessNames(long BerryFirmnessId) {
        this.BerryFirmnessId = BerryFirmnessId;
    }

    public BerryFirmnessNames(long BerryFirmnessId, long LocalLanguageId, String Name) {
        this.BerryFirmnessId = BerryFirmnessId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBerryFirmnessNamesDao() : null;
    }

    public long getBerryFirmnessId() {
        return BerryFirmnessId;
    }

    public void setBerryFirmnessId(long BerryFirmnessId) {
        this.BerryFirmnessId = BerryFirmnessId;
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
    public BerryFirmness getBerryFirmness() {
        long __key = this.BerryFirmnessId;
        if (BerryFirmness__resolvedKey == null || !BerryFirmness__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BerryFirmnessDao targetDao = daoSession.getBerryFirmnessDao();
            BerryFirmness BerryFirmnessNew = targetDao.load(__key);
            synchronized (this) {
                BerryFirmness = BerryFirmnessNew;
            	BerryFirmness__resolvedKey = __key;
            }
        }
        return BerryFirmness;
    }

    public void setBerryFirmness(BerryFirmness BerryFirmness) {
        if (BerryFirmness == null) {
            throw new DaoException("To-one property 'BerryFirmnessId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.BerryFirmness = BerryFirmness;
            BerryFirmnessId = BerryFirmness.getId();
            BerryFirmness__resolvedKey = BerryFirmnessId;
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
