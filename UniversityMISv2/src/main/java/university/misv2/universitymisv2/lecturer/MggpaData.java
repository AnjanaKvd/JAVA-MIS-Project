package university.misv2.universitymisv2.lecturer;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MggpaData {

    private String student_id;
    private String CGPA;


    public MggpaData(String student_id, String CGPA) {
        this.student_id = student_id;
        this.CGPA = CGPA;
    }

    public static List<MggpaData> fetchAllUsers() throws SQLException {
        List<MggpaData> mggpa = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query = "SELECT student_id, CGPA FROM Cumulative_GPA";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                String student_id = result.getString("student_id");
                String CGPA = result.getString("CGPA");




                // Create a new User instance with the data from the ResultSet
                MggpaData mggpadata = new MggpaData(student_id,CGPA);
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

    public String getCGPA() {
        return CGPA;
    }
}

