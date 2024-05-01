package university.misv2.universitymisv2.student;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import university.misv2.universitymisv2.UserData;
import university.misv2.universitymisv2.UserProfileManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentDashboardControler implements Initializable {


    public Label userFullNameLabel;
    @FXML
    private Button buttonclick;
    @FXML
    private Button buttonclick2;
    @FXML
    private Button buttonclick3;

    @FXML
    private Button buttonclick4;

    @FXML
    private Button updateprofile;


    @FXML
    private ImageView CloseButton;

    @FXML
    private BorderPane boarderPane;
    @FXML
    private ImageView studentimage;

    @FXML
    private ImageView studentsimage;

    @FXML
    private Button Logout;

    @FXML
    private Circle user1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        File branding=new File(String.valueOf(getClass().getResource("/university/misv2/universitymisv2/images/Student.png")));
//        Image UpdateImage=new Image(branding.toURI().toString());
//        studentimage.setImage(UpdateImage);
//        File college=new File(String.valueOf(getClass().getResource("/university/misv2/universitymisv2/student/images/CollegeStudents.png")));
//        Image UpdateImages=new Image(college.toURI().toString());
//        studentsimage.setImage(UpdateImages);
//        File profilepic=new File(String.valueOf(getClass().getResource("/university/misv2/universitymisv2/student/images/studentuser.jpg")));
//        Image UpdateImages2=new Image(profilepic.toURI().toString());
//        user1.setFill(new ImagePattern(UpdateImages2));

//close button rotate
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.4), CloseButton);
        rotateTransition.setByAngle(360);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(1);
        CloseButton.setOnMouseEntered(event -> rotateTransition.play());
        CloseButton.setOnMouseExited(event -> rotateTransition.stop());
        CloseButton.setOnMouseExited(event -> rotateTransition.setFromAngle(0));

        String loggedInUsername = UserData.getLoggedInUsername();
        if (loggedInUsername != null) {
            updateUserDetails(loggedInUsername);
        }

    }

    private void updateUserDetails(String username) {
        String fullName = UserProfileManager.getUserFullName(username);
        UserData.setFullName(fullName);
        userFullNameLabel.setText(fullName);

        String profileImagePath = UserProfileManager.getUserProfileImagePath(username);
        UserData.setUserProfileImage(profileImagePath);

        Image newImage = new Image(profileImagePath);
        user1.setFill(new ImagePattern(newImage));
    }

    @FXML
    public void cancelButtonOnAction(MouseEvent event){
        Stage stage = (Stage) CloseButton.getScene().getWindow();
        stage.close();


    }

    @FXML
    void viewAttendance(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewAttendance.fxml")));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewAttendancemedical(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AttendanceMedical.fxml")));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewCourseDetails(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewCourseDetails.fxml")));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewNotices(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewNotices.fxml")));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewTimetable(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewTimetable.fxml")));
        boarderPane.setCenter(root);
    }

    @FXML
    void view_Grades(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewGrade.fxml")));
        boarderPane.setCenter(root);
    }


//    void profile_update(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
//        boarderPane.setCenter(root);
//    }
    public void profile_update(ActionEvent event) {
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

            Stage dashboardStage = (Stage) updateprofile.getScene().getWindow();
            dashboardStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    }

