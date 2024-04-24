package university.misv2.universitymisv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("technicalOfficer/tec dash.fxml")));
=======
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("lecturer/dashboard.fxml")));
>>>>>>> abb5d291856b122fbc06817689448a9ea71618d1
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setScene(new Scene(root, bounds.getWidth(), bounds.getHeight()));
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
