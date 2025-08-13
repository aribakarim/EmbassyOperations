package org.example.embassyoperations.HRManager;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.embassyoperations.MainApplication;

import java.io.IOException;

public class HRManagerDashboardController
{
    @javafx.fxml.FXML
    private BorderPane hrManagerBP;
    @javafx.fxml.FXML
    private Label outputLabel;

    HRManager loggedInOfficer;

    public void setLoggedInOfficer(HRManager officer) {
        this.loggedInOfficer = officer;
        outputLabel.setText("Welcome " + officer.getName() + "!");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void maintenanceRequestButtonOnAction(ActionEvent actionEvent) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/MaintenanceRequestView.fxml"));
            Parent root = fxmlLoader.load();
            MaintenanceRequestViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.loggedInOfficer);
            controller.setDashboard(this);
            hrManagerBP.setCenter(root);

    }

    @javafx.fxml.FXML
    public void employeeDirectoryButtonOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/EmployeeDirectoryView.fxml"));
            Parent root = fxmlLoader.load();
            EmployeeDirectoryViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.loggedInOfficer);
            controller.setDashboard(this);
            hrManagerBP.setCenter(root);
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void myProfile(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/MyProfileView.fxml"));
            Parent root = fxmlLoader.load();
            MyProfileViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.loggedInOfficer);
            controller.setDashboard(this);
            hrManagerBP.setCenter(root);
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void calendarButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void staffActivityReportsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveRequestsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendAnnouncementButtonOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/AnnouncementView.fxml"));
            Parent root = fxmlLoader.load();
            AnnouncementViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.loggedInOfficer);
            controller.setDashboard(this);
            hrManagerBP.setCenter(root);
        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void signOutButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("LoginView.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.showAndWait();
        }catch (Exception e){
            System.out.println("Signout" + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void assignTaskButtonOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/AssignTaskView.fxml"));
            Parent root = fxmlLoader.load();
            AssignTaskController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.loggedInOfficer);
            controller.setDashboard(this);
            hrManagerBP.setCenter(root);
        } catch (Exception e) {
            //;
        }

    }

    public void setHomePage() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/HomepageHR.fxml"));
        Parent root = fxmlLoader.load();

        HomepageHRController controller = fxmlLoader.getController();
        controller.labelTitle(loggedInOfficer);
        hrManagerBP.setCenter(root);
    }

}