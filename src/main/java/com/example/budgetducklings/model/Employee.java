package com.example.budgetducklings.model;

public class Employee {


    private long id;
    private String name;
    private String password;

    public Employee(long id, String name, String password) {
        this.id = this.id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Welcome back " + name;
    }

}
