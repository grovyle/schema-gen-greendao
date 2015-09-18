package com.company.professor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "growth_rates".
 */
public class GrowthRates {

    private long Id;
    /** Not-null value. */
    private String Identifier;
    /** Not-null value. */
    private String Formula;

    public GrowthRates() {
    }

    public GrowthRates(long Id) {
        this.Id = Id;
    }

    public GrowthRates(long Id, String Identifier, String Formula) {
        this.Id = Id;
        this.Identifier = Identifier;
        this.Formula = Formula;
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

    /** Not-null value. */
    public String getFormula() {
        return Formula;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setFormula(String Formula) {
        this.Formula = Formula;
    }

}
