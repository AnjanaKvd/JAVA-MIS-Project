package university.misv2.universitymisv2.technicalOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//vewe Attendance fun
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import java.io.IOException;

public class VeweAttendance {
    @FXML
    private Stage stage ;
    private Scene scene;
    private Parent root;

    public  void goAttendance(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public  class ViewAttendance implements Initializable{
        @FXML
        private TableColumn<User, String> student_id;

        @FXML
        private TableColumn<User, String> course_code;

        @FXML
        private TableColumn<User, String> Theory_or_Practical;

        @FXML
        private TableColumn<User, java.util.Date> Date;

        @FXML
        private TableColumn<User, String> Status;

        @FXML
        private TableView<User> table;

    }
    @Override
    public void initialize (URL location,ResourceBundle resources){
        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        Theory_or_Practical.setCellValueFactory(new PropertyValueFactory<>("Theory_or_Practical"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));

        // Load the list of users from the database
        List<User> userList = User.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<User> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);
    }
}
