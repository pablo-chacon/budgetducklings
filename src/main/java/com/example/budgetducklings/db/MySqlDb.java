package com.example.budgetducklings.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDb {

    private static MySqlDb instance;
    private Connection conn;

    private MySqlDb() {
        String url = "jdbc:mysql://localhost:3306/duckling";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
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

    public Connection getConn() {
        return conn;
    }
}

