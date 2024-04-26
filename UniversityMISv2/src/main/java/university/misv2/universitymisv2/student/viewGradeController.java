package university.misv2.universitymisv2.student;


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
    }
}



