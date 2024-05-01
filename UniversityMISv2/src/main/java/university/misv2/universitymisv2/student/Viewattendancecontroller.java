
package university.misv2.universitymisv2.student;
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

public class Viewattendancecontroller implements Initializable {

   @FXML
     private TableColumn<User, java.util.Date> Date;

    @FXML
    private TableColumn<User, String> Status;

    @FXML
    private TableColumn<User, String> Theory_or_Practical;

    @FXML
    private TableColumn<User, String> course_code;

    @FXML
    private TableColumn<User,Integer> id;

    @FXML
    private TableColumn<User, String> student_id;

    @FXML
    private TableView<User> table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Theory_or_Practical.setCellValueFactory(new PropertyValueFactory<>("Theory_or_Practical"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));

        // Load the list of users from the database
        List<User> userList = User.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<User> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);
    }

}

