package university.misv2.universitymisv2.technicalOfficer;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import university.misv2.universitymisv2.UserData;
import university.misv2.universitymisv2.UserProfileManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TechnicalOfficerDashboard implements Initializable {


    public ImageView closeBtn;
    public Label userFullName;
    public Circle profileIconCircle;
    public Button updateprofile;
    @FXML
    private Button buttonclick;
    @FXML
    private Button buttonclick2;
    @FXML
    private Button buttonclick3;

    private  Button buttonclick5;

    @FXML
    private Button buttonclick4;

    @FXML
    private Button CloseButton;

    @FXML
    private BorderPane boarderPane;
    @FXML
    private ImageView studentimage;

    @FXML
    private ImageView studentsimage;


    @FXML
    private ImageView user1;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        File branding=new File("C:\\Users\\iTEC\\Desktop\\Java\\JAVA-MIS-Project\\UniversityMISv2\\src\\main\\resources\\university\\misv2\\universitymisv2\\technicalOfficer\\images\\Student.png");
//        Image UpdateImage=new Image(branding.toURI().toString());
//        studentimage.setImage(UpdateImage);
//        File college=new File("C:\\Users\\iTEC\\Desktop\\Java\\JAVA-MIS-Project\\UniversityMISv2\\src\\main\\resources\\university\\misv2\\universitymisv2\\technicalOfficer\\images\\College Students.png");
//        Image UpdateImages=new Image(college.toURI().toString());
//        studentsimage.setImage(UpdateImages);
//        File profilepic=new File("C:\\Users\\iTEC\\Desktop\\Java\\JAVA-MIS-Project\\UniversityMISv2\\src\\main\\resources\\university\\misv2\\universitymisv2\\technicalOfficer\\images\\Users.png");
//        Image UpdateImages2=new Image(profilepic.toURI().toString());
//        user1.setImage(UpdateImages2);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.4), closeBtn);
        rotateTransition.setByAngle(360);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(1);
        closeBtn.setOnMouseEntered(event -> rotateTransition.play());
        closeBtn.setOnMouseExited(event -> rotateTransition.stop());
        closeBtn.setOnMouseExited(event -> rotateTransition.setFromAngle(0));

        String loggedInUsername = UserData.getLoggedInUsername();
        if (loggedInUsername != null) {
            updateUserDetails(loggedInUsername);
        }

    }
    private void updateUserDetails(String username) {
        String fullName = UserProfileManager.getUserFullName(username);
        UserData.setFullName(fullName);
        userFullName.setText(fullName);

        String profileImagePath = UserProfileManager.getUserProfileImagePath(username);
        UserData.setUserProfileImage(profileImagePath);

        Image newImage = new Image(profileImagePath);
        profileIconCircle.setFill(new ImagePattern(newImage));
    }

    @FXML
    private void handleCloseButtonAction() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

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

    @FXML
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) CloseButton.getScene().getWindow();
        stage.close();


    }

    @FXML
    void viewNotices(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ShowNotices.fxml"));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewTimetable(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ShowTimetable.fxml"));
        boarderPane.setCenter(root);
    }

    @FXML
    void updateattendance(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("updateattendance.fxml"));
        boarderPane.setCenter(root);
    }

    @FXML
    void Medical (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("medical.fxml"));
        boarderPane.setCenter(root);
    }

    }

