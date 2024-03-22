package mis.university;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Courses {
    @FXML
    private Label welcomeText;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label mylable;

    @FXML
    private TextField mytextfield;

    @FXML
    private Button myboutton;

    int age;

    public void course(ActionEvent event){
        age=Integer.parseInt(mytextfield.getText());
        System.out.println(age);
    }

    public void materials(ActionEvent event){
        age=Integer.parseInt(mytextfield.getText());
        System.out.println(age);
    }
}
