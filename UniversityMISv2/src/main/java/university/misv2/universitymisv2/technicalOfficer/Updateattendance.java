package university.misv2.universitymisv2.technicalOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Updateattendance {

    @FXML
    private Button AddAttendances;

    @FXML
    private TextField Datefield;

    @FXML
    private TextField Statusfield;

    @FXML
    private TextField Theory_or_Practicalfield;

    @FXML
    private Button clearButton;

    @FXML
    private TextField course_codefield;

    @FXML
    private Label lablehide;

    @FXML
    private ImageView shieldimageView;

    @FXML
    private TextField student_idfield;

    @FXML
    private Button updatecourse;

    public void insertData() throws SQLException {
        Connection connectDB = DatabaseConnection.getConnection();

        String student_id = student_idfield.getText();
        String course_code = course_codefield.getText();
        String date = Datefield.getText();
        String theory_or_practical = Theory_or_Practicalfield.getText();
        String status = Statusfield.getText();

        try {
            String insertQuery = "INSERT INTO course_attendence (student_id, course_code, Date, Theory_or_Practical, Status) VALUES (?, ?, ?, ?, ?)";
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery);
            preparedStatement.setString(1, student_id);
            preparedStatement.setString(2, course_code);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, theory_or_practical);
            preparedStatement.setString(5, status);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                lablehide.setText("Successful");
            } else {
                lablehide.setText("Not Successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();

            //e.getCause();
        } finally {
            // Close resources if necessary
            if (connectDB != null) {
                connectDB.close();
            }
        }
    }

    public void updatecourseOnAction(ActionEvent event) throws SQLException {

        if (!student_idfield.getText().isEmpty()) {

            updatedata();
        } else {
            lablehide.setText("fail");
        }
    }

    public void updatedata() throws SQLException {
        Connection connectDB = DatabaseConnection.getConnection();

        String student_id = student_idfield.getText();
        String course_code = course_codefield.getText();
        String Date = Datefield.getText();
        String Theory_or_Practical = Theory_or_Practicalfield.getText();
        String Status = Statusfield.getText();

        try {
            String updateQuery = "UPDATE course_attendence SET course_code = ?, Date = ?, Theory_or_Practical = ?, Status = ?  WHERE student_id = ?";
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery);
            preparedStatement.setString(1, course_code);
            preparedStatement.setString(2, Date);
            preparedStatement.setString(3, Theory_or_Practical);
            preparedStatement.setString(4, Status);
            preparedStatement.setString(5, student_id);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                lablehide.setText("Successful");
            } else {
                lablehide.setText(" Not Successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public void clearButton() {
        student_idfield.clear();
        course_codefield.clear();
        Datefield.clear();
        Theory_or_Practicalfield.clear();
        Statusfield.clear();

    }
}

