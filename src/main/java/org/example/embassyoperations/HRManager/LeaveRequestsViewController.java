package org.example.embassyoperations.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.ConsularOfficer.LeaveRequest;
import org.example.embassyoperations.MainApplication;

import java.io.*;
import java.util.ArrayList;

public class LeaveRequestsViewController
{
    @javafx.fxml.FXML
    private TableView<LeaveRequest> leaveRequestTableView;
    @javafx.fxml.FXML
    private TableColumn<LeaveRequest,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<LeaveRequest,String> applicationIdCol;
    @javafx.fxml.FXML
    private TextField enterApplicationIdTextField;
    @javafx.fxml.FXML
    private TableColumn<LeaveRequest,String> employeeIdCol;
    @javafx.fxml.FXML
    private TableColumn<LeaveRequest,String> designationCol;

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
        statusCol.setCellValueFactory(new PropertyValueFactory<LeaveRequest,String>("status"));
        applicationIdCol.setCellValueFactory(new PropertyValueFactory<LeaveRequest,String>("requestId"));
        employeeIdCol.setCellValueFactory(new PropertyValueFactory<LeaveRequest,String>("employeeId"));
        designationCol.setCellValueFactory(new PropertyValueFactory<LeaveRequest,String>("designation"));
    }

    @javafx.fxml.FXML
    public void approveButtonOnAction(ActionEvent actionEvent) {
        ArrayList<LeaveRequest> requestList = new ArrayList<>();
        File f = new File("LeaveRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                LeaveRequest req = (LeaveRequest) ois.readObject();
                if(!(enterApplicationIdTextField.getText().equals(req.getRequestId()))){
                    requestList.add(req);
                }
                else{
                    req.setStatus("Approved");
                    requestList.add(req);
                }
            }
        }catch(Exception e){
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (LeaveRequest r : requestList) {
                oos.writeObject(r);
            }
        }catch(Exception e){
            //
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Leave Request successfully approved");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(enterApplicationIdTextField.getText().isEmpty()){
            alert.setContentText("Invalid Application ID");
            alert.setContentText("Please enter application id");
            alert.showAndWait();
            return;
        }
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/LeaveRequestDetailsView.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Leave Request Detail");
            stage.setScene(scene);
            LeaveRequestDetailsViewController controller = fxmlLoader.getController();
            controller.setLeaveRequestInfo(enterApplicationIdTextField.getText());
            stage.show();

        }catch(Exception e){
            //
        }
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
    public void rejectButtonOnAction(ActionEvent actionEvent) {
        ArrayList<LeaveRequest> requestList = new ArrayList<>();
        File f = new File("LeaveRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                LeaveRequest req = (LeaveRequest) ois.readObject();
                if(!(enterApplicationIdTextField.getText().equals(req.getRequestId()))){
                    requestList.add(req);
                }
                else{
                    req.setStatus("Rejected");
                    requestList.add(req);
                }
            }
        }catch(Exception e){
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (LeaveRequest r : requestList) {
                oos.writeObject(r);
            }
        }catch(Exception e){
            //
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Leave Request successfully rejected");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void loadTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<LeaveRequest> requestList = new ArrayList<>();
        File f = new File("LeaveRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                LeaveRequest req = (LeaveRequest) ois.readObject();
                if(req.getStatus().equals("Pending")){
                    requestList.add(req);
                }
            }
        }catch(Exception e){
            //
        }
        leaveRequestTableView.getItems().clear();
        leaveRequestTableView.getItems().addAll(requestList);
    }
}