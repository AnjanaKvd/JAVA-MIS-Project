package university.misv2.universitymisv2.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseManager {
    public static void addCourse(String courseCode, String courseName, String department, int credits, int hours, String lecturer) throws SQLException {
        String query = "INSERT INTO course (course_code, course_name, department, credits, hours, lecturer) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseCode);
            statement.setString(2, courseName);
            statement.setString(3, department);
            statement.setInt(4, credits);
            statement.setInt(5, hours);
            statement.setString(6, lecturer);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modifyCourse(String courseCodeToModify, String newCourseName, String newDepartment, int newCredits, int newHours, String newLecturer) throws SQLException {
        String query = "UPDATE course SET course_name = ?, department = ?, credits = ?, hours = ?, lecturer = ? WHERE course_code = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newCourseName);
            statement.setString(2, newDepartment);
            statement.setInt(3, newCredits);
            statement.setInt(4, newHours);
            statement.setString(5, newLecturer);
            statement.setString(6, courseCodeToModify);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteCourse(String courseCodeToDelete) throws SQLException {
        String query = "DELETE FROM course WHERE course_code = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseCodeToDelete);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
