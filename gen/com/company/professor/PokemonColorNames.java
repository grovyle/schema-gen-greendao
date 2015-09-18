package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "pokemon_color_names".
 */
public class PokemonColorNames {

    private long PokemonColorId;
    private long LocalLanguageId;
    /** Not-null value. */
    private String Name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient PokemonColorNamesDao myDao;

    private PokemonColors PokemonColors;
    private Long PokemonColors__resolvedKey;

    private Languages Languages;
    private Long Languages__resolvedKey;


    public PokemonColorNames() {
    }

    public PokemonColorNames(long PokemonColorId) {
        this.PokemonColorId = PokemonColorId;
    }

    public PokemonColorNames(long PokemonColorId, long LocalLanguageId, String Name) {
        this.PokemonColorId = PokemonColorId;
        this.LocalLanguageId = LocalLanguageId;
        this.Name = Name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPokemonColorNamesDao() : null;
    }

    public long getPokemonColorId() {
        return PokemonColorId;
    }

    public void setPokemonColorId(long PokemonColorId) {
        this.PokemonColorId = PokemonColorId;
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
    public PokemonColors getPokemonColors() {
        long __key = this.PokemonColorId;
        if (PokemonColors__resolvedKey == null || !PokemonColors__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PokemonColorsDao targetDao = daoSession.getPokemonColorsDao();
            PokemonColors PokemonColorsNew = targetDao.load(__key);
            synchronized (this) {
                PokemonColors = PokemonColorsNew;
            	PokemonColors__resolvedKey = __key;
            }
        }
        return PokemonColors;
    }

    public void setPokemonColors(PokemonColors PokemonColors) {
        if (PokemonColors == null) {
            throw new DaoException("To-one property 'PokemonColorId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.PokemonColors = PokemonColors;
            PokemonColorId = PokemonColors.getId();
            PokemonColors__resolvedKey = PokemonColorId;
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
