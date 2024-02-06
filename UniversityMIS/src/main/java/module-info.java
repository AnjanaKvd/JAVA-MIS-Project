module university.mis.universitymis {
    requires javafx.controls;
    requires javafx.fxml;


    opens university.mis.universitymis to javafx.fxml;
    exports university.mis.universitymis;
}