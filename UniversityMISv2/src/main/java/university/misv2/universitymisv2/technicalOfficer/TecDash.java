package university.misv2.universitymisv2.technicalOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TecDash {
    @FXML
    private Stage stage ;
    private Scene scene;
    private Parent root;
    public  void ButtonClick(){
        System.out.println("Button click..........");
    }
    public  void goMedical(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Medical.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
