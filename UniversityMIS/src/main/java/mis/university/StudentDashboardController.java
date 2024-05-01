package mis.university;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StudentDashboardController {

    @FXML
    private Button updateProfileButton;

    @FXML
    private Button courseDetailsButton;

    @FXML
    private Button gpaButton;

    @FXML
    private Button timetableButton;

    @FXML
    private Button attendanceButton;

    @FXML
    private Button medicalButton;

    @FXML
    private Button notificationsButton;


    @FXML
    private void handleUpdateProfileButtonClick() {

        System.out.println("Update Profile button clicked");
    }


    @FXML
    private void handleCourseDetailsButtonClick() {

        System.out.println("Course Details button clicked");
    }


    @FXML
    private void handleGPAButtonClick() {

        System.out.println("GPA button clicked");
    }


    @FXML
    private void handleTimetableButtonClick() {

        System.out.println("Timetable button clicked");
    }


    @FXML
    private void handleAttendanceButtonClick() {

        System.out.println("Attendance button clicked");
    }


    @FXML
    private void handleMedicalButtonClick() {

        System.out.println("Medical button clicked");
    }


    @FXML
    private void handleNotificationsButtonClick() {

        System.out.println("Notifications button clicked");
    }


    @FXML
    private void handleLogOutButtonClick() {

        System.out.println("Log Out button clicked");

    }
}
