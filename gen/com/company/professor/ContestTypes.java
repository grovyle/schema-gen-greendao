package com.company.professor;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "contest_types".
 */
public class ContestTypes {

    private long Id;
    /** Not-null value. */
    private String Identifier;

    public ContestTypes() {
    }

    public ContestTypes(long Id) {
        this.Id = Id;
    }

    public ContestTypes(long Id, String Identifier) {
        this.Id = Id;
        this.Identifier = Identifier;
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

}
