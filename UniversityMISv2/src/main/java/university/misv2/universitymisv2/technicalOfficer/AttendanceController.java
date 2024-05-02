package university.misv2.universitymisv2.technicalOfficer;

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

public class AttendanceController implements Initializable {
    @FXML
    private TableColumn<AttendanceQuery, String> id;

    @FXML
    private TableColumn<AttendanceQuery, Integer> student_id;


    @FXML
    private TableColumn<AttendanceQuery, String> Course_code;

    @FXML
    private TableColumn<AttendanceQuery, String> Date;

    @FXML
    private TableColumn<AttendanceQuery, String> Theory_or_practical;

    @FXML
    private TableColumn<AttendanceQuery, String> Status;
    @FXML
    private TableView<AttendanceQuery> table;

    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        Course_code.setCellValueFactory(new PropertyValueFactory<>("Course_code"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Theory_or_practical.setCellValueFactory(new PropertyValueFactory<>("Theory_or_practical"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));


        List<AttendanceQuery> userList = AttendanceQuery.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<AttendanceQuery> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);

    }
}
