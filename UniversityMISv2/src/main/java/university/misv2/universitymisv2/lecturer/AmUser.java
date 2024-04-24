package university.misv2.universitymisv2.lecturer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AmUser {
    private int id;
    private String reason;
    private Date start_date;
    private Date end_date;
    private String is_day_medical;
    private Date submitted_date;

    public AmUser(int id, String reason, Date start_date, Date end_date, String is_day_medical, Date submitted_date) {
        this.id = id;
        this.reason = reason;
        this.start_date = start_date;
        this.end_date = end_date;
        this.is_day_medical = is_day_medical;
        this.submitted_date = submitted_date;
    }

    public static List<AmUser> fetchAllUsers() throws SQLException {
        List<AmUser> amUser = new ArrayList<>();
        Connection connectDB = DatabaseConnection.getConnection();

        String query = "SELECT id, reason, start_date, end_date,is_day_medical, submitted_date FROM medical";

        try {
            assert connectDB != null;
            try (Statement statement = connectDB.createStatement();
                     ResultSet result = statement.executeQuery(query)) {

                while (result.next()) {
                    int id = result.getInt("id");
                    String reason = result.getString("reason");
                    Date start_date = result.getDate("start_date");
                    Date end_date = result.getDate("end_date");
                    String is_day_medical = result.getString("is_day_medical");
                    Date submitted_date = result.getDate("submitted_date");


                    // Create a new User instance with the data from the ResultSet
                    AmUser amuser = new AmUser(id, reason, start_date, end_date,is_day_medical,submitted_date);
                    amUser.add(amuser);
                }

            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return amUser;
    }

    public int getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public String getIs_day_medical() {
        return is_day_medical;
    }

    public Date getSubmitted_date() {
        return submitted_date;
    }
}
