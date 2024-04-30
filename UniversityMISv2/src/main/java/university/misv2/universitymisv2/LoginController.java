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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    private Circle imagecircle;


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
             PreparedStatement statement = connectDB.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?")) {

            statement.setString(1, usernameTextField.getText());
            statement.setString(2, enterPasswordField.getText());

            try (ResultSet queryResult = statement.executeQuery()) {
                if (queryResult.next() && queryResult.getInt(1) == 1) {
                    String userType = queryResult.getString("user_type");
                    userId = queryResult.getInt("id");
                    openMainWindow(userType, userId);
                } else {
                    loginMessageLabel.setText("Invalid username or password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            loginMessageLabel.setText("Error: Unable to login. Please try again later.");
        }
    }

    private void openMainWindow(String userType, int userId) {
        try {
            String fxmlPath;
            if ("admin".equals(userType)) {
                fxmlPath = "admin/dashboard.fxml";
            } else if ("lecturer".equals(userType)) {
                fxmlPath = "lecturer/dashboard.fxml";
            } else {
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Object controller = loader.getController();
            UserData.setUserId(userId);

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

            Stage loginStage = (Stage) loginButton.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
