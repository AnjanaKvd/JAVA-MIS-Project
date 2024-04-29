package university.misv2.universitymisv2.lecturer;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import university.misv2.universitymisv2.DatabaseConnection;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static sun.misc.Signal.handle;

public class MaterialsData {
    private String Course_code;
    private String Materials_name;
    private Button button;

    public MaterialsData(String Course_code, String Materials_name) {
        this. Course_code = Course_code;
        this.Materials_name = Materials_name;
        this.button=new Button("  ADD  ");
    }

    public static List<MaterialsData> fetchAllUsers() throws SQLException {
        List<MaterialsData> materialsData = new ArrayList<>();
        Connection connectDB = DatabaseConnection.getConnection();

        String query = "SELECT Course_code, Materials_name FROM courseMaterials";

        try {

            try (Statement statement = connectDB.createStatement();
                 ResultSet result = statement.executeQuery(query)) {

                while (result.next()) {
                    String Course_code = result.getString("Course_code");
                    String Materials_name = result.getString("Materials_name");


                    // Create a new User instance with the data from the ResultSet
                    MaterialsData materialsdata = new MaterialsData(Course_code, Materials_name);
                    materialsData.add(materialsdata);
                }

            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return materialsData;
    }


    public String getCourse_code() {
        return Course_code;
    }

    public String getMaterials_name() {
        return Materials_name;
    }

    public void setButton(Button button){

        this.button=button;
    }

    public Button getButton(){
        button.setOnAction(event -> {
            handle(event);
        });
        return button;
    }
    public void handle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile;
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
        selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            try {
                // Call the insertFilePath method if it's available in the same class
                insertFilePath(filePath);
                System.out.println("File path inserted into the database: " + filePath);
            } catch (SQLException e) {
                System.out.println("Error inserting file path into the database: " + e.getMessage());
            }
        }
    }

    public static void insertFilePath(String filePath) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO coursematerials (file_path) VALUES (?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, filePath);
            preparedStatement.executeUpdate();
        } finally {
            // Close resources
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}