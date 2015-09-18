package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "conquest_pokemon_abilities".
 */
public class ConquestPokemonAbilities {

    private long PokemonSpeciesId;
    private long Slot;
    private long AbilityId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ConquestPokemonAbilitiesDao myDao;

    private PokemonSpecies PokemonSpecies;
    private Long PokemonSpecies__resolvedKey;

    private Abilities Abilities;
    private Long Abilities__resolvedKey;


    public ConquestPokemonAbilities() {
    }

    public ConquestPokemonAbilities(long PokemonSpeciesId) {
        this.PokemonSpeciesId = PokemonSpeciesId;
    }

    public ConquestPokemonAbilities(long PokemonSpeciesId, long Slot, long AbilityId) {
        this.PokemonSpeciesId = PokemonSpeciesId;
        this.Slot = Slot;
        this.AbilityId = AbilityId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getConquestPokemonAbilitiesDao() : null;
    }

    public long getPokemonSpeciesId() {
        return PokemonSpeciesId;
    }

    public void setPokemonSpeciesId(long PokemonSpeciesId) {
        this.PokemonSpeciesId = PokemonSpeciesId;
    }

    public long getSlot() {
        return Slot;
    }

    public void setSlot(long Slot) {
        this.Slot = Slot;
    }

    public long getAbilityId() {
        return AbilityId;
    }

    public void setAbilityId(long AbilityId) {
        this.AbilityId = AbilityId;
    }

    /** To-one relationship, resolved on first access. */
    public PokemonSpecies getPokemonSpecies() {
        long __key = this.PokemonSpeciesId;
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
        if (PokemonSpecies == null) {
            throw new DaoException("To-one property 'PokemonSpeciesId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.PokemonSpecies = PokemonSpecies;
            PokemonSpeciesId = PokemonSpecies.getId();
            PokemonSpecies__resolvedKey = PokemonSpeciesId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Abilities getAbilities() {
        long __key = this.AbilityId;
        if (Abilities__resolvedKey == null || !Abilities__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AbilitiesDao targetDao = daoSession.getAbilitiesDao();
            Abilities AbilitiesNew = targetDao.load(__key);
            synchronized (this) {
                Abilities = AbilitiesNew;
            	Abilities__resolvedKey = __key;
            }
        }
        return Abilities;
    }

    public void setAbilities(Abilities Abilities) {
        if (Abilities == null) {
            throw new DaoException("To-one property 'AbilityId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Abilities = Abilities;
            AbilityId = Abilities.getId();
            Abilities__resolvedKey = AbilityId;
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