package com.company.professor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "contest_effects".
 */
public class ContestEffects {

    private long Id;
    private int Appeal;
    private int Jam;

    public ContestEffects() {
    }

    public ContestEffects(long Id) {
        this.Id = Id;
    }

    public ContestEffects(long Id, int Appeal, int Jam) {
        this.Id = Id;
        this.Appeal = Appeal;
        this.Jam = Jam;
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

    public int getJam() {
        return Jam;
    }

    public void setJam(int Jam) {
        this.Jam = Jam;
    }

}