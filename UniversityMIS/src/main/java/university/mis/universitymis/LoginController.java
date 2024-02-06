package university.mis.universitymis;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField usernameTextFeild;
    @FXML
    private PasswordField enterPasswordFeild;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("../../images/header.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }

    private void loginButtonOnAction(ActionEvent event) {
        if(usernameTextFeild.getText().isBlank() == false && enterPasswordFeild.getText().isBlank() == false){
            validateLogin();
        }else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }
}

