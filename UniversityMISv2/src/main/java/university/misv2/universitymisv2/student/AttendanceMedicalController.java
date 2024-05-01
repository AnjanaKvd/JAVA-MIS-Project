package university.misv2.universitymisv2.student;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> 6738ea658a1898f11e78f5cefef821f8f2f2f939
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AttendanceMedicalController implements Initializable {

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
    private TableView<AmUser> table;

    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        start_date.setCellValueFactory(new PropertyValueFactory<>("start_date"));
        end_date.setCellValueFactory(new PropertyValueFactory<>("end_date"));
        is_day_medical.setCellValueFactory(new PropertyValueFactory<>("is_day_medical"));
        submitted_date.setCellValueFactory(new PropertyValueFactory<>("submitted_date"));

<<<<<<< HEAD
//
=======

>>>>>>> 6738ea658a1898f11e78f5cefef821f8f2f2f939
        // Load the list of users from the database
//        List<AmUser> amuser = null;
//        try {
//            amuser = AmUser.fetchAllUsers();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        // Convert the list to an ObservableList
//        ObservableList<AmUser> observableAmList = FXCollections.observableArrayList(amuser);
//
//        // Set the data in the table
//        table.setItems(observableAmList);
//    }
        List<AmUser> userList = AmUser.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<AmUser> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);

    }
}