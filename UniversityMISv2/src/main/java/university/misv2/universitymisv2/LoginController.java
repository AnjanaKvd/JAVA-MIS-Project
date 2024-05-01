package university.misv2.universitymisv2;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import university.misv2.universitymisv2.UserData;


public class LoginController {

    public TextField usernameTextField;
    public PasswordField enterPasswordField;
    public Label loginMessageLabel;
    @FXML
    private ImageView closeBtn;
    @FXML
    private Button loginButton;
    private int userId;

    @FXML
    private void initialize() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.4), closeBtn);
        rotateTransition.setByAngle(360);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(1);
        closeBtn.setOnMouseEntered(event -> rotateTransition.play());
        closeBtn.setOnMouseExited(event -> rotateTransition.stop());
        closeBtn.setOnMouseExited(event -> rotateTransition.setFromAngle(0));
    }

    @FXML
    private void handleCloseButtonAction() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void loginButtonOnAction(ActionEvent event) {
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    private void validateLogin() {
        try (Connection connectDB = DatabaseConnection.getConnection();
             PreparedStatement statement = connectDB.prepareStatement("SELECT * FROM user WHERE username = ?")) {

            statement.setString(1, usernameTextField.getText());

            try (ResultSet queryResult = statement.executeQuery()) {
                if (queryResult.next()) {
                    String storedPassword = queryResult.getString("password");
                    String enteredPassword = enterPasswordField.getText();

                    String storedUsername = queryResult.getString("username");
                    String enteredUsername = usernameTextField.getText();

                    if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
                        String userType = queryResult.getString("user_type");
                        UserData.setLoggedInUsername(storedUsername);
                        openMainWindow(userType);
                    } else {
                        loginMessageLabel.setText("Invalid username or password");
                    }
                } else {
                    loginMessageLabel.setText("Username not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            loginMessageLabel.setText("Error: Unable to login. Please try again later.");
        }
    }

    private void openMainWindow(String userType) {
        UserData.setLoggedRole(userType);
        try {
            String fxmlPath;
            if ("admin".equals(userType)) {
                fxmlPath = "admin/dashboard.fxml";
            } else if ("lecturer".equals(userType)) {
                fxmlPath = "lecturer/dashboard.fxml";
            } else if ("student".equals(userType)) {
                fxmlPath = "student/TechnicalDashboard.fxml";
            } else if ("technical officer".equals(userType)) {
                fxmlPath = "technicalOfficer/TechnicalDashboard.fxml";
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

            Stage loginStage = (Stage) loginButton.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
