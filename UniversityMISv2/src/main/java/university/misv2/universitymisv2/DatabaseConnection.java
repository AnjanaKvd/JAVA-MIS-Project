package university.misv2.universitymisv2;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_NAME = "newteclms";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "admin1234";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            showErrorAlert(e.getMessage());
        }

        return null;
    }
    private static void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error connecting to database");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
