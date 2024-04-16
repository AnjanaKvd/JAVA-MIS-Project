package university.misv2.universitymisv2.student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.*;

class StudentDashboard {

   @FXML
   private Button CloseButton;

    private void updateProfile() {
        // Implement updating contact details and profile picture
        // Show appropriate UI components for updating profile
    }

    private void viewAttendance() {

            try {
                Parent root = FXMLLoader.load(getClass().getResource("viewattendance.fxml"));
                Stage registerStage = new Stage();
                registerStage.setScene(new Scene(root, 600, 400));
                registerStage.show();


            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();


        }
    }

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

    private void showAlert(String title, String headerText, String contentText) {
        // Helper method to display an alert dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
