package mis.university;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the login screen
       /* Parent loginRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminDashboard.fxml")));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(new Scene(loginRoot, 1280, 720));
        primaryStage.setTitle("LMS Ruhuna - Login");
        primaryStage.show();*/

        // Load the lecture dashboard
        Stage lectureStage = new Stage();
        FXMLLoader lectureLoader = new FXMLLoader(getClass().getResource("lectureDashboard.fxml"));
        Parent lectureRoot = lectureLoader.load();

        lectureStage.setTitle("LMS Ruhuna - Lecture Dashboard");
        lectureStage.setScene(new Scene(lectureRoot, 1280, 720));
        lectureStage.show();


        /*Stage noticeStage = new Stage();
        FXMLLoader noticeLoader = new FXMLLoader(getClass().getResource("notice.fxml"));
        Parent noticeRoot = noticeLoader.load();
        noticeStage.setResizable(false);
        noticeStage.setTitle("LMS Ruhuna - Notice");
        noticeStage.setScene(new Scene(noticeRoot, 1280, 720));
        noticeStage.show();*/

       /* Stage courseStage = new Stage();
        FXMLLoader courseLoader = new FXMLLoader(getClass().getResource("courses.fxml"));
        Parent coueseRoot = courseLoader.load();
        courseStage.setResizable(false);
        courseStage.setTitle("LMS Ruhuna - Notice");
        courseStage.setScene(new Scene(coueseRoot, 1280, 720));
        courseStage.show();*/

        /*Stage searchStage = new Stage();
        FXMLLoader searchLoader = new FXMLLoader(getClass().getResource("search.fxml"));
        Parent searchRoot = searchLoader.load();
        searchStage.setResizable(false);
        searchStage.setTitle("LMS Ruhuna - search student");
        searchStage.setScene(new Scene(searchRoot, 1280, 720));
        searchStage.show();*/

        /*Stage upmateStage = new Stage();
        FXMLLoader upmateLoader = new FXMLLoader(getClass().getResource("uplodmaterials.fxml"));
        Parent searchRoot = upmateLoader.load();
        upmateStage.setResizable(false);
        upmateStage.setTitle("LMS Ruhuna - search student");
        upmateStage.setScene(new Scene(searchRoot, 1280, 720));
        upmateStage.show();*/
    }



}
