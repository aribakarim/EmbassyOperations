package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.MainApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ApplyForLeaveViewController
{
    @javafx.fxml.FXML
    private TableView<LeaveRequest> leaveRequestTableView;
    @javafx.fxml.FXML
    private TableColumn<LeaveRequest, LocalDate> endDateCol;
    @javafx.fxml.FXML
    private TableColumn<LeaveRequest, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn<LeaveRequest, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<LeaveRequest, String> applicationIdCol;

    private ConsularOfficer loggedInOfficer;

    public void setLoggedInOfficer(ConsularOfficer loggedInOfficer) {
        this.loggedInOfficer = loggedInOfficer;
    }

    private ConsularOfficerDashboardController dashboard;

    public void setDashboard(ConsularOfficerDashboardController dashboard){
        this.dashboard = dashboard;
    }

    @javafx.fxml.FXML
    public void initialize() {
        endDateCol.setCellValueFactory(new PropertyValueFactory<LeaveRequest, LocalDate>("endDate"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<LeaveRequest, LocalDate>("startDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<LeaveRequest, String>("status"));
        applicationIdCol.setCellValueFactory(new PropertyValueFactory<LeaveRequest, String>("requestId"));
    }

    @javafx.fxml.FXML
    public void refreshTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<LeaveRequest> request = new ArrayList<>();
        File f = new File("LeaveRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                LeaveRequest req = (LeaveRequest) ois.readObject();
                if(req.getEmployeeId().equals(loggedInOfficer.getId())){
                    request.add(req);
                }
            }
        }catch(Exception e){
            //
        }
        leaveRequestTableView.getItems().clear();
        leaveRequestTableView.getItems().addAll(request);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void newLeaveRequestButtonOnAction(ActionEvent actionEvent) {
        File f = new File("LeaveRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                LeaveRequest req = (LeaveRequest) ois.readObject();
                if(req.getEmployeeId().equals(loggedInOfficer.getId()) && req.getStatus().equals("Pending")){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("You already have a pending request!");
                    alert.showAndWait();
                    return;
                }
            }
        }catch(Exception e){
            //
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/ApplyForLeaveFormView.fxml"));
            Parent root = fxmlLoader.load();

            ApplyForLeaveFormViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.loggedInOfficer);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Apply For Leave Form");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            //
        }
    }
}