
package university.misv2.universitymisv2.lecturer;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Attendance {
    private String student_id;
    private String course_code;
    private String Theory_or_Practical;
    private String Status;



    public Attendance(String student_id, String course_code, String Theory_or_Practical, String Status) {
        this.student_id = student_id;
        this.course_code = course_code;
        this.Theory_or_Practical = Theory_or_Practical;
        this.Status = Status;

    }

    public static List<Attendance> fetchAllUsers() throws SQLException {
        List<Attendance> attendance = new ArrayList<>();
        Connection connectDB = DatabaseConnection.getConnection();

        String query = "SELECT student_id, course_code, Theory_or_Practical, Status FROM course_attendence";

        try {
            assert connectDB != null;
            try (Statement statement = connectDB.createStatement();
                     ResultSet result = statement.executeQuery(query)) {

                while (result.next()) {
                    String student_id = result.getString("student_id");
                    String course_code = result.getString("course_code");
                    String Theory_or_Practical = result.getString("Theory_or_Practical");
                    String Status = result.getString("Status");




                    // Create a new User instance with the data from the ResultSet
                    Attendance attendancedata = new Attendance(student_id, course_code, Theory_or_Practical, Status);
                    attendance.add(attendancedata);
                }

            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return attendance;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getTheory_or_Practical() {
        return Theory_or_Practical;
    }

    public String getStatus() {
        return Status;
    }

}
