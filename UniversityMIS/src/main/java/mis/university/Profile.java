package mis.university;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Profile {

    @FXML
    private HBox profileBox;

    @FXML
    private HBox settingsBox;

    @FXML
    private HBox passwordsBox;

    @FXML
    private HBox infoBox;

    @FXML
    private Button editProfileButton;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private DatePicker dobDatePicker;

    @FXML
    private VBox displayPages;

    @FXML
    private void initialize() {
        profileBox.setOnMouseClicked(event -> openProfilePage());
        settingsBox.setOnMouseClicked(event -> openSettingsPage());
        passwordsBox.setOnMouseClicked(event -> openPasswordsPage());
        infoBox.setOnMouseClicked(event -> openInfoPage());
    }

    private void openProfilePage() {
        loadPage("profilePage.fxml");
    }

    private void openSettingsPage() {
        loadPage("settingsPage.fxml");
    }

    private void openPasswordsPage() {
        loadPage("passwordsPage.fxml");
    }

    private void openInfoPage() {
        loadPage("infoPage.fxml");
    }

    private void loadPage(String fxmlFileName) {
        try {
            Node node = FXMLLoader.load(getClass().getResource(fxmlFileName));
            displayPages.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
