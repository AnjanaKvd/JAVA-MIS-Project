package university.misv2.universitymisv2;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String absolutePath = Paths.get("").toAbsolutePath().toString();
        String imagePath = "/profile_images/profile-default.jpeg";
        String fullImagePath = absolutePath+imagePath;
        try (Connection connectDB = DatabaseConnection.getConnection();
             PreparedStatement statement = connectDB.prepareStatement("SELECT profile_image_path FROM userdetails WHERE username = ?")) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String profileImagePath = resultSet.getString("profile_image_path");
                    if (profileImagePath != null) {
                        fullImagePath = profileImagePath;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fullImagePath = "Error";
        }

        return fullImagePath;
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
    public static String getUserEmail(String username) {
        try (Connection connectDB = DatabaseConnection.getConnection();
             PreparedStatement statement = connectDB.prepareStatement("SELECT email FROM userdetails WHERE username = ?")) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("email");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String modifyUserDetails(String username, String newUsername, String fullName, String password, String email) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement userStatement = connection.prepareStatement("UPDATE user SET username = ?, password = ? WHERE username = ?")) {
                userStatement.setString(1, newUsername);
                userStatement.setString(2, password);
                userStatement.setString(3, username);
                int userRowsUpdated = userStatement.executeUpdate();
                if (userRowsUpdated <= 0) {
                    connection.rollback(); // Rollback transaction if update fails
                    return "Failed to update user profile data.";
                }
            }
            try (PreparedStatement detailsStatement = connection.prepareStatement("UPDATE userdetails SET username = ?, full_name = ?, email = ? WHERE username = ?")) {
                detailsStatement.setString(1, newUsername);
                detailsStatement.setString(2, fullName);
                detailsStatement.setString(3, email);
                detailsStatement.setString(4, username);
                int detailsRowsUpdated = detailsStatement.executeUpdate();
                if (detailsRowsUpdated <= 0) {
                    connection.rollback();
                    return "Failed to update user details data.";
                }
            }

            connection.commit();
            return "Profile data updated successfully.";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error";
        }
    }

}
