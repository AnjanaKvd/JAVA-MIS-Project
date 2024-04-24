package university.misv2.universitymisv2.admin;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;

public class TimetableManager {
    public static void addTimetable(String courseCode, String courseName, String lecturer, String classroom, String dayOfWeek, LocalTime startTime, LocalTime endTime) throws SQLException {
        String query = "INSERT INTO timetable (course_code, course_name, lecturer, classroom, day_of_week, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseCode);
            statement.setString(2, courseName);
            statement.setString(3, lecturer);
            statement.setString(4, classroom);
            statement.setString(5, dayOfWeek);
            statement.setTime(6, java.sql.Time.valueOf(startTime));
            statement.setTime(7, java.sql.Time.valueOf(endTime));
            statement.executeUpdate();
        }
    }

    public static void modifyTimetable(int timetableId, String newCourseName, String newLecturer, String newClassroom, String newDayOfWeek, LocalTime newStartTime, LocalTime newEndTime) throws SQLException {
        String query = "UPDATE timetable SET course_name = ?, lecturer = ?, classroom = ?, day_of_week = ?, start_time = ?, end_time = ? WHERE timetable_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newCourseName);
            statement.setString(2, newLecturer);
            statement.setString(3, newClassroom);
            statement.setString(4, newDayOfWeek);
            statement.setTime(5, java.sql.Time.valueOf(newStartTime));
            statement.setTime(6, java.sql.Time.valueOf(newEndTime));
            statement.setInt(7, timetableId);
            statement.executeUpdate();
        }
    }

    public static void deleteTimetable(int timetableId) throws SQLException {
        String query = "DELETE FROM timetable WHERE timetable_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, timetableId);
            statement.executeUpdate();
        }
    }
}
