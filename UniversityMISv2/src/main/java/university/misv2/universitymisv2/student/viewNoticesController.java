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
public class viewNoticesController implements  Initializable {

        @FXML
        private TableColumn<NoticeUser, String> date_time;

        @FXML
        private TableColumn<NoticeUser, Integer> id;

        @FXML
        private TableColumn<NoticeUser, String> message;

        @FXML
        private TableView<NoticeUser> table;

    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        message.setCellValueFactory(new PropertyValueFactory<>("message"));
        date_time.setCellValueFactory(new PropertyValueFactory<>("date_time"));



        List<NoticeUser> userList = NoticeUser.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<NoticeUser> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);

    }



}
