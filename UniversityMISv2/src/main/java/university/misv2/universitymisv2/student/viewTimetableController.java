package university.misv2.universitymisv2.student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;
public class viewTimetableController implements  Initializable {

    @FXML
    private TableColumn<TimeUser, String> classroom;

    @FXML
    private TableColumn<TimeUser, String> course_code;

    @FXML
    private TableColumn<TimeUser, String> course_name;

    @FXML
    private TableColumn<TimeUser, String> day_of_week;

    @FXML
    private TableColumn<TimeUser, Time> end_time;

    @FXML
    private TableColumn<TimeUser, String> lecturer;

    @FXML
    private TableColumn<TimeUser, String> start_time;

    @FXML
    private TableView<TimeUser> table;

    @FXML
    private TableColumn<TimeUser, String> timetable_id;

    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        timetable_id.setCellValueFactory(new PropertyValueFactory<>("timetable_id"));
        course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        course_name.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        lecturer.setCellValueFactory(new PropertyValueFactory<>("lecturer"));
        classroom.setCellValueFactory(new PropertyValueFactory<>("classroom"));
        day_of_week.setCellValueFactory(new PropertyValueFactory<>("day_of_week"));
        start_time.setCellValueFactory(new PropertyValueFactory<>("start_time"));
        end_time.setCellValueFactory(new PropertyValueFactory<>("end_time"));


        List<TimeUser> userList = TimeUser.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<TimeUser> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);

    }





}
