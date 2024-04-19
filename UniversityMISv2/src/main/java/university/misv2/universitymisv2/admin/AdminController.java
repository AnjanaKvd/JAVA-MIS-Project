package university.misv2.universitymisv2.admin;

import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class AdminController {
    public Label userAddedLabel;
    public Label userModifiedLabel;
    public Label userDeletedLabel;
    @FXML
    private Label profileNameLabel;

    @FXML
    private Label dashboardLabel;

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
    private AnchorPane dashboardTab;

    @FXML
    private AnchorPane usersTab;

    @FXML
    private AnchorPane coursesTab;

    @FXML
    private AnchorPane notificationTab;

    @FXML
    private AnchorPane helpTab;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> userTypeDropdown;

    @FXML
    private TextField modifyUsernameField;

    @FXML
    private TextField newUsernameField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private ComboBox<String> userTypeDropdown2;

    @FXML
    private TextField deleteUsernameField;

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
        dashboardOption2.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption2, "Users"));
        dashboardOption3.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption3, "Courses"));
        dashboardOption4.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption4, "Notifications"));
        dashboardOption5.setOnMouseClicked(event -> handleDashboardOptionSelected(dashboardOption5, "Help"));

        // Set the default selected option
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
        usersTab.setVisible(false);
        coursesTab.setVisible(false);
        notificationTab.setVisible(false);
        helpTab.setVisible(false);

        if (selectedOption == dashboardOption1) {
            dashboardTab.setVisible(true);
        } else if (selectedOption == dashboardOption2) {
            usersTab.setVisible(true);
        } else if (selectedOption == dashboardOption3) {
            coursesTab.setVisible(true);
        } else if (selectedOption == dashboardOption4) {
            notificationTab.setVisible(true);
        } else if (selectedOption == dashboardOption5) {
            helpTab.setVisible(true);
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
            // Handle database errors
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
            // Handle database errors
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
            // Handle database errors
            e.printStackTrace();
        }
    }

    public void addCourseClicked(ActionEvent event) {
    }

    public void modifyCourseClicked(ActionEvent event) {
    }

    public void deleteCourseClicked(ActionEvent event) {
    }
}
