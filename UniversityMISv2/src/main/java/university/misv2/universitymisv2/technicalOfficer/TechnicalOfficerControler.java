package university.misv2.universitymisv2.technicalOfficer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TechnicalOfficerControler implements Initializable {


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

    }

    @FXML
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) CloseButton.getScene().getWindow();
        stage.close();


    }

    @FXML
    private void medical(ActionEvent event) {
        // Your implementation here
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

