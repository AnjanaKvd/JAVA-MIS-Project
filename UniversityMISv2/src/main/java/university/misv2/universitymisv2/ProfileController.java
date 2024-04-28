package university.misv2.universitymisv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class ProfileController {

    @FXML
    private Label profileName;

    @FXML
    private Label profileUsername;

    @FXML
    private Circle profileImageCircle;

    @FXML
    private ImageView profileDeleteButton;

    @FXML
    private Button profileUploadButton;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField fullNameBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private PasswordField confirmPasswordBox;

    @FXML
    private TextField emailBox;

    @FXML
    private TextField confirmEmailBox;

    @FXML
    private Button updateInfoButton;

    @FXML
    private Button contactUsButton;

    @FXML
    private void initialize() {
//        try {
//            String username = "anjana";
//            UserProfile userProfile = UserProfileManager.getUserProfile(username);
//
//            if (userProfile != null) {
//                profileName.setText(userProfile.getFullName());
//                profileUsername.setText("@" + userProfile.getUsername());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    private void handleLogoutButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            Object controller = loader.getController();

            Stage stage = new Stage();

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());

            stage.setScene(new Scene(root, bounds.getWidth(), bounds.getHeight()));

            if (controller instanceof Initializable) {
                ((Initializable) controller).initialize(null, null);
            }

            stage.show();

            Stage profileStage = (Stage) logoutButton.getScene().getWindow();
            profileStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUpdateInfoButton(ActionEvent event) {
        // Handle update info button action
        // Add your update info logic here
    }

    @FXML
    private void handleContactUsButton(ActionEvent event) {
        // Handle contact us button action
        // Add your contact us logic here
    }

    @FXML
    private void handleProfileUploadButton(ActionEvent event) {
        // Handle profile upload button action
        // Add your profile upload logic here
    }

    @FXML
    private void handleProfileDeleteButton(ActionEvent event) {
        // Handle profile delete button action
        // Add your profile delete logic here
    }
}
