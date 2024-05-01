package university.misv2.universitymisv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

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
        String name = UserData.getFullName();
        String profileImage = UserData.getUserProfileImage();
        if (username != null) {
            profileUsername.setText("@"+username);
        }
        if (name != null) {
            profileName.setText(name);
        }
        if (profileImage != null) {
            Image img = new Image(profileImage);
            profileImageCircle.setFill(new ImagePattern(img));
        }
    }

    @FXML
    private void handleLogoutButton(ActionEvent event) {
        try {
            UserData.clearUserData();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());

            stage.setScene(new Scene(root, bounds.getWidth(), bounds.getHeight()));
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
            saveImage(selectedFile);
            Image img = new Image(UserData.getUserProfileImage());
            profileImageCircle.setFill(new ImagePattern(img));
        }
    }
    @FXML
    private void saveImage(File selectedImageFile) {
        Random rand = new Random();
        int fileNumber = (rand.nextInt(9000));

        String currentPath = Paths.get("").toAbsolutePath().toString();
        String defaultPath = "/profile_images/";
        String defaultRelativePath = "/profile_images/";

        String destinationDirectoryPath = currentPath+defaultPath;
        String fileName = selectedImageFile.getName();
        String destinationDirectory = destinationDirectoryPath + fileNumber + fileName;
        Path sourceFilePath = selectedImageFile.toPath();
        Path destinationFilePath = Paths.get(destinationDirectory);
        String relativePath = defaultRelativePath + fileNumber + fileName;

        try {
            Files.copy(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            UserProfileManager.setUserProfileImagePath(UserData.getLoggedInUsername(), relativePath);
            System.out.println("Success :"+ relativePath);
            UserData.setUserProfileImage(relativePath);
        } catch (IOException e) {
            System.out.println("Error Failed to copy profile picture to destination directory.");
        }
    }


    @FXML
    private void handleProfileDeleteButton(ActionEvent event) {
        // Handle profile delete button action
        // Add your profile delete logic here
    }
}