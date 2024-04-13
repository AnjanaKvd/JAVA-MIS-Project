package university.misv2.universitymisv2.admin;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AdminController {

    @FXML
    private Label profileNameLabel;

    @FXML
    private Label profileRoleLabel;

    @FXML
    private ImageView closeBtn;

    @FXML
    private void initialize() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.4), closeBtn);
        rotateTransition.setByAngle(360);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(1);
        closeBtn.setOnMouseEntered(event -> rotateTransition.play());
        closeBtn.setOnMouseExited(event -> rotateTransition.stop());
        closeBtn.setOnMouseExited(event -> rotateTransition.setFromAngle(0));
    }

    @FXML
    private void handleCloseButtonAction() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}