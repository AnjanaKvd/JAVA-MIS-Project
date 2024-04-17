package university.misv2.universitymisv2.admin;

import javafx.scene.control.Alert;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserManager {
    public static void addUser(String username, String password, String userType) throws SQLException {
        String query = "INSERT INTO user (username, password, user_type) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, userType);
            statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modifyUser(String oldUsername, String newUsername, String newPassword, String userType) throws SQLException {
        String query = "UPDATE user SET username = ?, password = ?, user_type = ? WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            statement.setString(3, userType);
            statement.setString(4, oldUsername);
            statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteUser(String usernameToDelete) throws SQLException {
        String query = "DELETE FROM user WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usernameToDelete);
            statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
