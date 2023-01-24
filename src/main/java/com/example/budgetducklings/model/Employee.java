package com.example.budgetducklings.model;

public class Employee {

    private int employeeId;
    private String name;
    private String password;


    public Employee() {
    }

    public Employee(int employeeId, String name, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
        return "Employee: " + "\nName: " + name + "\nID: " + employeeId;
    }
}
