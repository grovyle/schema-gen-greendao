package com.company.professor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "encounter_methods".
 */
public class EncounterMethods {

    private long Id;
    /** Not-null value. */
    private String Identifier;
    private long Order;

    public EncounterMethods() {
    }

    public EncounterMethods(long Id) {
        this.Id = Id;
    }

    public EncounterMethods(long Id, String Identifier, long Order) {
        this.Id = Id;
        this.Identifier = Identifier;
        this.Order = Order;
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

    public long getOrder() {
        return Order;
    }

    public void setOrder(long Order) {
        this.Order = Order;
    }

}
