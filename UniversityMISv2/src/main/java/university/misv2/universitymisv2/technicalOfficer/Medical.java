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

public class Medical {

    @FXML
    private Button AddMedical;

    @FXML
    private TextField idfield;

    @FXML
    private TextField resonfield;

    @FXML
    private TextField Start_datefield;

    @FXML
    private Button clearButton;

    @FXML
    private TextField end_dtefield;

    @FXML
    private Label lablehide;

    @FXML
    private ImageView shieldimageView;

    @FXML
    private TextField is_day_medicalfield;

    @FXML
    private TextField Submitted_date;

    @FXML
    private Button updatecourse;

    public void addmedical() throws SQLException {
        Connection connectDB = DatabaseConnection.getConnection();

        String id = idfield.getText();
        String reson = resonfield.getText();
        String Start_date = Start_datefield.getText();
        String end_date = end_dtefield.getText();
        String is_day_medical = is_day_medicalfield.getText();
        String submitted_date= Submitted_date.getText();

        try {
            String insertQuery = "INSERT INTO course_attendence (student_id, course_code, Date, Theory_or_Practical, Status) VALUES (?, ?, ?, ?, ?)";
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2, reson);
            preparedStatement.setString(3, Start_date);
            preparedStatement.setString(4, end_date);
            preparedStatement.setString(5, is_day_medical);
            preparedStatement.setString(6,submitted_date);

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

    public void updatemedicalOnAction(ActionEvent event) throws SQLException {

        if (!idfield.getText().isEmpty()) {

            updatedata();
        } else {
            lablehide.setText("fail");
        }
    }

    public void updatedata() throws SQLException {
        Connection connectDB = DatabaseConnection.getConnection();

        String id = idfield.getText();
        String reson = resonfield.getText();
        String Start_date = Start_datefield.getText();
        String end_date = end_dtefield.getText();
        String is_day_medical = is_day_medicalfield.getText();
        String submitted_date= Submitted_date.getText();

        try {
            String updateQuery = "UPDATE course_attendence SET id = ?, Date = ?, Theory_or_Practical = ?, Status = ?  WHERE student_id = ?";
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2, reson);
            preparedStatement.setString(3, Start_date );
            preparedStatement.setString(4, end_date);
            preparedStatement.setString(5,is_day_medical);
            preparedStatement.setString(6, submitted_date);


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
        idfield.clear();
        resonfield.clear();
        Start_datefield.clear();
        end_dtefield.clear();
        is_day_medicalfield.clear();
        Submitted_date.clear();

    }
}
