package com.example.budgetducklings.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDb {

    private static MySqlDb instance;
    private Connection connection;

    private MySqlDb() {
        String url = "jdbc:mysql://localhost:3306/awshopping";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static MySqlDb getInstance() {
        if(instance == null) {
            instance = new MySqlDb();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

