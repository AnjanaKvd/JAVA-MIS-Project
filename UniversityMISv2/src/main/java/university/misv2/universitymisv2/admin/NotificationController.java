package university.misv2.universitymisv2.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NotificationController {

    public Label notificationDate;
    @FXML
    private Label notificationID;
    @FXML
    private Label notificationMessage;

    public void setNotificationData(String id, String message, String date) {
        notificationID.setText(id);
        notificationMessage.setText(message);
        notificationDate.setText(date);
    }

    private AdminController adminController;

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public void handleDeleteNotification(ActionEvent event) {
        try {
            String id = notificationID.getText();
            NotificationManager.deleteNotification(Integer.parseInt(id));
            adminController.refreshNotifications();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
