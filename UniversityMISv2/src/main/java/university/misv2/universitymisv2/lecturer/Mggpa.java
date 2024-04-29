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
import java.util.List;
import java.util.ResourceBundle;

public class Mggpa implements Initializable {

    @FXML
    private TableColumn<Integer, MggpaData> ca_mark;

    @FXML
    private TableColumn<String, MggpaData> course_code;

    @FXML
    private TableColumn<Integer, MggpaData> end_mark;

    @FXML
    private TableColumn<String, MggpaData> gpa;

    @FXML
    private TableColumn<Character,MggpaData> grade;

    @FXML
    private TableColumn<String,MggpaData > student_id;

    @FXML
    private TableView<MggpaData> table;

    @FXML
    private TableColumn<Integer, MggpaData> total_marks;


    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        ca_mark.setCellValueFactory(new PropertyValueFactory<>("ca_mark"));
        end_mark.setCellValueFactory(new PropertyValueFactory<>("end_mark"));
        total_marks.setCellValueFactory(new PropertyValueFactory<>("total_marks"));
        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        //gpa.setCellValueFactory(new PropertyValueFactory<>("grade"));



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
