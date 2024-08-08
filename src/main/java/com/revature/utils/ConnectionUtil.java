package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("problem occurred locating driver");
        }

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";

        Connection conn = DriverManager.getConnection(url, username, password);

        // Optional: Explicitly set the schema to 'public'
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("SET search_path TO public;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
