package mis.university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_NAME = "universirymis";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root1234";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error connecting to database", e);
        }
    }
}
