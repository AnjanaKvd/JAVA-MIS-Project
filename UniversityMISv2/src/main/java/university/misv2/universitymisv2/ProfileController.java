package university.misv2.universitymisv2;

import javafx.animation.RotateTransition;
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
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Random;

import java.awt.Desktop;

public class ProfileController {

    public ImageView profileImageView;
    public Label updateDetailsLabel;
    public ImageView closeBtn;
    public Button profileBackButton;
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

    public void initialize(){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.4), closeBtn);
        rotateTransition.setByAngle(360);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(1);
        closeBtn.setOnMouseEntered(event -> rotateTransition.play());
        closeBtn.setOnMouseExited(event -> rotateTransition.stop());
        closeBtn.setOnMouseExited(event -> rotateTransition.setFromAngle(0));

        String username = UserData.getLoggedInUsername();
        String name = UserData.getFullName();
        String profileImage = UserProfileManager.getUserProfileImagePath(username);
        UserData.setUserProfileImage(profileImage);
        String email = UserProfileManager.getUserEmail(username);

        profileUsername.setText("@"+username);
        usernameBox.setText(username);
        if (name != null) {
            profileName.setText(name);
            fullNameBox.setText(name);
        }
        if (email != null) {
            emailBox.setText(email);
            confirmEmailBox.setText(email);
        }
        Image profileImg = new Image(profileImage);
        profileImageCircle.setFill(new ImagePattern(profileImg));



        profileDeleteButton.setOnMouseClicked(event -> {
            try {
                handleProfileDeleteButton();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void handleCloseButtonAction() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
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
        String fullName = fullNameBox.getText();
        String newUsername = usernameBox.getText();
        String password = passwordBox.getText();
        String confirmPassword = confirmPasswordBox.getText();
        String email = emailBox.getText();
        String confirmEmail = confirmEmailBox.getText();

        if (Objects.equals(password, confirmPassword)) {
            if(Objects.equals(email, confirmEmail)){
                String response = UserProfileManager.modifyUserDetails(UserData.getLoggedInUsername(), newUsername, fullName, password, email);
                updateDetailsLabel.setText(response);
            }else{
                updateDetailsLabel.setText("Email addresses are not matching");
            }
        }else{
            updateDetailsLabel.setText("Passwords are not matching");
        }
    }

    @FXML
    private void handleContactUsButton(ActionEvent event) {
        String emailAddress = "customersupport@teclms.com";
        String subject = "Customer Support Inquiry";

        try {
            String uriString = String.format("mailto:%s?subject=%s",
                    URLEncoder.encode(emailAddress, "UTF-8"),
                    URLEncoder.encode(subject, "UTF-8"));

            URI uri = new URI(uriString);

            Desktop.getDesktop().mail(uri);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleProfileUploadButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg")
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

        String destinationDirectoryPath = currentPath+defaultPath;
        String fileName = selectedImageFile.getName();
        Path sourceFilePath = selectedImageFile.toPath();
        Path destinationFilePath = Paths.get(destinationDirectoryPath).resolve(String.valueOf(fileNumber+fileName));

        try {
            Files.copy(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            UserProfileManager.setUserProfileImagePath(UserData.getLoggedInUsername(), destinationFilePath.toString());
            System.out.println("Success :"+ destinationFilePath);
            UserData.setUserProfileImage(destinationFilePath.toString());
        } catch (IOException e) {
            System.out.println("Error Failed to copy profile picture to destination directory.");
        }
    }


    @FXML
    private void handleProfileDeleteButton() throws IOException {
        UserProfileManager.setUserProfileImagePath(UserData.getLoggedInUsername(), null);
        Path path = Paths.get(UserData.getUserProfileImage());
        String fileName = path.getFileName().toString();
        if (!fileName.equals("profile-default.jpeg")){
            Files.delete(path);
        }
        String imagePath = UserProfileManager.getUserProfileImagePath(UserData.getLoggedInUsername());
        UserData.setUserProfileImage(imagePath);
        profileImageCircle.setFill(new ImagePattern(new Image(imagePath)));

    }
    @FXML
    private void handleBackButton(ActionEvent event) {
        String userType = UserData.getLoggedRole();
        try {
            String fxmlPath;
            if ("admin".equals(userType)) {
                fxmlPath = "admin/dashboard.fxml";
            } else if ("lecturer".equals(userType)) {
                fxmlPath = "lecturer/dashboard.fxml";
            } else if ("student".equals(userType)) {
                fxmlPath = "student/StudentDashboard.fxml";
            } else if ("technical officer".equals(userType)) {
                fxmlPath = "technicalOfficer/TechnicalOfficerDashboard.fxml";
            }else{
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());

            stage.setScene(new Scene(root, bounds.getWidth(), bounds.getHeight()));
            stage.show();

            Stage loginStage = (Stage) profileBackButton.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
