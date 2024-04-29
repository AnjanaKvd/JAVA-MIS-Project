package university.misv2.universitymisv2.lecturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class LecturerController implements Initializable {
    public Button RegisterButton;
    public Button updateProfile;
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

    @FXML
    private Pane pane;

    @FXML
    private Pane uplode_marks;

    @FXML
    private Pane update_course;

    @FXML
    private Pane student_details;

    @FXML
    private Pane notification;

    @FXML
    private Pane marks_grade_gpa;

    @FXML
    private Pane eligibility;

    @FXML
    private Pane Attendance_medical;

    @FXML
    private BorderPane boarderPane;

    @FXML
    private Button addMaterials;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File branding=new File("src/main/resources/university/misv2/universitymisv2/images/Lecturer.png");
        Image UpdateImage=new Image(branding.toURI().toString());
        shieldimageView.setImage(UpdateImage);

    }




//    public void RegisterButtonOnAction(ActionEvent event) throws SQLException {
//
//        if(!FirstnameTextField.getText().isEmpty() && !LastnameTextField.getText().isEmpty() && !UsernameTextFiels.getText().isEmpty() &&
//                !SetPasswordField.getText().isEmpty() && !ConfirmPasswordFiels.getText().isEmpty()){
//
//            if(SetPasswordField.getText().equals(ConfirmPasswordFiels.getText())){
//                registerUser();
//                conPasswordMessageLable1.setText("");
//            }else{
//                conPasswordMessageLable1.setText("password not match");
//            }
//
//
//        } else{
//            registationMessageLable.setText("Register fail");
//        }
//    }

//    private void registerUser() {
//
//    }





    public void cancleButtononAction(ActionEvent event){
        Stage stage=(Stage) CloseButton.getScene().getWindow();
        stage.close();


    }




    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) CloseButton.getScene().getWindow();
        stage.close();
    }




    @FXML
    void UplodeMarks(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("uploadMarks.fxml")));
        boarderPane.setCenter(root);

    }

    @FXML
    void attendanceMedical(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attendanceMedical.fxml")));
        boarderPane.setCenter(root);
    }


    @FXML
    void eligibilityClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("eligibility.fxml")));
        boarderPane.setCenter(root);

    }

    @FXML
    void mggpaClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mggpa.fxml")));
        boarderPane.setCenter(root);


    }

    @FXML
    void noticeClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("notice.fxml")));
        boarderPane.setCenter(root);

    }

    @FXML
    void registerUser(ActionEvent event) throws SQLException, IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("updateCourse.fxml")));
        boarderPane.setCenter(root);

    }

    @FXML
    void viewtabledata(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("showdata.fxml")));
        boarderPane.setCenter(root);


    }

    public void profileButtonOnAction(ActionEvent event) {
        try {
            URL resourceUrl = getClass().getResource("/university/misv2/universitymisv2/Profile.fxml");
            if (resourceUrl == null) {
                System.err.println("Error: Profile.fxml not found");
                return;
            }

            FXMLLoader loader = new FXMLLoader(resourceUrl);
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

            Stage dashboardStage = (Stage) updateProfile.getScene().getWindow();
            dashboardStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addmaterialsClick(ActionEvent event) throws IOException {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
//                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
//                new FileChooser.ExtensionFilter("All Files", "*.*"));
//        File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
//        if (selectedFile != null) {
//            // Handle the selected file, e.g., display it
//            // For demonstration, let's print the file path
//            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
//        }


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addmaterials.fxml")));
        boarderPane.setCenter(root);
    }
}
