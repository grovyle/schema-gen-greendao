package com.company.professor;

import com.company.professor.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "contest_combos".
 */
public class ContestCombos {

    private long FirstMoveId;
    private long SecondMoveId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ContestCombosDao myDao;

    private Moves FirstMove;
    private Long FirstMove__resolvedKey;

    private Moves SecondMove;
    private Long SecondMove__resolvedKey;


    public ContestCombos() {
    }

    public ContestCombos(long FirstMoveId) {
        this.FirstMoveId = FirstMoveId;
    }

    public ContestCombos(long FirstMoveId, long SecondMoveId) {
        this.FirstMoveId = FirstMoveId;
        this.SecondMoveId = SecondMoveId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getContestCombosDao() : null;
    }

    public long getFirstMoveId() {
        return FirstMoveId;
    }

    public void setFirstMoveId(long FirstMoveId) {
        this.FirstMoveId = FirstMoveId;
    }

    public long getSecondMoveId() {
        return SecondMoveId;
    }

    public void setSecondMoveId(long SecondMoveId) {
        this.SecondMoveId = SecondMoveId;
    }

    /** To-one relationship, resolved on first access. */
    public Moves getFirstMove() {
        long __key = this.FirstMoveId;
        if (FirstMove__resolvedKey == null || !FirstMove__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MovesDao targetDao = daoSession.getMovesDao();
            Moves FirstMoveNew = targetDao.load(__key);
            synchronized (this) {
                FirstMove = FirstMoveNew;
            	FirstMove__resolvedKey = __key;
            }
        }
        return FirstMove;
    }

    public void setFirstMove(Moves FirstMove) {
        if (FirstMove == null) {
            throw new DaoException("To-one property 'FirstMoveId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.FirstMove = FirstMove;
            FirstMoveId = FirstMove.getId();
            FirstMove__resolvedKey = FirstMoveId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Moves getSecondMove() {
        long __key = this.SecondMoveId;
        if (SecondMove__resolvedKey == null || !SecondMove__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MovesDao targetDao = daoSession.getMovesDao();
            Moves SecondMoveNew = targetDao.load(__key);
            synchronized (this) {
                SecondMove = SecondMoveNew;
            	SecondMove__resolvedKey = __key;
            }
        }
        return SecondMove;
    }

    public void setSecondMove(Moves SecondMove) {
        if (SecondMove == null) {
            throw new DaoException("To-one property 'SecondMoveId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.SecondMove = SecondMove;
            SecondMoveId = SecondMove.getId();
            SecondMove__resolvedKey = SecondMoveId;
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
