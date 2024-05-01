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

public class Addmaterials implements Initializable {

    @FXML
    private TableColumn<String, MaterialsData> Couser_code;

    @FXML
    private TableColumn<String, MaterialsData> Materials_name;

    @FXML
    private TableColumn<String,MaterialsData> Uploade;


    @FXML
    private TableView<MaterialsData> table_materials;

    public void initialize(URL location, ResourceBundle resources) {
        // Configure the columns with the property names matching the User class
        Couser_code.setCellValueFactory(new PropertyValueFactory<>("Course_code"));
        Materials_name.setCellValueFactory(new PropertyValueFactory<>("Materials_name"));
        TableColumn upload =new TableColumn("   Upload materials   ");


        table_materials.getColumns().addAll(upload);



        // Load the list of users from the database
        List<MaterialsData> materialsData = null;
        try {
            materialsData = MaterialsData.fetchAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        ObservableList<MaterialsData> observablemdList = FXCollections.observableArrayList(materialsData);


        upload.setCellValueFactory(
                new PropertyValueFactory<MaterialsData,String>("button")

        );



        // Set the data in the table
        table_materials.setItems(observablemdList);

    }
}