package com.example.budgetducklings.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {


    private List<Employee> ducklingList = new ArrayList<>();

    public EmployeeList() {
        ducklingList.add(new Employee(1, "scrooge", "foo123"));
        ducklingList.add(new Employee(2, "huey", "bar123"));
        ducklingList.add(new Employee(3, "dewey", "foobar"));
        ducklingList.add(new Employee(4, "louie", "barfoo"));
    }

    public List<Employee> getDucklingList() {
        return ducklingList;
    }


}
