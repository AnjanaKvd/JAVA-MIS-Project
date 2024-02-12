package mis.university;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label loginMessageLabel;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            InputStream brandingImageStream = getClass().getResourceAsStream("/images/header.jpg");
            if (brandingImageStream != null) {
                Image brandingImage = new Image(brandingImageStream);
                brandingImageView.setImage(brandingImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
             PreparedStatement statement = connectDB.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?")){

            statement.setString(1, usernameTextField.getText());
            statement.setString(2, enterPasswordField.getText());

            try (ResultSet queryResult = statement.executeQuery()) {
                if (queryResult.next() && queryResult.getInt(1) == 1) {
                    String userType = queryResult.getString("user_type");
                    openMainWindow(userType);
                } else {
                    loginMessageLabel.setText("Invalid username or password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            loginMessageLabel.setText("Error: Unable to login. Please try again later.");
        }
    }
    private void openMainWindow(String userType) {
        try {
            String fxmlPath;
            if ("admin".equals(userType)) {
                fxmlPath = "adminDashboard.fxml";
            } else if ("student".equals(userType)) {
                fxmlPath = "studentDashboard.fxml";
            } else {
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Object controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

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
