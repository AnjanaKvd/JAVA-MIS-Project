package university.misv2.universitymisv2.technicalOfficer;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import university.misv2.universitymisv2.admin.CourseManager;

import java.sql.SQLException;

public class TechnicalOfficerController {

    public AnchorPane dashboardTab;
    public AnchorPane attendanceTab;
    public AnchorPane medicalTab;
    public AnchorPane timetableTab;
    public AnchorPane noticeTab;
    public Label dashboardLabel;
    @FXML
    private Label profileNameLabel;

    @FXML
    private Label profileRoleLabel;

    @FXML
    private ImageView closeBtn;

    @FXML
    private HBox dashboardOption1;

    @FXML
    private HBox dashboardOption2;

    @FXML
    private HBox dashboardOption3;

    @FXML
    private HBox dashboardOption4;

    @FXML
    private HBox dashboardOption5;

    @FXML
    private void initialize() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.4), closeBtn);
        rotateTransition.setByAngle(360);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(1);
        closeBtn.setOnMouseEntered(event -> rotateTransition.play());
        closeBtn.setOnMouseExited(event -> rotateTransition.stop());
        closeBtn.setOnMouseExited(event -> rotateTransition.setFromAngle(0));

        // Add event handlers for side options
        dashboardOption1.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption1, "Dashboard"));
        dashboardOption2.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption2, "Attendance"));
        dashboardOption3.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption3, "Medical"));
        dashboardOption4.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption4, "Timetables"));
        dashboardOption5.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption5, "Notices"));

//         Set the default selected option
        handleDashboardOptionSelected(dashboardOption1, "Dashboard");
    }

    @FXML
    private void handleCloseButtonAction() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    private void handleDashboardOptionSelected(HBox selectedOption, String optionText) {
        VBox dashboardOptionsContainer = (VBox) selectedOption.getParent();
        dashboardOptionsContainer.getChildren().forEach(option -> option.getStyleClass().setAll("dashboard-option"));
        selectedOption.getStyleClass().setAll("dashboard-option-selected");

        // Update the dashboard label
        dashboardLabel.setText(optionText);

        dashboardTab.setVisible(false);
        attendanceTab.setVisible(false);
        medicalTab.setVisible(false);
        timetableTab.setVisible(false);
        noticeTab.setVisible(false);

        if (selectedOption == dashboardOption1) {
            dashboardTab.setVisible(true);
        } else if (selectedOption == dashboardOption2) {
            attendanceTab.setVisible(true);
        } else if (selectedOption == dashboardOption3) {
            medicalTab.setVisible(true);
        } else if (selectedOption == dashboardOption4) {
            timetableTab.setVisible(true);
        } else if (selectedOption == dashboardOption5) {
            noticeTab.setVisible(true);
        }
    }

    public void AddMaterialsButton(ActionEvent event) {
        String Student_id =Student_idField.getText();
        String courseName = courseNameField.getText();
        String department = departmentDropdown.getValue();
        int credits = Integer.parseInt(creditsField.getText());
        int hours = Integer.parseInt(hoursField.getText());
        String lecturer = lecturerField.getText();
        try {

            CourseManager.addCourse(courseCode, courseName, department, credits, hours, lecturer);
            courseCodeField.clear();
            courseNameField.clear();
            departmentDropdown.getSelectionModel().clearSelection();
            creditsField.clear();
            hoursField.clear();
            lecturerField.clear();
            courseAddedLabel.setText("Course added successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void cancleButtononAction(ActionEvent event) {
    }
}
