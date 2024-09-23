package university.misv2.universitymisv2.admin;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotificationManager {

    public static void addNotification(String message) throws SQLException {
        String query = "INSERT INTO notification (message, date_time) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, message);
            statement.setObject(2, LocalDateTime.now());
            statement.executeUpdate();
        }
    }

    public static List<String> getAllNotifications() throws SQLException {
        List<String> notifications = new ArrayList<>();
        String query = "SELECT id, message, date_time FROM notification";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String message = resultSet.getString("message");
                LocalDateTime date = resultSet.getObject("date_time", LocalDateTime.class);
                notifications.add("ID: " + id + ", Message: " + message + ", Date: " + date);
            }
        }
        return notifications;
    }

    public static void deleteNotification(int notificationID) throws SQLException {
        String query = "DELETE FROM notification WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, notificationID);
            statement.executeUpdate();
        }
    }
}