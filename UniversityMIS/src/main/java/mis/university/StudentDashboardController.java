package mis.university;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class StudentDashboardController {

    @FXML
    private void manageProfile() {
        // Implement logic to manage user profiles
        showAlert("Manage User Profiles clicked");
    }

    @FXML
    private void ViewCourses() {
        // Implement logic to manage courses
        showAlert("Manage Courses clicked");
    }

    private void ViewAttendance() {
        // Implement logic to manage courses
        showAlert("Manage Courses clicked");
    }

    private void ViewGPA() {
        // Implement logic to manage courses
        showAlert("Manage Courses clicked");
    }
    @FXML
    private void ViewNotices() {
        // Implement logic to manage notices
        showAlert("Manage Notices clicked");
    }

    @FXML
    private void ViewTimetables() {
        // Implement logic to manage timetables
        showAlert("Manage Timetables clicked");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
