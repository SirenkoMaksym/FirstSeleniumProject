package com.ait.models;

public class UserRegistred {
    private String firstname;
    private String lastName;
    private String email;
    private String password;
    private String confirmPasswor;

    public UserRegistred setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserRegistred setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserRegistred setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserRegistred setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRegistred setConfirmPasswor(String confirmPasswor) {
        this.confirmPasswor = confirmPasswor;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPasswor() {
        return confirmPasswor;
    }
}
