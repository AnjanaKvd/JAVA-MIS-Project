package university.misv2.universitymisv2.technicalOfficer;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Attendance {
    @FXML
    private Stage stage ;
    private Scene scene;
    private Parent root;

    public  void gotecdash(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tec dash.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public static boolean insertAttendance(String student_id, String course_code, String theory_or_practical, java.util.Date date, String status) {
        // SQL statement for inserting data
        String sql = "INSERT INTO course_attendance (student_id, course_code, Theory_or_Practical, Date, Status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for parameters in the prepared statement
            preparedStatement.setString(1, student_id);
            preparedStatement.setString(2, course_code);
            preparedStatement.setString(3, theory_or_practical);
            preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
            preparedStatement.setString(5, status);

            // Execute the insert statement
            int rowsInserted = preparedStatement.executeUpdate();
            // Check if the insertion was successful
            return rowsInserted > 0;
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("Error inserting attendance: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
