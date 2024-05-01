package university.misv2.universitymisv2.student;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class GPAUser {
    private String SGPA;
    private String CGPA;

    public GPAUser(String SGPA, String CGPA) {
        this.SGPA = SGPA;
        this.CGPA = CGPA;
    }

    public static List<GPAUser> fetchAllUsers()  {
        List<GPAUser> gpauser = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query ="select s.SGPA,c.CGPA from SGPA_View s INNER JOIN CGPA_View c ON s.student_id=c.student_id where s.student_id='S001'";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {

            //    String student_id1 =result.getString("student_id");
                String SGPA = result.getString("SGPA");
                String CGPA = result.getString("CGPA");




                // Create a new User instance with the data from the ResultSet
                GPAUser gpausers = new GPAUser(SGPA,CGPA);
                gpauser.add(gpausers);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return gpauser;
    }

//    public String getStudent_id1() {
//        return student_id1;
//    }

    public String getSGPA() {
        return SGPA;
    }

    public String getCGPA() {
        return CGPA;
    }
}
