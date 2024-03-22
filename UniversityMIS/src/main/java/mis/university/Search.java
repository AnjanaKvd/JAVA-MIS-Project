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

public class Search {
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


    public void buttonClick(){
        System.out.println("The button is first button..");
    }


    public void buttonClick1(){
        System.out.println("The button is second button..");
    }


    public  void gotopage2(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("lectureDashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void submit(ActionEvent event){
        age=Integer.parseInt(mytextfield.getText());
        System.out.println(age);
    }

}