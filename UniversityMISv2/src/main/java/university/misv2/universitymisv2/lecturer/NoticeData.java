package university.misv2.universitymisv2.lecturer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NoticeData {
    private int notice_id;
    private String notice_message;
    private String notic_date_time;

    public NoticeData(int notice_id, String notice_message, String notic_date_time) {
        this.notice_id = notice_id;
        this.notice_message = notice_message;
        this.notic_date_time = notic_date_time;
    }

    public static List<NoticeData> fetchAllUsers() throws SQLException {
        List<NoticeData> noticedata = new ArrayList<>();

        Connection connectDB = DatabaseConnection.getConnection();

        String query = "SELECT id,message,date_time FROM notification";

        try {
            assert connectDB != null;
            try (Statement statement = connectDB.createStatement();
                     ResultSet result = statement.executeQuery(query)) {

                while (result.next()) {
                    int id= result.getInt("id");
                    String message = result.getString("message");
                    String date_time = result.getString("date_time");


                    // Create a new User instance with the data from the ResultSet
                    NoticeData noticeData = new NoticeData(id,message,date_time);
                    noticedata.add(noticeData);
                }

            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return noticedata;
    }

    public int getNotice_id() {
        return notice_id;
    }

    public String getNotice_message() {
        return notice_message;
    }

    public String getNotic_date_time() {
        return notic_date_time;
    }
}
