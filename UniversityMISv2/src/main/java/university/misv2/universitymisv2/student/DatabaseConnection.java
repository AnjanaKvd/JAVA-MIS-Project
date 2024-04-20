package university.misv2.universitymisv2.student;

import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseConnection {
    public static Connection databaseLink;


    public Connection getConnection(){
        String databaseName = "techman";
        String databaseUser = "root";
        String databasePassword = "1234";
        String url = "jdbc:mysql://localhost:3306/"+databaseName;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return databaseLink;
    }
}

