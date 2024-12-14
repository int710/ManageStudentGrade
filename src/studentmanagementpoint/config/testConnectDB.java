package studentmanagementpoint.config;

import java.sql.Connection;
import java.sql.SQLException;
import studentmanagementpoint.config.MySQLConnection;

public class testConnectDB {
    public static void main(String[] args) {
        try {
            Connection connection = MySQLConnection.getConnection();
            if (connection != null) {
                System.out.println("Connected to MySQL database successfully!");
            } else {
                System.out.println("Failed to connect to MySQL database.");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}