package university.misv2.universitymisv2.lecturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadMarks {

    @FXML
    private Button AddMaterialsButton;

    @FXML
    private Button CloseButton;

    @FXML
    private TextField Coursecode;

    @FXML
    private TextField end_marks;

    @FXML
    private Label lablehide;

    @FXML
    private TextField mid_marks;

    @FXML
    private TextField project_marks;

    @FXML
    private TextField quiz1_marks;

    @FXML
    private TextField quiz2_marks;

    @FXML
    private TextField quiz3_marks;

    @FXML
    private ImageView shieldimageView;

    @FXML
    private TextField student_id;


    public void addDataAction(ActionEvent event) throws SQLException {
        Connection connectDB = DatabaseConnection.getConnection();
        try {

            int quiz1_marks_new = Integer.parseInt(quiz1_marks.getText());
            int quiz2_marks_new = Integer.parseInt(quiz2_marks.getText());
            int quiz3_marks_new = Integer.parseInt(quiz3_marks.getText());
            int mid_marks_new = Integer.parseInt(mid_marks.getText());
            int project_marks_new = Integer.parseInt(project_marks.getText());
            int end_marks_new = Integer.parseInt(end_marks.getText());



            String sql = "INSERT INTO course_marks (course_code, student_id, quiz1_marks, quiz2_marks, quiz3_marks, mid_marks, project_marks, end_marks) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            assert connectDB != null;
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(sql)) {
                preparedStatement.setString(1, Coursecode.getText());
                preparedStatement.setString(2, student_id.getText());
                preparedStatement.setInt(3, quiz1_marks_new);
                preparedStatement.setInt(4, quiz2_marks_new);
                preparedStatement.setInt(5, quiz3_marks_new);
                preparedStatement.setInt(6, mid_marks_new);
                preparedStatement.setInt(7, project_marks_new);
                preparedStatement.setInt(8, end_marks_new);

                preparedStatement.executeUpdate();
                lablehide.setText("Successfully");
            }
        } catch (NumberFormatException e) {
            lablehide.setText("fail");
        } catch (SQLException e) {
            lablehide.setText("Database error: " + e.getMessage());
        }
    }

    public void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) CloseButton.getScene().getWindow();
        stage.close();
    }
}
