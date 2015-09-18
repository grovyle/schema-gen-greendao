package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "encounters".
 */
public class Encounters {

    private long Id;
    private long VersionId;
    private long LocationAreaId;
    private long EncounterSlotId;
    private long PokemonId;
    private long MinLevel;
    private long MaxLevel;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient EncountersDao myDao;

    private Versions Versions;
    private Long Versions__resolvedKey;

    private LocationAreas LocationAreas;
    private Long LocationAreas__resolvedKey;

    private EncounterSlots EncounterSlots;
    private Long EncounterSlots__resolvedKey;

    private Pokemon Pokemon;
    private Long Pokemon__resolvedKey;


    public Encounters() {
    }

    public Encounters(long Id) {
        this.Id = Id;
    }

    public Encounters(long Id, long VersionId, long LocationAreaId, long EncounterSlotId, long PokemonId, long MinLevel, long MaxLevel) {
        this.Id = Id;
        this.VersionId = VersionId;
        this.LocationAreaId = LocationAreaId;
        this.EncounterSlotId = EncounterSlotId;
        this.PokemonId = PokemonId;
        this.MinLevel = MinLevel;
        this.MaxLevel = MaxLevel;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEncountersDao() : null;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getVersionId() {
        return VersionId;
    }

    public void setVersionId(long VersionId) {
        this.VersionId = VersionId;
    }

    public long getLocationAreaId() {
        return LocationAreaId;
    }

    public void setLocationAreaId(long LocationAreaId) {
        this.LocationAreaId = LocationAreaId;
    }

    public long getEncounterSlotId() {
        return EncounterSlotId;
    }

    public void setEncounterSlotId(long EncounterSlotId) {
        this.EncounterSlotId = EncounterSlotId;
    }

    public long getPokemonId() {
        return PokemonId;
    }

    public void setPokemonId(long PokemonId) {
        this.PokemonId = PokemonId;
    }

    public long getMinLevel() {
        return MinLevel;
    }

    public void setMinLevel(long MinLevel) {
        this.MinLevel = MinLevel;
    }

    public long getMaxLevel() {
        return MaxLevel;
    }

    public void setMaxLevel(long MaxLevel) {
        this.MaxLevel = MaxLevel;
    }

    /** To-one relationship, resolved on first access. */
    public Versions getVersions() {
        long __key = this.VersionId;
        if (Versions__resolvedKey == null || !Versions__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VersionsDao targetDao = daoSession.getVersionsDao();
            Versions VersionsNew = targetDao.load(__key);
            synchronized (this) {
                Versions = VersionsNew;
            	Versions__resolvedKey = __key;
            }
        }
        return Versions;
    }

    public void setVersions(Versions Versions) {
        if (Versions == null) {
            throw new DaoException("To-one property 'VersionId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Versions = Versions;
            VersionId = Versions.getId();
            Versions__resolvedKey = VersionId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public LocationAreas getLocationAreas() {
        long __key = this.LocationAreaId;
        if (LocationAreas__resolvedKey == null || !LocationAreas__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LocationAreasDao targetDao = daoSession.getLocationAreasDao();
            LocationAreas LocationAreasNew = targetDao.load(__key);
            synchronized (this) {
                LocationAreas = LocationAreasNew;
            	LocationAreas__resolvedKey = __key;
            }
        }
        return LocationAreas;
    }

    public void setLocationAreas(LocationAreas LocationAreas) {
        if (LocationAreas == null) {
            throw new DaoException("To-one property 'LocationAreaId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.LocationAreas = LocationAreas;
            LocationAreaId = LocationAreas.getId();
            LocationAreas__resolvedKey = LocationAreaId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public EncounterSlots getEncounterSlots() {
        long __key = this.EncounterSlotId;
        if (EncounterSlots__resolvedKey == null || !EncounterSlots__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EncounterSlotsDao targetDao = daoSession.getEncounterSlotsDao();
            EncounterSlots EncounterSlotsNew = targetDao.load(__key);
            synchronized (this) {
                EncounterSlots = EncounterSlotsNew;
            	EncounterSlots__resolvedKey = __key;
            }
        }
        return EncounterSlots;
    }

    public void setEncounterSlots(EncounterSlots EncounterSlots) {
        if (EncounterSlots == null) {
            throw new DaoException("To-one property 'EncounterSlotId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.EncounterSlots = EncounterSlots;
            EncounterSlotId = EncounterSlots.getId();
            EncounterSlots__resolvedKey = EncounterSlotId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Pokemon getPokemon() {
        long __key = this.PokemonId;
        if (Pokemon__resolvedKey == null || !Pokemon__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PokemonDao targetDao = daoSession.getPokemonDao();
            Pokemon PokemonNew = targetDao.load(__key);
            synchronized (this) {
                Pokemon = PokemonNew;
            	Pokemon__resolvedKey = __key;
            }
        }
        return Pokemon;
    }

    public void setPokemon(Pokemon Pokemon) {
        if (Pokemon == null) {
            throw new DaoException("To-one property 'PokemonId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.Pokemon = Pokemon;
            PokemonId = Pokemon.getId();
            Pokemon__resolvedKey = PokemonId;
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