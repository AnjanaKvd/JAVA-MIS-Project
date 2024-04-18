package university.misv2.universitymisv2.student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.Objects;

public class StudentDashboard {

   @FXML
   private Label dashboardLabel;
    @FXML
   private Label AttendanceLabel;
    @FXML
    private Label MedicalLabel;
    @FXML
    private Label CourseLabel;
    @FXML
    private Label GradesLabel;
    @FXML
    private Label TimetableLabel;
    @FXML
    private Label NotificationLabel;
    @FXML
    private Label HelpLabel;


    @FXML
    private void updateProfile() {
        // Implement updating contact details and profile picture
        // Show appropriate UI components for updating profile
    }

    @FXML
    private void handleDashboardClick() {
        // Implement updating contact details and profile picture
        // Show appropriate UI components for updating profile
    }

    @FXML
    public void viewAttendance() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewattendance.fxml")));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();


        }

    }


    @FXML
    private void viewMedicalDetails() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewMedicalDetails.fxml"));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();


        }
    }
    @FXML
    private void viewCourseDetails() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewCourseDetails.fxml"));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();


        }
    }
    @FXML
    private void viewGrades() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewGrades.fxml"));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();


        }
    }
    @FXML
    private void viewTimetable() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewTimetable.fxml"));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();


        }
    }
    @FXML
    private void viewNotices() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewNotices.fxml"));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();


        }
    }
    @FXML
    private void showAlert() {
        // Helper method to display an alert dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("This is an alert message!");
        alert.showAndWait();
    }

}
