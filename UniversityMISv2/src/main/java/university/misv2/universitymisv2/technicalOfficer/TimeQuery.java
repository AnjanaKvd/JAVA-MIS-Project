package university.misv2.universitymisv2.technicalOfficer;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class TimeQuery {
    private int timetable_id;
    private String course_code;
    private String course_name;
    private String lecturer;
    private String classroom;
    private String day_of_week;
    private String start_time;
    private String end_time;

    public TimeQuery(int timetable_id, String course_code, String course_name, String lecturer, String classroom, String day_of_week, String start_time, String end_time) {
        this.timetable_id = timetable_id;
        this.course_code = course_code;
        this.course_name = course_name;
        this.lecturer = lecturer;
        this.classroom = classroom;
        this.day_of_week = day_of_week;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public static List<TimeQuery> fetchAllUsers()  {
        List<TimeQuery> timeQuery = new ArrayList<>();

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String query = "SELECT timetable_id,course_code,course_name,lecturer,classroom,day_of_week,start_time,end_time FROM timetable";

        try (Statement statement = connectDB.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {

                int timetable_id =result.getInt("timetable_id");
                String course_code = result.getString("course_code");
                String course_name = result.getString("course_name");
                String lecturer = result.getString("lecturer");
                String classroom = result.getString("classroom");
                String day_of_week = result.getString("day_of_week");
                String start_time = result.getString("start_time");
                String end_time = result.getString("end_time");



                // Create a new User instance with the data from the ResultSet
                TimeQuery timeuser = new TimeQuery(timetable_id,course_code,course_name,lecturer,classroom,day_of_week,start_time,end_time);
                timeQuery.add(timeuser);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return timeQuery;
    }

    public int getTimetable_id() {
        return timetable_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }
}

