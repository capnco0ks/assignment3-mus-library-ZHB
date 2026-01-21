package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/music_library_db";
    private static final String USER = "music_user";
    private static final String PASSWORD = "pass123";

    private DataBaseConnection(){

    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);

        }
        catch (SQLException e) {
            throw new RuntimeException("Failed to connect to DB", e);
        }
    }
}
