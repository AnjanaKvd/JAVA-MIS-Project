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
import java.util.Date;
=======
>>>>>>> 6738ea658a1898f11e78f5cefef821f8f2f2f939
import java.util.List;
import java.util.ResourceBundle;

public class viewCourseDetailsController implements Initializable {

    @FXML
    private TableView<CourseUser> table;
    @FXML
    private TableColumn<String, CourseUser> code;

    @FXML
    private TableColumn<String, CourseUser> name;

    @FXML
    private TableColumn<Integer, CourseUser> credits;

    @FXML
    private TableColumn<String, CourseUser> gpa_or_ngpa;

//    @FXML
//    private TableColumn<Integer, CourseUser> department;
//
//    @FXML
//    private TableColumn<Integer, CourseUser> no_of_quiz;
//
    @FXML
    private TableColumn<String, CourseUser> is_mid;
//
//    @FXML
//    private TableColumn<Integer, CourseUser> mid_marks;
//
    @FXML
    private TableColumn<String, CourseUser> is_project;

//    @FXML
//    private TableColumn<Integer, CourseUser> project_marks;
//
    @FXML
    private TableColumn<String, CourseUser> theory_or_practical;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the CourseUser class
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        credits.setCellValueFactory(new PropertyValueFactory<>("credits"));
        gpa_or_ngpa.setCellValueFactory(new PropertyValueFactory<>("gpa_or_ngpa"));
        is_mid.setCellValueFactory(new PropertyValueFactory<>("is_mid"));
        is_project.setCellValueFactory(new PropertyValueFactory<>("is_project"));
        theory_or_practical.setCellValueFactory(new PropertyValueFactory<>("theory_or_practical"));


        List<CourseUser> userList = CourseUser.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<CourseUser> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);
    }
}



