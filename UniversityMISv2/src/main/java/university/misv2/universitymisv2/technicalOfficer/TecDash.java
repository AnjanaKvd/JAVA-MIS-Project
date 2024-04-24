package university.misv2.universitymisv2.technicalOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TecDash {
    @FXML
    private Stage stage ;
    private Scene scene;
    private Parent root;

    public  void goMedical(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Medical.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void gopassword(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    @FXML
//    public  void go(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }


    @FXML
    public void go(ActionEvent event) throws IOException {
        AnchorPane root = new AnchorPane(); // Create a new AnchorPane as the root element
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Attendance.fxml"));
        loader.setRoot(root); // Set the root element
        Parent parent = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}
