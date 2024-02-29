package mis.university;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;

public class AdminDashboardController {
    @FXML
    private HBox dashboardBox;
    @FXML
    private HBox usersBox;
    @FXML
    private HBox coursesBox;
    @FXML
    private HBox timeBox;
    @FXML
    private HBox notificationBox;

    @FXML
    private void initialize(){
        dashboardBox.setOnMouseClicked(event -> openDashboardPage());
        usersBox.setOnMouseClicked(event -> openSettingsPage());
        coursesBox.setOnMouseClicked(event -> openPasswordsPage());
        timeBox.setOnMouseClicked(event -> openInfoPage());
        notificationBox.setOnMouseClicked(event -> openInfoPage());

        editProfileButton.setOnAction(event -> updateProfileImage());
        logoutButton.setOnAction(event -> logout());
        saveChangesButton.setOnAction(event -> saveChanges());
    }
}
