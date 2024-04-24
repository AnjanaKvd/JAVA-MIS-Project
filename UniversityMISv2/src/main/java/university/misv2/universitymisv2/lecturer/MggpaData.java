package university.misv2.universitymisv2.lecturer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MggpaData {

    private String student_id;
    private String course_code;
    private String ca_mark;
    private String end_mark;
    private String total_marks;
    private String grade;
    private String gpa;

    public MggpaData(String student_id, String course_code, String ca_mark, String end_mark, String total_marks, String grade) {
        this.student_id = student_id;
        this.course_code = course_code;
        this.ca_mark = ca_mark;
        this.end_mark = end_mark;
        this.total_marks = total_marks;
        this.grade = grade;
    }


    public static List<MggpaData> fetchAllUsers() throws SQLException {
        List<MggpaData> mggpa = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query = "SELECT student_id, course_code, ca_mark, end_mark,total_marks,grade FROM final_marks";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                String student_id = result.getString("student_id");
                String course_code = result.getString("course_code");
                String ca_mark = result.getString("ca_mark");
                String end_mark = result.getString("end_mark");
                String total_marks = result.getString("total_marks");
                String grade = result.getString("grade");



                // Create a new User instance with the data from the ResultSet
                MggpaData mggpadata = new MggpaData(student_id, course_code, ca_mark, end_mark,total_marks,grade);
                mggpa.add(mggpadata);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return mggpa;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getCa_mark() {
        return ca_mark;
    }

    public String getEnd_mark() {
        return end_mark;
    }

    public String getTotal_marks() {
        return total_marks;
    }

    public String getGrade() {
        return grade;
    }
}

