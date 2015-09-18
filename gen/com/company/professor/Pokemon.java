package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "pokemon".
 */
public class Pokemon {

    private long Id;
    /** Not-null value. */
    private String Identifier;
    private Long SpeciesId;
    private long Height;
    private long Weight;
    private long BaseExperience;
    private long Order;
    private boolean IsDefault;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient PokemonDao myDao;

    private PokemonSpecies PokemonSpecies;
    private Long PokemonSpecies__resolvedKey;


    public Pokemon() {
    }

    public Pokemon(long Id) {
        this.Id = Id;
    }

    public Pokemon(long Id, String Identifier, Long SpeciesId, long Height, long Weight, long BaseExperience, long Order, boolean IsDefault) {
        this.Id = Id;
        this.Identifier = Identifier;
        this.SpeciesId = SpeciesId;
        this.Height = Height;
        this.Weight = Weight;
        this.BaseExperience = BaseExperience;
        this.Order = Order;
        this.IsDefault = IsDefault;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPokemonDao() : null;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    /** Not-null value. */
    public String getIdentifier() {
        return Identifier;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    public Long getSpeciesId() {
        return SpeciesId;
    }

    public void setSpeciesId(Long SpeciesId) {
        this.SpeciesId = SpeciesId;
    }

    public long getHeight() {
        return Height;
    }

    public void setHeight(long Height) {
        this.Height = Height;
    }

    public long getWeight() {
        return Weight;
    }

    public void setWeight(long Weight) {
        this.Weight = Weight;
    }

    public long getBaseExperience() {
        return BaseExperience;
    }

    public void setBaseExperience(long BaseExperience) {
        this.BaseExperience = BaseExperience;
    }

    public long getOrder() {
        return Order;
    }

    public void setOrder(long Order) {
        this.Order = Order;
    }

    public boolean getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(boolean IsDefault) {
        this.IsDefault = IsDefault;
    }

    /** To-one relationship, resolved on first access. */
    public PokemonSpecies getPokemonSpecies() {
        Long __key = this.SpeciesId;
        if (PokemonSpecies__resolvedKey == null || !PokemonSpecies__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PokemonSpeciesDao targetDao = daoSession.getPokemonSpeciesDao();
            PokemonSpecies PokemonSpeciesNew = targetDao.load(__key);
            synchronized (this) {
                PokemonSpecies = PokemonSpeciesNew;
            	PokemonSpecies__resolvedKey = __key;
            }
        }
        return PokemonSpecies;
    }

    public void setPokemonSpecies(PokemonSpecies PokemonSpecies) {
        synchronized (this) {
            this.PokemonSpecies = PokemonSpecies;
            SpeciesId = PokemonSpecies == null ? null : PokemonSpecies.getId();
            PokemonSpecies__resolvedKey = SpeciesId;
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
