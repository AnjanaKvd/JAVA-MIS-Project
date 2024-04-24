package university.misv2.universitymisv2.lecturer;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private String student_id;
    private int user_id;
    private String acedamic_status;
    private String address;
    private Date date_of_birth;
    private int department_id;
    private String batch_year;


    public User(String student_id, int user_id, String acedamic_status, String address, Date date_of_birth, int department_id, String batch_year) {
        this.student_id = student_id;
        this.user_id = user_id;
        this.acedamic_status = acedamic_status;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.department_id = department_id;
        this.batch_year = batch_year;
    }

    public static List<User> fetchAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connectDB = DatabaseConnection.getConnection();

        String query = "SELECT student_id, user_id, acedamic_status, address,date_of_birth, department_id, batch_year FROM students";

        try {
            assert connectDB != null;
            try (Statement statement = connectDB.createStatement();
                     ResultSet result = statement.executeQuery(query)) {

                while (result.next()) {
                    String student_id = result.getString("student_id");
                    int user_id = result.getInt("user_id");
                    String acedamic_status = result.getString("acedamic_status");
                    String address = result.getString("address");
                    Date date_of_birth = result.getDate("date_of_birth");
                    int department_id = result.getInt("department_id");
                    String batch_year = result.getString("batch_year");

                    // Create a new User instance with the data from the ResultSet
                    User user = new User(student_id, user_id, acedamic_status, address,date_of_birth,department_id,batch_year);
                    users.add(user);
                }

            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return users;
    }

    public String getStudent_id() {
        return student_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getAcedamic_status() {
        return acedamic_status;
    }

    public String getAddress() {
        return address;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public String getBatch_year() {
        return batch_year;
    }
}
