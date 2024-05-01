package university.misv2.universitymisv2.lecturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import university.misv2.universitymisv2.DatabaseConnection;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Materialform {

    @FXML
    private TextField CoursecodeField;

    @FXML
    private TextField MaterialsnameField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button meterialButton;

    @FXML
    private Button drop;


    @FXML
    private Label hidelable;

    private String uploadedFilePath;

    public void AddMaterialsform(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile;
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
        selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        if (selectedFile != null) {
            uploadedFilePath = selectedFile.getAbsolutePath();
            hidelable.setText("File uploaded: " + uploadedFilePath);
        }
    }

    public void submitButtonClicked() {
        String code = CoursecodeField.getText();
        String name = MaterialsnameField.getText();

        if (uploadedFilePath != null && !uploadedFilePath.isEmpty() && !code.isEmpty() && !name.isEmpty()) {
            try {
                insertMaterial(code, name, uploadedFilePath);
                System.out.println("Data Added");
                clearFields();
            } catch (SQLException e) {
                System.out.println("Error inserting data: " + e.getMessage());
            }
        } else {
            hidelable.setText("Please select a file and fill all fields.");
        }
    }

    private static void insertMaterial(String code, String name, String filePath) throws SQLException {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String query = "INSERT INTO courseMaterialsform (Course_code, Materials_name, Uploaded) VALUES (?, ?, ?)";

        try {
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, filePath);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }






    public void clearFields() {
        CoursecodeField.clear();
        MaterialsnameField.clear();
        uploadedFilePath="";


    }

//    public void deleteButton(String code) throws SQLException{
//
//    }

    @FXML
    public void deleteButton(ActionEvent event) {
        // Retrieve the course code from your UI or somewhere else in your code
        String code = CoursecodeField.getText(); // Assuming CoursecodeField is a TextField where the user enters the course code

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String query = "DELETE FROM courseMaterialsform WHERE Course_code = ?";

        try {
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            hidelable.setText("Data deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            hidelable.setText("Error");
        }
    }


}
