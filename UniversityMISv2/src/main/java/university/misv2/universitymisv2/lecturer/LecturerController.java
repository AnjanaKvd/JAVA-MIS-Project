package university.misv2.universitymisv2.lecturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class LecturerController implements Initializable {
    public Button RegisterButton;
    @FXML
    private TextField FirstnameTextField;

    @FXML
    private TextField LastnameTextField;

    @FXML
    private TextField UsernameTextFiels;

    @FXML
    private PasswordField SetPasswordField;

    @FXML
    private PasswordField ConfirmPasswordFiels;

    @FXML
    private Button attendanceandmedicalField;

    @FXML
    private Button CloseButton;

    @FXML
    private Label registationMessageLable;

    @FXML
    private Label conPasswordMessageLable1;

    @FXML
    private ImageView shieldimageView;

    @FXML
    private Button checkButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File branding=new File("images/User.png");
        Image UpdateImage=new Image(branding.toURI().toString());
        shieldimageView.setImage(UpdateImage);
    }



    public void RegisterButtonOnAction(ActionEvent event) throws SQLException {

        if(!FirstnameTextField.getText().isEmpty() && !LastnameTextField.getText().isEmpty() && !UsernameTextFiels.getText().isEmpty() &&
                !SetPasswordField.getText().isEmpty() && !ConfirmPasswordFiels.getText().isEmpty()){

            if(SetPasswordField.getText().equals(ConfirmPasswordFiels.getText())){
                registerUser();
                conPasswordMessageLable1.setText("");
            }else{
                conPasswordMessageLable1.setText("password not match");
            }


        } else{
            registationMessageLable.setText("Register fail");
        }




    }

    public void cancleButtononAction(ActionEvent event){
        Stage stage=(Stage) CloseButton.getScene().getWindow();
        stage.close();


    }

    public  void  registerUser() throws SQLException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("updateCourse.fxml")));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 520, 523));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    public void viewtabledata() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("showdata.fxml")));

            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 900, 485));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    public void attendanceMedical() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attendanceMedical.fxml")));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 802, 537));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    public void UplodeMarks() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("uploadMarks.fxml")));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 520, 677));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }



    public void noticeClick() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("notice.fxml")));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }


    public void eligibilityClick() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("eligibility.fxml")));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    public void mggpaClick() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mggpa.fxml")));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 600, 400));
            registerStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }


    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) CloseButton.getScene().getWindow();
        stage.close();
    }
}
