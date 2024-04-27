package university.misv2.universitymisv2.technicalOfficer;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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

import java.sql.Date;
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
    private AnchorPane Dashboard;

    @FXML
    private AnchorPane Attendance;

    @FXML
    private AnchorPane Medical;

    @FXML
    public AnchorPane Timetable;

    @FXML
    private AnchorPane Notices;


    @FXML
    private TextField Student_idField;

    @FXML
    private TextField courseNameField;

    @FXML
    private TextField theory_or_practicalField;

    @FXML
    private TextField dateFiled;

    @FXML
    private TextField StatusField;

    public TextField modifyStudentField;
    public TextField newCourseNameField ;
    public  TextField newtheory_or_practicalfiled;
    public  TextField newdatamodifyField;
    public  TextField newStatusField;


    //medical
    public  TextField addmedicalFiled;
    public  TextField addStudent_idField;
    public  TextField addcoursecodeField;
    public  TextField addtheory_or_practicalFiled;
    public  TextField adddateFiled;
    public  TextField addStatusFiled;





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

    public void AddAttendancesButton(ActionEvent event) {
        String Student_id =Student_idField.getText();
        String Course_code = courseNameField.getText();
        String theory_or_practical =theory_or_practicalField .getText();
        Insets date=dateFiled.getOpaqueInsets();
        String Status = StatusField.getText();
        try {

            CourseManager.AddAttendances(Student_id, Course_code, theory_or_practical, date, Status);
            Student_idField.clear();
            courseNameField.clear();
            theory_or_practicalField.clear();
            dateFiled.clear();
            StatusField.clear();
            //lecturerField.clear();
            courseAddedLabel.setText("Attendance added successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @FXML
    private void modifyAttendancesButten(ActionEvent event) {
        String newStudent_id = modifyStudentField.getText();
        String newCourse_code = newCourseNameField.getText();
        String newtheory_or_practical = newtheory_or_practicalfiled.getText();
        Date  newdate=newdatamodifyField.getValue();
        String newStatus = newStatusField.getText();
        try {
            CourseManager.modifyAttendances(newStudent_id, newCourse_code, newtheory_or_practical, newdate, newStatus);
            modifyStudentField.clear();
            newCourseNameField.clear();
            //newDepartmentDropdown.getSelectionModel().clearSelection();
            newtheory_or_practicalfiled.clear();
            newdatamodifyField.clear();
            newStatusField.clear();
            courseModifiedLabel.setText("Attendance modified successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void deleteAttendancesButten(ActionEvent event) {
        String courseCodeToDelete = deleteCourseCodeField.getText();
        try {
            CourseManager.deleteCourse(courseCodeToDelete);
            deleteCourseCodeField.clear();
            courseDeletedLabel.setText("Attendance deleted successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddSubmitButton(ActionEvent event) {
        String Medical_Id =addmedicalFiled.getText();
        String Student_id =addStudent_idField.getText();
        String Course_code = addcoursecodeField.getText();
        String theory_or_practical = addtheory_or_practicalFiled.getText();
        Date  date=adddateFiled.getValue();
        String Status = addStatusFiled.getText();
        try {

            CourseManager.AddAttendances(Medical_Id,Student_id, Course_code, theory_or_practical, date, Status);
            addmedicalFiled.clear();
            courseNameField.clear();
            addcoursecodeField.clear();
            addtheory_or_practicalFiled.clear();
            adddateFiled.clear();
            addStatusFiled.clear();

            courseAddedLabel.setText("Course Medical successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    public void cancleButtononAction(ActionEvent event) {
    }
}
