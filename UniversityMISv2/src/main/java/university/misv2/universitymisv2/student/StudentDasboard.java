import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

class StudentDashboard {

    @FXML
    void handleUpdateProfileButton(ActionEvent event) {
        // Handle updating contact details and profile picture
        updateProfile();
    }

    @FXML
    void handleAttendanceButton(ActionEvent event) {
        // Handle viewing attendance details
        viewAttendance();
    }

    @FXML
    void handleMedicalButton(ActionEvent event) {
        // Handle viewing medical details
        viewMedicalDetails();
    }

    @FXML
    void handleCourseDetailsButton(ActionEvent event) {
        // Handle viewing course details
        viewCourseDetails();
    }

    @FXML
    void handleGradesButton(ActionEvent event) {
        // Handle viewing grades and GPA
        viewGrades();
    }

    @FXML
    void handleTimetableButton(ActionEvent event) {
        // Handle viewing timetables
        viewTimetable();
    }

    @FXML
    void handleNoticesButton(ActionEvent event) {
        // Handle viewing notices
        viewNotices();
    }

    private void updateProfile() {
        // Implement updating contact details and profile picture
        // Show appropriate UI components for updating profile
    }

    private void viewAttendance() {
        // Implement viewing attendance details
        // You can display attendance data in a table or any other suitable format
    }

    private void viewMedicalDetails() {
        // Implement viewing medical details
        // You can display medical details in a separate window or dialog
    }

    private void viewCourseDetails() {
        // Implement viewing course details
        // You can display course details in a table or any other suitable format
    }

    private void viewGrades() {
        // Implement viewing grades and GPA
        // You can display grades and GPA in a separate window or dialog
    }

    private void viewTimetable() {
        // Implement viewing timetables
        // You can display timetables in a separate window or dialog
    }

    private void viewNotices() {
        // Implement viewing notices
        // You can display notices in a separate window or dialog
    }

    private void showAlert(String title, String headerText, String contentText) {
        // Helper method to display an alert dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
