package university.misv2.universitymisv2.student;


import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeUser {

    private String course_code;
    private String student_id;
    private int quiz1_marks;
    private int quiz2_marks;
    private int quiz3_marks;
    private int mid_marks;
    private int project_marks;
    private int end_marks;


    public GradeUser(String course_code, String student_id, int quiz1_marks, int quiz2_marks, int quiz3_marks, int mid_marks, int project_marks, int end_marks) {
        this.course_code = course_code;
        this.student_id = student_id;
        this.quiz1_marks = quiz1_marks;
        this.quiz2_marks = quiz2_marks;
        this.quiz3_marks = quiz3_marks;
        this.mid_marks = mid_marks;
        this.project_marks = project_marks;
        this.end_marks = end_marks;
    }


    public static List<GradeUser> fetchAllUsers()  {
        List<GradeUser> gradeUser = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query = "SELECT course_code,student_id,quiz1_marks,quiz2_marks,quiz3_marks,mid_marks,project_marks,end_marks FROM course_marks";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {

                String course_code =result.getString("course_code");
                String student_id = result.getString("student_id");
                int quiz1_marks = result.getInt("quiz1_marks");
                int quiz2_marks = result.getInt("quiz2_marks");
                int quiz3_marks = result.getInt("quiz3_marks");
                int mid_marks = result.getInt("mid_marks");
                int project_marks = result.getInt("project_marks");
                int end_marks = result.getInt("end_marks");



                // Create a new User instance with the data from the ResultSet
                GradeUser gradeuser = new GradeUser(course_code,student_id,quiz1_marks,quiz2_marks,quiz3_marks,mid_marks,project_marks,end_marks);
                gradeUser.add(gradeuser);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return gradeUser;
    }

    public String getCourse_code() {
        return course_code;
    }

    public int getEnd_marks() {
        return end_marks;
    }

    public int getMid_marks() {
        return mid_marks;
    }

    public int getProject_marks() {
        return project_marks;
    }

    public int getQuiz1_marks() {
        return quiz1_marks;
    }

    public int getQuiz2_marks() {
        return quiz2_marks;
    }

    public int getQuiz3_marks() {
        return quiz3_marks;
    }

    public String getStudent_id() {
        return student_id;
    }
}