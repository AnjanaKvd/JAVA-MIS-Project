module mis.university {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
 // requires mysql.connector.java;


    opens mis.university to javafx.fxml;
    exports mis.university;
}