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
public class NoticesController implements  Initializable {

        @FXML
        private TableColumn<NoticeQuery, String> date_time;

        @FXML
        private TableColumn<NoticeQuery, Integer> id;

        @FXML
        private TableColumn<NoticeQuery, String> message;

        @FXML
        private TableView<NoticeQuery> table;

    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        message.setCellValueFactory(new PropertyValueFactory<>("message"));
        date_time.setCellValueFactory(new PropertyValueFactory<>("date_time"));



        List<NoticeQuery> userList = NoticeQuery.fetchAllUsers();

        // Convert the list to an ObservableList
        ObservableList<NoticeQuery> observableUserList = FXCollections.observableArrayList(userList);

        // Set the data in the table
        table.setItems(observableUserList);

    }



}
