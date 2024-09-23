package university.misv2.universitymisv2.technicalOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class MedicalQuery {

    @FXML
    private TextField Startdate;

    @FXML
    private Button clearButton;

    @FXML
    private TextField enddate;

    @FXML
    private TextField isdaymedical;

    @FXML
    private Label lablehide;

    @FXML
    private TextField medid;

    @FXML
    private TextField reson;

    @FXML
    private ImageView shieldimageView;

    @FXML
    private TextField submittteddata;

    @FXML
    private Button updatecourse;

    public void addmedical() throws SQLException {
        Connection connectDB = DatabaseConnection.getConnection();

        Integer id = Integer.parseInt(medid.getText());
        String resons = reson.getText();
        LocalDate startDate = LocalDate.parse(Startdate.getText());
        LocalDate endDate = LocalDate.parse(enddate.getText());
        String is_day_medical = isdaymedical.getText();
        LocalDate submitted_date =  LocalDate.parse(submittteddata.getText());

        try {
            String insertQuery = "INSERT INTO medical (id, reason, start_date, end_date, is_day_medical,submitted_date) VALUES (?, ?, ?, ?, ?, ?)";
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, resons);
            preparedStatement.setDate(3, Date.valueOf(startDate));
            preparedStatement.setDate(4, Date.valueOf(endDate));
            preparedStatement.setString(5, is_day_medical);
            preparedStatement.setDate(6, Date.valueOf(submitted_date));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                lablehide.setText("Successful");
            } else {
                lablehide.setText("Not Successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connectDB != null) {
                connectDB.close();
            }
        }
    }

    public void updatemedicalOnAction(ActionEvent event) throws SQLException {
        if (!medid.getText().isEmpty()) {
            updatedata();
        } else {
            lablehide.setText("fail");
        }
    }

    public void updatedata() throws SQLException {
        Connection connectDB = DatabaseConnection.getConnection();

        String id = medid.getText();
        String resons = reson.getText();
        String Start_date = Startdate.getText();
        String end_date = enddate.getText();
        String is_day_medical = isdaymedical.getText();
        String submitted_date = submittteddata.getText();

        try {
            String updateQuery = "UPDATE medical SET reason = ?, start_date = ?, end_date = ?, is_day_medical = ?, submitted_date = ? WHERE id = ?";
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery);
            preparedStatement.setString(1, resons);
            preparedStatement.setString(2, Start_date);
            preparedStatement.setString(3, end_date);
            preparedStatement.setString(4, is_day_medical);
            preparedStatement.setString(5, submitted_date);
            preparedStatement.setString(6, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                lablehide.setText("Successful");
            } else {
                lablehide.setText("Not Successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connectDB != null) {
                connectDB.close();
            }
        }
    }

    public void deletedata() throws SQLException {
        Connection connectDB = DatabaseConnection.getConnection();

        String id = medid.getText();

        try {
            String deleteQuery = "DELETE FROM medical WHERE id = ?";
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(deleteQuery);
            preparedStatement.setString(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                lablehide.setText("Record deleted successfully");
            } else {
                lablehide.setText("No record found for deletion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connectDB != null) {
                connectDB.close();
            }
        }
    }


    public void clearButton() {
        Startdate.clear();
        enddate.clear();
        isdaymedical.clear();
        medid.clear();
        reson.clear();
        submittteddata.clear();
    }
}
