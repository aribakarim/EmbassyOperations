package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
    }

    @javafx.fxml.FXML
    public void tasksButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calendarButtonOnAction(ActionEvent actionEvent) {
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
    }

    @javafx.fxml.FXML
    public void processedApplicationsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void passportApplicationsButtonOnAction(ActionEvent actionEvent) {
    }

    public void setHomePage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/HomepageCO.fxml"));
        Parent root = fxmlLoader.load();
        HomepageController controller = fxmlLoader.getController();
        controller.labelTitle(consularOfficer);
        consularOfficerDashboardBP.setCenter(root);
    }
}