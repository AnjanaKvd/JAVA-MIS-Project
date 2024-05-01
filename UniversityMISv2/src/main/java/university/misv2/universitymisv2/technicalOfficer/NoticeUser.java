package university.misv2.universitymisv2.technicalOfficer;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NoticeUser {
        private int id;
        private String message;
        private String date_time;

    public NoticeUser(int id, String message, String date_time) {
        this.id = id;
        this.message = message;
        this.date_time = date_time;
    }
    public static  List<NoticeUser> fetchAllUsers()   {
        List<NoticeUser> noticeUser = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query = "SELECT id,message,date_time FROM notification";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                int id = result.getInt("id");
                String message = result.getString("message");
                String date_time = result.getString("date_time");


                // Create a new User instance with the data from the ResultSet
                NoticeUser noticeuser = new NoticeUser(id,message,date_time);
                noticeUser.add(noticeuser);

            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return noticeUser;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getDate_time() {
        return date_time;
    }
}
