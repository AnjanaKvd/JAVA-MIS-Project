package university.misv2.universitymisv2.lecturer;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Counts {
    public static String getCourseCount() throws SQLException {
        String query = "SELECT COUNT(*) AS courseCount FROM courses";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int courseCount = resultSet.getInt("courseCount");
                return String.valueOf(courseCount);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(0);
    }
    public static String getNotificationCount() throws SQLException {
        String query = "SELECT COUNT(*) AS notificationCount FROM Notification";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int notificationCount = resultSet.getInt("notificationCount");
                return String.valueOf(notificationCount);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(0);
    }

    public static String getMaterialCount() throws SQLException {
        String query = "SELECT COUNT(*) AS materialCount FROM coursematerials";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int materialCount = resultSet.getInt("materialCount");
                return String.valueOf(materialCount);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(0);
    }

}
