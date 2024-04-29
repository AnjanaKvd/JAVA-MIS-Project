package university.misv2.universitymisv2.student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.SEAGREEN;

public class StudentDashboardControler implements Initializable {


    @FXML
    private Button buttonclick;
    @FXML
    private Button buttonclick2;
    @FXML
    private Button buttonclick3;

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
    private Circle user1;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File branding=new File("C:\\Users\\iTEC\\Desktop\\Java\\JAVA-MIS-Project\\UniversityMISv2\\src\\main\\resources\\university\\misv2\\universitymisv2\\student\\images\\Student.png");
        Image UpdateImage=new Image(branding.toURI().toString());
        studentimage.setImage(UpdateImage);
        File college=new File("C:\\Users\\iTEC\\Desktop\\Java\\JAVA-MIS-Project\\UniversityMISv2\\src\\main\\resources\\university\\misv2\\universitymisv2\\student\\images\\College Students.png");
        Image UpdateImages=new Image(college.toURI().toString());
        studentsimage.setImage(UpdateImages);
        user1.setStroke(Color.SEAGREEN);
        Image im =new Image("C:\\Users\\iTEC\\Desktop\\Java\\JAVA-MIS-Project\\UniversityMISv2\\src\\main\\resources\\university\\misv2\\universitymisv2\\student\\images\\girl.png",false);
        user1.setFill(new ImagePattern(im));
        user1.setEffect( new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));

    }

    @FXML
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) CloseButton.getScene().getWindow();
        stage.close();


    }

    @FXML
    void viewAttendance(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewAttendance.fxml"));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewAttendancemedical(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AttendanceMedical.fxml"));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewCourseDetails(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewCourseDetails.fxml"));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewNotices(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewNotices.fxml"));
        boarderPane.setCenter(root);
    }

    @FXML
    void viewTimetable(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewTimetable.fxml"));
        boarderPane.setCenter(root);
    }

    @FXML
    void view_Grades(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewGrade.fxml"));
        boarderPane.setCenter(root);
    }




    }

