package university.misv2.universitymisv2.admin;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AdminController {

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
        dashboardOption1.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption1));
        dashboardOption2.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption2));
        dashboardOption3.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption3));
        dashboardOption4.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption4));
        dashboardOption5.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption5));

//         Set the default selected option
        handleDashboardOptionSelected(dashboardOption1);
    }

    @FXML
    private void handleCloseButtonAction() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    private void handleDashboardOptionSelected(HBox selectedOption) {
        VBox dashboardOptionsContainer = (VBox) selectedOption.getParent();
        dashboardOptionsContainer.getChildren().forEach(option -> option.getStyleClass().setAll("dashboard-option"));
        selectedOption.getStyleClass().setAll("dashboard-option-selected");

        // Update the dashboard label
        dashboardLabel.setText(optionText);

        dashboardTab.setVisible(false);
        usersTab.setVisible(false);
        coursesTab.setVisible(false);
        timetablesTab.setVisible(false);
        notificationTab.setVisible(false);

        if (selectedOption == dashboardOption1) {
            dashboardTab.setVisible(true);
        } else if (selectedOption == dashboardOption2) {
            usersTab.setVisible(true);
        } else if (selectedOption == dashboardOption3) {
            coursesTab.setVisible(true);
        } else if (selectedOption == dashboardOption4) {
            timetablesTab.setVisible(true);
        } else if (selectedOption == dashboardOption5) {
            notificationTab.setVisible(true);
        }
    }

    @FXML
    private void addUserClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType = userTypeDropdown.getValue();
        try {
            UserManager.addUser(username, password, userType);
            usernameField.clear();
            passwordField.clear();
            userTypeDropdown.getSelectionModel().clearSelection();
            userAddedLabel.setText("User added successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void modifyUserClicked() {
        String oldUsername = modifyUsernameField.getText();
        String newUsername = newUsernameField.getText();
        String newPassword = newPasswordField.getText();
        String userType = userTypeDropdown2.getValue();
        try {
            UserManager.modifyUser(oldUsername, newUsername, newPassword, userType);
            modifyUsernameField.clear();
            newUsernameField.clear();
            newPasswordField.clear();
            userTypeDropdown2.getSelectionModel().clearSelection();
            userModifiedLabel.setText("User modified successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteUserClicked() {
        String usernameToDelete = deleteUsernameField.getText();
        try {
            UserManager.deleteUser(usernameToDelete);
            deleteUsernameField.clear();
            userDeletedLabel.setText("User deleted successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addCourseClicked(ActionEvent event) {
        String courseCode = courseCodeField.getText();
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

    @FXML
    private void modifyCourseClicked(ActionEvent event) {
        String courseCodeToModify = modifyCourseCodeField.getText();
        String newCourseName = newCourseNameField.getText();
        String newDepartment = newDepartmentDropdown.getValue();
        int newCredits = Integer.parseInt(newCreditsField.getText());
        int newHours = Integer.parseInt(newHoursField.getText());
        String newLecturer = newLecturerField.getText();
        try {
            CourseManager.modifyCourse(courseCodeToModify, newCourseName, newDepartment, newCredits, newHours, newLecturer);
            modifyCourseCodeField.clear();
            newCourseNameField.clear();
            newDepartmentDropdown.getSelectionModel().clearSelection();
            newCreditsField.clear();
            newHoursField.clear();
            newLecturerField.clear();
            courseModifiedLabel.setText("Course modified successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteCourseClicked(ActionEvent event) {
        String courseCodeToDelete = deleteCourseCodeField.getText();
        try {
            CourseManager.deleteCourse(courseCodeToDelete);
            deleteCourseCodeField.clear();
            courseDeletedLabel.setText("Course deleted successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addTimetableClicked(ActionEvent event) {
        String courseCode = timetableCourseCodeField.getText();
        String courseName = timetablecourseNameField.getText();
        String lecturer = timetablelecturerField.getText();
        String classroom = timetableclassroomField.getText();
        String dayOfWeek = dayOfWeekDropdown.getValue();
        LocalTime startTime = LocalTime.parse(startTimeField.getText());
        LocalTime endTime = LocalTime.parse(endTimeField.getText());

        try {
            TimetableManager.addTimetable(courseCode, courseName, lecturer, classroom, dayOfWeek, startTime, endTime);
            timetableCourseCodeField.clear();
            timetablecourseNameField.clear();
            timetablelecturerField.clear();
            timetableclassroomField.clear();
            dayOfWeekDropdown.getSelectionModel().clearSelection();
            startTimeField.clear();
            endTimeField.clear();
            timetableAddedLabel.setText("Timetable entry added successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void modifyTimetableClicked(ActionEvent event) {
        int timetableId = Integer.parseInt(timetableIdField.getText());
        String newCourseName = newTimetableCourseNameField.getText();
        String newLecturer = newTimetableLecturerField.getText();
        String newClassroom = newTimetableClassroomField.getText();
        String newDayOfWeek = newDayOfWeekDropdown.getValue();
        LocalTime newStartTime = LocalTime.parse(newTimetableStartTimeField.getText());
        LocalTime newEndTime = LocalTime.parse(newTimetableEndTimeField.getText());

        try {
            TimetableManager.modifyTimetable(timetableId, newCourseName, newLecturer, newClassroom, newDayOfWeek, newStartTime, newEndTime);
            timetableIdField.clear();
            newTimetableCourseNameField.clear();
            newTimetableLecturerField.clear();
            newTimetableClassroomField.clear();
            newDayOfWeekDropdown.getSelectionModel().clearSelection();
            newTimetableStartTimeField.clear();
            newTimetableEndTimeField.clear();
            timetableModifiedLabel.setText("Timetable entry modified successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteTimetableClicked(ActionEvent event) {
        int timetableIdToDelete = Integer.parseInt(deleteTimetableIdField.getText());

        try {
            TimetableManager.deleteTimetable(timetableIdToDelete);
            deleteTimetableIdField.clear();
            timetableDeletedLabel.setText("Timetable entry deleted successfully !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadNotifications() {
        try {
            List<String> notifications = NotificationManager.getAllNotifications();
            for (String notification : notifications) {
                String[] parts = notification.split(", ");
                String id = parts[0].substring(4); // ID
                String message = parts[1].substring(9); //Message
                String date = parts[2].substring(6); //Date
                addNotification(id, message, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addNotification(String id, String message, String date) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("notification.fxml"));
            BorderPane notificationPane = loader.load();

            NotificationController controller = loader.getController();
            controller.setAdminController(this);
            controller.setNotificationData(id, message, date);
            notificationContainer.getChildren().add(notificationPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void refreshNotifications() {
        try {
            notificationContainer.getChildren().clear();
            loadNotifications();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSendNotification(ActionEvent event) {
        String message = notificationInputBox.getText();

        if (!message.isEmpty()) {
            try {
                NotificationManager.addNotification(message);
                notificationInputBox.clear();
                refreshNotifications();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleProfileSectionSelect() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/university/misv2/universitymisv2/Profile.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            Stage currentStage = (Stage) profileSection.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateUserDetails(String username) {
        String fullName = UserProfileManager.getUserFullName(username);
        UserData.setFullName(fullName);
        userFullName.setText(fullName);

        String profileImagePath = UserProfileManager.getUserProfileImagePath(username);
        UserData.setUserProfileImage(profileImagePath);

        Image newImage = new Image(profileImagePath);
        profileIconCircle.setFill(new ImagePattern(newImage));
    }
}
