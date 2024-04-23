package university.misv2.universitymisv2.lecturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.*;


public class UpdateCourse {

    @FXML
    private Button AddMaterialsButton;

    @FXML
    private Button CloseButton;

    @FXML
    private TextField coursecodefield;

    @FXML
    private TextField coursenamefield;

    @FXML
    private TextField theory_or_practicalfield;

    @FXML
    private TextField is_midfield;

    @FXML
    private TextField is_projectfield;

    @FXML
    private Label lablehide;

    @FXML
    private Button updatecourse;

    @FXML
    private TextField creditsfield;

    @FXML
    private TextField Gpafiled;


    public void updatecourseOnAction(ActionEvent event) throws SQLException {

        if(!coursecodefield.getText().isEmpty()){

            updatedata();
        } else{
            lablehide.setText("fail");
        }




    }

    public  void  updatedata() throws SQLException {
        Connection connectDB= DatabaseConnection.getConnection();

        String code=coursecodefield.getText();
        String name=coursenamefield.getText();
        String is_mid=is_midfield.getText();
        String is_project=is_projectfield.getText();
        String theory_or_practical=theory_or_practicalfield.getText();
        int credit = Integer.parseInt(creditsfield.getText());
        String Gpa=Gpafiled.getText();
        try {
            String updateQuery = "UPDATE courses SET name = ?, is_mid = ?, is_project = ?, theory_or_practical = ?, credits = ?,gpa_or_ngpa = ?  WHERE code = ?";
            assert connectDB != null;
            PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, is_mid);
            preparedStatement.setString(3, is_project);
            preparedStatement.setString(4, theory_or_practical);
            preparedStatement.setInt(5,credit);
            preparedStatement.setString(6,Gpa);
            preparedStatement.setString(7, code);




            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                lablehide.setText("Successful");
            } else {
                lablehide.setText(" Not Successful");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void cancleButtononAction(ActionEvent event){
        Stage stage=(Stage) CloseButton.getScene().getWindow();
        stage.close();


    }

    public void AddMaterialsButton() throws SQLException {
        DatabaseConnection connectionNow=new DatabaseConnection();
        Connection connectDB=connectionNow.getConnection();

        String code=coursecodefield.getText();
        String name=coursenamefield.getText();
        String is_mid=is_midfield.getText();
        String is_project=is_projectfield.getText();
        String theory_or_practical=theory_or_practicalfield.getText();
        int credit = Integer.parseInt(creditsfield.getText());
        String Gpa=Gpafiled.getText();



        String insertField="INSERT INTO courses(code,name,is_mid,is_project,theory_or_practical,credits,gpa_or_ngpa) VALUES ('";
        String insertValue=code + "','" + name + "','" + is_mid + "','" + is_project + "','" + theory_or_practical + "','" + credit + "','" + Gpa +  "')";
        String insertToRegister=insertField+insertValue;

        try{
            assert connectDB != null;
            Statement statement=connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            lablehide.setText("Add Data");


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
