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

public class Notice implements Initializable {

    @FXML
    private TableColumn<String, NoticeData> notic_date_time;

   @FXML
    private TableColumn<String, NoticeData> notice_id;

    @FXML
    private TableColumn<String, NoticeData> notice_message;

    @FXML
    private TableView<NoticeData> table;


    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
       notice_id.setCellValueFactory(new PropertyValueFactory<>("notice_id"));
        notice_message.setCellValueFactory(new PropertyValueFactory<>("notice_message"));
        notic_date_time.setCellValueFactory(new PropertyValueFactory<>("notic_date_time"));


        // Load the list of users from the database
        List<NoticeData> noticeData = null;
        try {
            noticeData = NoticeData.fetchAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Convert the list to an ObservableList
        ObservableList<NoticeData> observableAmList = FXCollections.observableArrayList(noticeData);

        // Set the data in the table
        table.setItems(observableAmList);

    }
}
