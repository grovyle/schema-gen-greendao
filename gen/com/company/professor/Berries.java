package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "berries".
 */
public class Berries {

    private long Id;
    private long ItemId;
    private long FirmnessId;
    private Long NaturalGiftPower;
    private Long NaturalGiftTypeId;
    private long Size;
    private long MaxHarvest;
    private long GrowthTime;
    private long SoilDryness;
    private long Smoothness;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BerriesDao myDao;

    private Items Items;
    private Long Items__resolvedKey;

    private BerryFirmness BerryFirmness;
    private Long BerryFirmness__resolvedKey;

    private Types Types;
    private Long Types__resolvedKey;


    public Berries() {
    }

    public Berries(long Id) {
        this.Id = Id;
    }

    public Berries(long Id, long ItemId, long FirmnessId, Long NaturalGiftPower, Long NaturalGiftTypeId, long Size, long MaxHarvest, long GrowthTime, long SoilDryness, long Smoothness) {
        this.Id = Id;
        this.ItemId = ItemId;
        this.FirmnessId = FirmnessId;
        this.NaturalGiftPower = NaturalGiftPower;
        this.NaturalGiftTypeId = NaturalGiftTypeId;
        this.Size = Size;
        this.MaxHarvest = MaxHarvest;
        this.GrowthTime = GrowthTime;
        this.SoilDryness = SoilDryness;
        this.Smoothness = Smoothness;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBerriesDao() : null;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getItemId() {
        return ItemId;
    }

    public void setItemId(long ItemId) {
        this.ItemId = ItemId;
    }

    public long getFirmnessId() {
        return FirmnessId;
    }

    public void setFirmnessId(long FirmnessId) {
        this.FirmnessId = FirmnessId;
    }

    public Long getNaturalGiftPower() {
        return NaturalGiftPower;
    }

    public void setNaturalGiftPower(Long NaturalGiftPower) {
        this.NaturalGiftPower = NaturalGiftPower;
    }

    public Long getNaturalGiftTypeId() {
        return NaturalGiftTypeId;
    }

    public void setNaturalGiftTypeId(Long NaturalGiftTypeId) {
        this.NaturalGiftTypeId = NaturalGiftTypeId;
    }

    public long getSize() {
        return Size;
    }

    public void setSize(long Size) {
        this.Size = Size;
    }

    public long getMaxHarvest() {
        return MaxHarvest;
    }

    public void setMaxHarvest(long MaxHarvest) {
        this.MaxHarvest = MaxHarvest;
    }

    public long getGrowthTime() {
        return GrowthTime;
    }

    public void setGrowthTime(long GrowthTime) {
        this.GrowthTime = GrowthTime;
    }

    public long getSoilDryness() {
        return SoilDryness;
    }

    public void setSoilDryness(long SoilDryness) {
        this.SoilDryness = SoilDryness;
    }

    public long getSmoothness() {
        return Smoothness;
    }

    public void setSmoothness(long Smoothness) {
        this.Smoothness = Smoothness;
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
    public BerryFirmness getBerryFirmness() {
        long __key = this.FirmnessId;
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
            throw new DaoException("To-one property 'FirmnessId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.BerryFirmness = BerryFirmness;
            FirmnessId = BerryFirmness.getId();
            BerryFirmness__resolvedKey = FirmnessId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Types getTypes() {
        Long __key = this.NaturalGiftTypeId;
        if (Types__resolvedKey == null || !Types__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypesDao targetDao = daoSession.getTypesDao();
            Types TypesNew = targetDao.load(__key);
            synchronized (this) {
                Types = TypesNew;
            	Types__resolvedKey = __key;
            }
        }
        return Types;
    }

    public void setTypes(Types Types) {
        synchronized (this) {
            this.Types = Types;
            NaturalGiftTypeId = Types == null ? null : Types.getId();
            Types__resolvedKey = NaturalGiftTypeId;
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
