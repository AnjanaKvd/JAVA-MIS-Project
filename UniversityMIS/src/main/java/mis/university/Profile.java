package mis.university;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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
    private Button saveChangesButton;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private DatePicker dobDatePicker;

    @FXML
    private ImageView profileImageView;

    @FXML
    private VBox displayPages;

    @FXML
    private void initialize() {
        openProfilePage();
        profileBox.setOnMouseClicked(event -> openProfilePage());
        settingsBox.setOnMouseClicked(event -> openSettingsPage());
        passwordsBox.setOnMouseClicked(event -> openPasswordsPage());
        infoBox.setOnMouseClicked(event -> openInfoPage());

        editProfileButton.setOnAction(event -> updateProfileImage());
        logoutButton.setOnAction(event -> logout());
        saveChangesButton.setOnAction(event -> saveChanges());
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
    private void logout() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);

            Stage stage = (Stage) logoutButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);

            Stage stage = (Stage) logoutButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);

            Stage stage = (Stage) logoutButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveChanges() {
        try (Connection connectDB = DatabaseConnection.getConnection();
             PreparedStatement statement = connectDB.prepareStatement(
                     "UPDATE user SET first_name = ?, last_name = ?, dob = ? WHERE id = ?")) {

            statement.setString(1, firstNameTextField.getText());
            statement.setString(2, lastNameTextField.getText());
            statement.setDate(3, java.sql.Date.valueOf(dobDatePicker.getValue()));
            int userId = UserData.getUserId();
            statement.setInt(4, userId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Profile details updated successfully.");
            } else {
                System.out.println("Failed to update profile details.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateProfileImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            Image newImage = new Image(selectedFile.toURI().toString());
            profileImageView.setImage(newImage);

            Circle clip = new Circle();
            clip.setCenterX(200);
            clip.setRadius(65);
            clip.setStroke(Color.BLACK);
            profileImageView.setClip(clip);

            // Optionally, save the new image file to disk or upload it to a server
            // You can add code here to handle saving/uploading the image
        }
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
