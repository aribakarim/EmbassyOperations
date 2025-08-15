package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.embassyoperations.HRManager.LeaveRequestsViewController;
import org.example.embassyoperations.MainApplication;

import java.io.IOException;

public class ConsularOfficerDashboardController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private BorderPane consularOfficerDashboardBP;

   private ConsularOfficer consularOfficer;

    public void setLoggedInOfficer(ConsularOfficer consularOfficer) {
        this.consularOfficer = consularOfficer;
        outputLabel.setText("Welcome " + consularOfficer.getName() + "!");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void inquiresButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/InquiryView.fxml"));
            Parent root = fxmlLoader.load();
            InquiryViewController controller = fxmlLoader.getController();
            controller.setDashboard(this);
            consularOfficerDashboardBP.setCenter(root);


        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void applyForLeaveButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/ApplyForLeaveView.fxml"));
            Parent root = fxmlLoader.load();
            ApplyForLeaveViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.consularOfficer);
            controller.setDashboard(this);
            consularOfficerDashboardBP.setCenter(root);


        }catch (Exception e){
            //
        }
   }

    @javafx.fxml.FXML
    public void notificationsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/NotificationsView.fxml"));
            Parent root = fxmlLoader.load();
            NotificationsViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.consularOfficer);
            controller.setDashboard(this);
            consularOfficerDashboardBP.setCenter(root);
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void tasksButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/TaskView.fxml"));
            Parent root = fxmlLoader.load();
            TaskViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.consularOfficer);
            controller.setDashboard(this);
            consularOfficerDashboardBP.setCenter(root);
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void calendarButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/CalenderViewCO.fxml"));
            Parent root = fxmlLoader.load();
            CalenderViewCOController controller = fxmlLoader.getController();
            controller.setDashboard(this);
            consularOfficerDashboardBP.setCenter(root);
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void singOutButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("LoginView.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        }catch (Exception e){
            System.out.println("Signout" + e.getMessage());
        }

    }

    @javafx.fxml.FXML
    public void emergencyRequestsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/EmergencyRequestsView.fxml"));
            Parent root = fxmlLoader.load();

            EmergencyRequestsViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.consularOfficer);
            controller.setDashboard(this);
            consularOfficerDashboardBP.setCenter(root);
        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void processedApplicationsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/ProcessedApplicationsView.fxml"));
            Parent root = fxmlLoader.load();

            ProcessedApplicationsViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.consularOfficer);
            controller.setDashboard(this);
            consularOfficerDashboardBP.setCenter(root);
        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void passportApplicationsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/PassportApplicationsView.fxml"));
            Parent root = fxmlLoader.load();

            PassportApplicationsViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.consularOfficer);
            controller.setDashboard(this);
            consularOfficerDashboardBP.setCenter(root);
        }catch(Exception e){
            //
        }
    }

    public void setHomePage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/HomepageCO.fxml"));
        Parent root = fxmlLoader.load();
        HomepageController controller = fxmlLoader.getController();
        controller.labelTitle(consularOfficer);
        consularOfficerDashboardBP.setCenter(root);
    }
}