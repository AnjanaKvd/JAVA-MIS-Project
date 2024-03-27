module university.misv2.universitymisv2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens university.misv2.universitymisv2 to javafx.fxml;
    exports university.misv2.universitymisv2;
}