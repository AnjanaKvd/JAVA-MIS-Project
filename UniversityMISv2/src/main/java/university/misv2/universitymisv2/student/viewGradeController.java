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

public class viewGradeController implements Initializable {


        @FXML
        private TableColumn<GradeUser, String> course_code;

        @FXML
        private TableColumn<GradeUser, Integer> end_marks;

        @FXML
        private TableColumn<GradeUser, Integer> mid_marks;

        @FXML
        private TableColumn<GradeUser, Integer> project_marks;

        @FXML
        private TableColumn<GradeUser, Integer> quiz1_marks;

        @FXML
        private TableColumn<GradeUser, Integer> quiz2_marks;

        @FXML
        private TableColumn<GradeUser, Integer> quiz3_marks;

        @FXML
        private TableColumn<GradeUser, String> student_id;

        @FXML
        private TableView<GradeUser> table;


        @FXML
        private TableColumn<GPAUser, String> CGPA;

        @FXML
        private TableColumn<GPAUser, String> SGPA;


//        @FXML
//        private TableColumn<GPAUser, String> student_id1;


        @FXML
        private TableView<GPAUser> table1;








    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the CourseUser class
        course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        quiz1_marks.setCellValueFactory(new PropertyValueFactory<>("quiz1_marks"));
        quiz2_marks.setCellValueFactory(new PropertyValueFactory<>("quiz2_marks"));
        quiz3_marks.setCellValueFactory(new PropertyValueFactory<>("quiz3_marks"));
        mid_marks.setCellValueFactory(new PropertyValueFactory<>("mid_marks"));
        project_marks.setCellValueFactory(new PropertyValueFactory<>("project_marks"));
        end_marks.setCellValueFactory(new PropertyValueFactory<>("end_marks"));





        List<GradeUser> userList = GradeUser.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<GradeUser> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);


        //GPA User

//        List<GPAUser> userList1 = GPAUser.fetchAllUsers();
//
//        // Convert the list to an ObservableList
//        ObservableList<GPAUser> observableUserList1 = FXCollections.observableArrayList(userList1);
//
//        // Set the data in the table
//        table1.setItems(observableUserList1);

       // student_id1.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        SGPA.setCellValueFactory(new PropertyValueFactory<>("SGPA"));
        CGPA.setCellValueFactory(new PropertyValueFactory<>("CGPA"));

        // Load the list of users from the database
        List<GPAUser> gpauser = null;
        gpauser = GPAUser.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<GPAUser> observableAmList1 = FXCollections.observableArrayList(gpauser);

        // Set the data in the table
        table1.setItems(observableAmList1);

    }
}



