package university.misv2.universitymisv2.student;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class CourseUser {

    private String  code;
    private String name;
    private Integer credits;
    private String  gpa_or_ngpa;
//    private Integer  department;
//    private Integer  no_of_quiz;
//    private String  is_mid;
//    private Integer  mid_marks;
//    private String is_project;
//    private Integer project_marks;
//    private String theory_or_practical;


    public CourseUser(String code, String name, int credits, String  gpa_or_ngpa) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.gpa_or_ngpa = gpa_or_ngpa;

    }

    public static  List<CourseUser> fetchAllUsers()  {
        List<CourseUser> courseUsers = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query = "select code,name,credits,gpa_or_ngpa from courses";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                String code = result.getString("code");
                String name = result.getString("name");
                int credits = result.getInt("credits");
                String gpa_or_ngpa = result.getString("gpa_or_ngpa");


                // Create a new User instance with the data from the ResultSet
                CourseUser courseuser = new CourseUser(code,name,credits,gpa_or_ngpa);
                courseUsers.add(courseuser);

            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return courseUsers;
    }


    public String get_code() {
        return code;
    }

    public String get_name() {
        return name;
    }

    public Integer get_credits() {
        return credits;
    }


    public String get_gpa_or_ngpa() {
        return gpa_or_ngpa;
    }


}
