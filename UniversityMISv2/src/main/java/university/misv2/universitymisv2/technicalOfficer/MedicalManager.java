package university.misv2.universitymisv2.technicalOfficer;

import university.misv2.universitymisv2.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalManager {



    public static void modifyaddmedical( String Medical_Id, String Student_id, String Course_code, String theory_or_practical,String Status){
        String query = "INSERT INTO medical (Medical_Id, Student_id,Course_code,theory_or_practical ,Status ) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,Medical_Id );
            statement.setString(2, Student_id);
            statement.setString(3,Course_code);
            statement.setString(4, theory_or_practical);
            //statement.setInt(4, date);
            statement.setString(5,Status);
            //  statement.setString(6, lecturer);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void deleteMedical() throws SQLException{
        String query = "DELETE FROM medical WHERE course_code = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, Medical_Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
