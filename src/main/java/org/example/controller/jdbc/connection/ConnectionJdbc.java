package org.example.controller.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/robotparts";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";
    private static Connection connection = null;

    public ConnectionJdbc() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                try {
                    // Load the JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // Establish the connection
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                } catch (ClassNotFoundException e) {
                    System.out.println("JDBC Driver not found: " + e.getMessage());
                } catch (SQLException e) {
                    System.out.println("Error establishing connection: " + e.getMessage());
                }
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
