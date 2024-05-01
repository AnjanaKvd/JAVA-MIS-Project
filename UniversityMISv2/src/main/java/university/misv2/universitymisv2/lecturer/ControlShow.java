package university.misv2.universitymisv2.lecturer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControlShow implements Initializable {

    @FXML
    private TableColumn<String, User> acedamic_status;

    @FXML
    private TableColumn<String, User> address;

    @FXML
    private TableColumn<Character, User> batch_year;

    @FXML
    private TableColumn<Date, User> date_of_birth;

    @FXML
    private TableColumn<Integer, User> department_id;

    @FXML
    private TableColumn<String, User> student_id;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<Integer, User> user_id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        acedamic_status.setCellValueFactory(new PropertyValueFactory<>("acedamic_status"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        batch_year.setCellValueFactory(new PropertyValueFactory<>("batch_year"));
        date_of_birth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        department_id.setCellValueFactory(new PropertyValueFactory<>("department_id"));
        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));



        // Load the list of users from the database
        List<User> userList = null;
        try {
            userList = User.fetchAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Convert the list to an ObservableList
        ObservableList<User> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);
    }

}
