package university.misv2.universitymisv2.student;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class CourseUser {

    private String  code;
    private String name;
    private int credits;
    private String  gpa_or_ngpa;
    private String is_mid;
    private String is_project;
    private String theory_or_practical;

    public CourseUser(String code, String name, int credits, String gpa_or_ngpa, String is_mid, String is_project, String theory_or_practical) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.gpa_or_ngpa = gpa_or_ngpa;
        this.is_mid = is_mid;
        this.is_project = is_project;
        this.theory_or_practical = theory_or_practical;
    }

    public static  List<CourseUser> fetchAllUsers() {
        List<CourseUser> courseUsers = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query = "select code,name,credits,gpa_or_ngpa,is_mid,is_project,theory_or_practical from courses";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                String code = result.getString("code");
                String name = result.getString("name");
                int credits = result.getInt("credits");
                String gpa_or_ngpa = result.getString("gpa_or_ngpa");
                String is_mid = result.getString("is_mid");
                String is_project = result.getString("is_project");
                String theory_or_practical = result.getString("theory_or_practical");

                // Create a new User instance with the data from the ResultSet
                CourseUser courseuser = new CourseUser(code,name,credits,gpa_or_ngpa,is_mid,is_project,theory_or_practical);
                courseUsers.add(courseuser);

            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return courseUsers;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGpa_or_ngpa() {
        return gpa_or_ngpa;
    }

    public String getIs_mid() {
        return is_mid;
    }

    public String getIs_project() {
        return is_project;
    }

    public String getTheory_or_practical() {
        return theory_or_practical;
    }
}

