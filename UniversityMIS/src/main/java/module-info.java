module com.university.mis.universitymis {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.university.mis.universitymis to javafx.fxml;
    exports com.university.mis.universitymis;
}