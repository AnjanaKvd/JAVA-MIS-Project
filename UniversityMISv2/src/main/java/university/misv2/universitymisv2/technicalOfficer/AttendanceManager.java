package university.misv2.universitymisv2.technicalOfficer;

import javafx.geometry.Insets;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceManager {
    public static void AddAttendances(String student_id, String Course_Code, String theory_or_practical, Insets date, String Status) {
        String query = "INSERT INTO course_attendance (studentId, courseCode,theory_or_practical , date,Status ) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,student_id );
            statement.setString(2, Course_Code);
            statement.setString(3, theory_or_practical);
            //statement.setInt(4, date);
            statement.setString(5,Status);
          //  statement.setString(6, lecturer);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modifyAttendances(String newStudent_id, String newCourse_code, String newtheory_or_practical, Date newdate, String newStatus) {
        String query = "UPDATE course_attendance SET studentId = ?, courseCode = ?, theory_or_practical = ?, date = ?, Status = ? WHERE course_code = ? && studentId ";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newStudent_id);
            statement.setString(2, newCourse_code);
            statement.setString(5, newtheory_or_practical);
            //statement.setInt(3, newdate);
            statement.setString(6, newStatus);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void modifydeleteAttendance(){

    }
}
