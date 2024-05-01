package university.misv2.universitymisv2.lecturer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import university.misv2.universitymisv2.student.AmUser;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AttendanceMedical implements Initializable {

    @FXML
    private TableColumn<Date, AmUser> end_date;

    @FXML
    private TableColumn<Integer, AmUser> id;

    @FXML
    private TableColumn<String, AmUser> is_day_medical;

    @FXML
    private TableColumn<String, AmUser> reason;

    @FXML
    private TableColumn<Date, AmUser> start_date;

    @FXML
    private TableColumn<Date, AmUser> submitted_date;



    @FXML
    private TableColumn<String, Attendance> student_id;

    @FXML
    private TableColumn<String, Attendance> course_code;

    @FXML
    private TableColumn<String, Attendance> Theory_or_Practical;

    @FXML
    private TableColumn<String, Attendance> Status;

    @FXML
    private TableColumn<Date, Attendance> Date;





    @FXML
    private TableView<Attendance> tabletwo;

    @FXML
    private TableView<AmUser> table;

    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        start_date.setCellValueFactory(new PropertyValueFactory<>("start_date"));
        end_date.setCellValueFactory(new PropertyValueFactory<>("end_date"));
        is_day_medical.setCellValueFactory(new PropertyValueFactory<>("is_day_medical"));
        submitted_date.setCellValueFactory(new PropertyValueFactory<>("submitted_date"));


        // Load the list of users from the database
        List<AmUser> amuser = null;
        amuser = AmUser.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<AmUser> observableAmList = FXCollections.observableArrayList(amuser);

        // Set the data in the table
        table.setItems(observableAmList);




        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        Theory_or_Practical.setCellValueFactory(new PropertyValueFactory<>("Theory_or_Practical"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));




        // Load the list of users from the database
        List<Attendance> attendances = null;
        try {
            attendances = Attendance.fetchAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Convert the list to an ObservableList
        ObservableList<Attendance> observableAmListAtt = FXCollections.observableArrayList(attendances);

        // Set the data in the table
        tabletwo.setItems(observableAmListAtt);
    }
    }









