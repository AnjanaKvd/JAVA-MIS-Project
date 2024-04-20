package university.misv2.universitymisv2.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private Integer id;
    private String student_id;
    private String course_code;
    private Date Date;
    private String Theory_or_Practical;
    private String Status;

    public User(int id, String student_id, String course_code, Date Date, String Theory_or_Practical, String Status) {
        this.id = id;
        this.student_id = student_id;
        this.course_code = course_code;
        this.Date = Date;
        this.Theory_or_Practical = Theory_or_Practical;
        this.Status = Status;
    }

    public static  List<User> fetchAllUsers()  {
        List<User> users = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query = "SELECT id,student_id,course_code,Date,Theory_or_Practical,Status FROM course_attendence";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                int id = result.getInt("id");
                String student_id = result.getString("student_id");
                String course_code = result.getString("course_code");
                Date Date = result.getDate("Date");
                String Theory_or_Practical = result.getString("Theory_or_Practical");
                String Status = result.getString("Status");

                // Create a new User instance with the data from the ResultSet
                User user = new User(id, student_id, course_code, Date, Theory_or_Practical, Status);
                users.add(user);

            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return users;
    }


    public int get_id() {
        return id;
    }

    public String get_student_id() {
        return student_id;
    }

    public String get_course_code() {
        return course_code;
    }

    public Date getDate() {
        return Date;
    }

    public String getTheory_or_Practical() {
        return Theory_or_Practical;
    }

    public String get_Status() {
        return Status;
    }


}
