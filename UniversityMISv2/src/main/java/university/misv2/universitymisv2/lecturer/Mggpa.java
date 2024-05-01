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
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;

public class Mggpa implements Initializable {

    @FXML
    private TableColumn<String, MggpaData> CGPA1;

    @FXML
    private TableColumn<String,MggpaData> student_id;

    @FXML
    private TableColumn<String,MggpaData> SGPA;


    @FXML
    private TableView<MggpaData> table;




    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        SGPA.setCellValueFactory(new PropertyValueFactory<>("SGPA"));
        CGPA1.setCellValueFactory(new PropertyValueFactory<>("CGPA"));




        // Load the list of users from the database
        List<MggpaData> mggpa = null;
        try {
            mggpa = MggpaData.fetchAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Convert the list to an ObservableList
        ObservableList<MggpaData> observableAmList = FXCollections.observableArrayList(mggpa);

        // Set the data in the table
        table.setItems(observableAmList);
    }
}
