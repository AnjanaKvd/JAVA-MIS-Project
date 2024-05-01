package university.misv2.universitymisv2.lecturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Eligibility {

    @FXML
    private Button CloseButton;

    @FXML
    private TextField course_code;

    @FXML
    private Button eligibilityButton;

    @FXML
    private Label hidemessage;

    @FXML
    private ImageView shieldimageView;

    @FXML
    private TextField student_id;

    @FXML
    private Label statusmessage;

    public void initialize() {
        // Initialization code
    }

    @FXML
    public void  clearButton(){
        course_code.clear();
        student_id.clear();
    }

    @FXML
    void eligibilityButtonClick(ActionEvent event) {
        try {
            Connection connectionDB = DatabaseConnection.getConnection();

            String verifyLogin = "SELECT count(student_id) from course_attendence where student_id = '" + student_id.getText() + "'  and  course_code = '" + course_code.getText() + "'  and  Status = '" + "Present" + "'";

            String totaldate = "SELECT count(student_id) from course_attendence where student_id = '" + student_id.getText() + "'  and  course_code = '" + course_code.getText() + "'";

            int count = 0;
            int totcount = 0;

            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) != 0) {
                    hidemessage.setText("Success");
                    count = queryResult.getInt(1);
                    System.out.println(count);
                } else {
                    hidemessage.setText("Invalid login");
                }
            }

            queryResult = statement.executeQuery(totaldate);

            while (queryResult.next()) {
                if (queryResult.getInt(1) != 0) {
                    hidemessage.setText("Success");
                    totcount = queryResult.getInt(1);
                    System.out.println(totcount);
                } else {
                    hidemessage.setText("Invalid login");
                }
            }

            int percentage = (count / totcount) * 100;

            if (percentage >= 80) {
                statusmessage.setText("Eligible");
            } else {
                statusmessage.setText("Not Eligible");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
