package com.company.professor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "super_contest_effects".
 */
public class SuperContestEffects {

    private long Id;
    private int Appeal;

    public SuperContestEffects() {
    }

    public SuperContestEffects(long Id) {
        this.Id = Id;
    }

    public SuperContestEffects(long Id, int Appeal) {
        this.Id = Id;
        this.Appeal = Appeal;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public int getAppeal() {
        return Appeal;
    }

    public void setAppeal(int Appeal) {
        this.Appeal = Appeal;
    }

}
