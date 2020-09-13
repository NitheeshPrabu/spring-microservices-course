package com.example.rest.webservices.restfulwebservices.versioning;

public class Name {
    private String firstName;
    private String lastName;

    public Name() {
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String inFirstName) {
        this.firstName = inFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String inLastName) {
        this.lastName = inLastName;
    }
}
