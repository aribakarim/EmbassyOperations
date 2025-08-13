package org.example.embassyoperations.HRManager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class AnnouncementViewController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TextArea messageTextArea;

    private HRManager loggedInOfficer;
    void setLoggedInOfficer(HRManager officer){
        this.loggedInOfficer = officer;
    }

    private HRManagerDashboardController dashboard;
    void setDashboard(HRManagerDashboardController dashboard){
        this.dashboard = dashboard;
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendAnnouncementButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(titleTextField.getText().isEmpty()){
            alert.setTitle("Invalid Title");
            alert.setContentText("Please enter title");
            alert.showAndWait();
            return;
        }
        if(messageTextArea.getText().isEmpty()){
            alert.setTitle("Invalid Message");
            alert.setContentText("Please enter message");
            alert.showAndWait();
            return;
        }

        Announcement newAnnouncement = new Announcement(messageTextArea.getText(),titleTextField.getText());
        loggedInOfficer.sendAnnouncementToAllEmployees(newAnnouncement);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setTitle("Announcement successfully sent!");
        alert2.showAndWait();

        messageTextArea.clear();
        titleTextField.clear();
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        }catch (Exception e){
            //
        }
    }
}