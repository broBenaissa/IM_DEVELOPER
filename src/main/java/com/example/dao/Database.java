package com.example.dao;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost/db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "salma-4u";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

