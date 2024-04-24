package university.misv2.universitymisv2.technicalOfficer;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

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
    public  void goVeweAttendance(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VeweAttendance.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public static boolean insertAttendance(String student_id, String course_code, String theory_or_practical, java.util.Date date, String status) {
//        // SQL statement for inserting data
//        String sql = "INSERT INTO course_attendance (student_id, course_code, Theory_or_Practical, Date, Status) VALUES (?, ?, ?, ?, ?)";
//
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            // Set values for parameters in the prepared statement
//            preparedStatement.setString(1, student_id);
//            preparedStatement.setString(2, course_code);
//            preparedStatement.setString(3, theory_or_practical);
//            preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
//            preparedStatement.setString(5, status);
//
//            // Execute the insert statement
//            int rowsInserted = preparedStatement.executeUpdate();
//            // Check if the insertion was successful
//            return rowsInserted > 0;
//        } catch (SQLException e) {
//            // Handle any SQL exceptions
//            System.out.println("Error inserting attendance: " + e.getMessage());
//            return false;
//        }
//    }



    @FXML
    private TextField Student_id;

    @FXML
    private TextField  cource_code;

    @FXML
    private TextField  theory_or_practicalfield;

    @FXML
    private  TextField Datefiled;

    @FXML
    private  TextField status;

    @FXML
    private Button Submit;

    @FXML
    private Button Clear;

    public void AddMaterialsButton() throws SQLException {
        DatabaseConnection connectionNow=new DatabaseConnection();
        Connection connectDB=connectionNow.getConnection();

        String student_id=Student_id.getText();
        String Course_code= cource_code.getText();
        String theory_or_practical=theory_or_practicalfield.getText();
        String date =Datefiled.getText();
        String Status=status.getText();



        String insertField="INSERT INTO course_attendance (student_id, course_code, Theory_or_Practical, Date, Status) VALUES ('";
        String insertValue=student_id + "','" + Course_code + "','" + theory_or_practical + "','" + date + "','" + Status  +   "')";
        String insertToRegister=insertField+insertValue;

        try{
            assert connectDB != null;
            Statement statement=connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            //lablehide.setText("Add Data");


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void cancleButtononAction(ActionEvent event){
        Stage stage=(Stage) Clear.getScene().getWindow();
        stage.close();


    }

//    public void updateAttenOnAction(ActionEvent event) throws SQLException {
//
//        if(!student_id.getText().isEmpty()){
//
//            updatedata();
//        } else{
//            //lablehide.setText("fail");
//        }
//        public  void  updatedata() throws SQLException {
//            Connection connectDB= DatabaseConnection.getConnection();
//
////            String code=coursecodefield.getText();
////            String name=coursenamefield.getText();
////            String is_mid=is_midfield.getText();
////            String is_project=is_projectfield.getText();
////            String theory_or_practical=theory_or_practicalfield.getText();
////            int credit = Integer.parseInt(creditsfield.getText());
////            String Gpa=Gpafiled.getText();
//
//            String student_id=Student_id.getText();
//            String Course_code= cource_code.getText();
//            String theory_or_practical=theory_or_practicalfield.getText();
//            String date =Datefiled.getText();
//            String Status=status.getText();
//            try {
//                String updateQuery = "UPDATE courses SET name = ?, is_mid = ?, is_project = ?, theory_or_practical = ?, credits = ?,gpa_or_ngpa = ?  WHERE code = ?";
//                assert connectDB != null;
//                PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery);
//                preparedStatement.setString(1,student_id );
//                preparedStatement.setString(2, Course_code);
//                preparedStatement.setString(3, theory_or_practical);
//                preparedStatement.setString(4, date);
//                preparedStatement.setString(5,Status);
//
//
//
//
//
//                int rowsAffected = preparedStatement.executeUpdate();
//
//                if (rowsAffected > 0) {
//                    //lablehide.setText("Successful");
//                } else {
//                    //lablehide.setText(" Not Successful");
//                }
//            }
//            catch (SQLException e){
//                e.printStackTrace();
//                e.getCause();
//            }
//        }

    }


//}
