module university.misv2.universitymisv2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens university.misv2.universitymisv2 to javafx.fxml;
    opens university.misv2.universitymisv2.admin to javafx.fxml;
    opens university.misv2.universitymisv2.student to javafx.fxml;
    opens university.misv2.universitymisv2.technicalOfficer to javafx.fxml;
    opens university.misv2.universitymisv2.lecturer to javafx.fxml;



    exports university.misv2.universitymisv2;
<<<<<<< HEAD
    exports university.misv2.universitymisv2.student;
=======
    exports university.misv2.universitymisv2.lecturer;

>>>>>>> e0aa9eec078978d2c8ed382028311ef8013e54c5
}