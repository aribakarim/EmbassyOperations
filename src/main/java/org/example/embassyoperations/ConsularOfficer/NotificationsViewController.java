package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.HRManager.Announcement;
import org.example.embassyoperations.HRManager.MaintenanceRequest;
import org.example.embassyoperations.MainApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class NotificationsViewController
{
    @javafx.fxml.FXML
    private TableView<Announcement> notificationsTableView;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> titleCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Announcement,String> notificationIdCol;
    @javafx.fxml.FXML
    private TextField enterNotificationIdTextField;

    private ConsularOfficer loggedInOfficer;

    public void setLoggedInOfficer(ConsularOfficer consularOfficer) {
        this.loggedInOfficer = consularOfficer;
    }
    private ConsularOfficerDashboardController dashboard;

    public void setDashboard(ConsularOfficerDashboardController dashboard){
        this.dashboard = dashboard;
    }

    @javafx.fxml.FXML
    public void initialize() {
        titleCol.setCellValueFactory(new PropertyValueFactory<Announcement,String>("title"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Announcement,LocalDate>("date"));
        notificationIdCol.setCellValueFactory(new PropertyValueFactory<Announcement,String>("announcementID"));
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(enterNotificationIdTextField.getText().isEmpty()){
            alert.setContentText("Invalid Notification ID");
            alert.setContentText("Please enter notification id");
            alert.showAndWait();
            return;
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/NotificationDetailsView.fxml"));
            Parent root = fxmlLoader.load();

            NotificationsDetailsViewController controller = fxmlLoader.getController();
            controller.setNotificationDetail(enterNotificationIdTextField.getText());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Notification Details");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void loadTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<Announcement> list = new ArrayList<>();
        File f = new File("AnnouncementInfo.bin");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Announcement a = (Announcement) ois.readObject();
                list.add(a);
            }
        }
        catch(Exception e){
            //
        }
        notificationsTableView.getItems().clear();
        notificationsTableView.getItems().addAll(list);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        } catch (Exception e) {
            //
        }
    }
}