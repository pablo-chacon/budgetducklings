package com.example.budgetducklings.model;

import java.io.Serializable;

public class Employee implements Serializable {


    private static final long serialVersionUID = 1;
    private String username;
    private String password;

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Welcome back " + username;
    }

}


