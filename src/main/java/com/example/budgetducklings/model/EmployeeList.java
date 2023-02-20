package com.example.budgetducklings.model;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList {


    private List<Employee> ducklingList = new ArrayList<>();

    public EmployeeList() {
        ducklingList.add(new Employee("scrooge", "foo123"));
        ducklingList.add(new Employee("huey", "bar123"));
        ducklingList.add(new Employee("dewey", "foobar"));
        ducklingList.add(new Employee("louie", "barfoo"));
    }

    public List<Employee> getDucklingList() {
        return ducklingList;
    }
    public static boolean validate(Employee employee) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/duckling?useSSL=false", "root", "");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM login WHERE username = ? AND password = ? ")) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
