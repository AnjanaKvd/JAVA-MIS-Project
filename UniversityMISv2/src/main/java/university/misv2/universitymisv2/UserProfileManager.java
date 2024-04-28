package university.misv2.universitymisv2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserProfileManager {
    public static String getUserFullName(String username) {
        String fullName = "Unknown";

        try (Connection connectDB = DatabaseConnection.getConnection();
             PreparedStatement statement = connectDB.prepareStatement("SELECT full_name FROM userdetails WHERE username = ?")) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    fullName = resultSet.getString("full_name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fullName = "Error";
        }

        return fullName;
    }

    public static String getUserProfileImagePath(String username) {
        String imagePath = "/university/misv2/universitymisv2/images/profile_images/profile-default.jpeg";
        try (Connection connectDB = DatabaseConnection.getConnection();
             PreparedStatement statement = connectDB.prepareStatement("SELECT profile_image_path FROM userdetails WHERE username = ?")) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String profileImagePath = resultSet.getString("profile_image_path");
                    if (profileImagePath != null && !profileImagePath.isEmpty()) {
                        imagePath = profileImagePath;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            imagePath = "Error";
        }

        return imagePath;
    }
    public static void setUserProfileImagePath(String username, String imagePath) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE userdetails SET profile_image_path = ? WHERE username = ?")) {
            statement.setString(1, imagePath);
            statement.setString(2, username);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Profile image path updated successfully for user: " + username);
            } else {
                System.out.println("Failed to update profile image path for user: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
