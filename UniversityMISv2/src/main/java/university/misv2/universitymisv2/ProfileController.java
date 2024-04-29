package university.misv2.universitymisv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

public class ProfileController {

    public ImageView profileImageView;
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
        String username = UserData.getLoggedInUsername();
        System.out.println(username);
        if (username != null) {
            profileName.setText(UserData.getFullName());
            profileUsername.setText("@" + username);
        }
//        String imagePath = UserProfileManager.getUserProfileImagePath(username);
//        UserData.setUserProfileImage(imagePath);
//        Image newImage = new Image(UserData.getUserProfileImage());
//        profileImageCircle.setFill(new ImagePattern(newImage));
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            String uploadDirectory = "/university/misv2/universitymisv2/images/profile_images/";
            File uploadDir = new File(uploadDirectory);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            File destinationFile = new File(uploadDir, selectedFile.getName());
            try {
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                String imagePath = uploadDirectory + selectedFile.getName();
                UserProfileManager.setUserProfileImagePath(UserData.getLoggedInUsername(), imagePath);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle file copying error
            }
        }
    }

    @FXML
    private void handleProfileDeleteButton(ActionEvent event) {
        // Handle profile delete button action
        // Add your profile delete logic here
    }
}
