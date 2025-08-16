package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.MainApplication;

import java.io.*;
import java.util.ArrayList;

public class EmergencyRequestsViewController
{
    @javafx.fxml.FXML
    private TableColumn<EmergencyRequest,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<EmergencyRequest,String> requestIdCol;
    @javafx.fxml.FXML
    private TableColumn<EmergencyRequest,String> applicantIdCol;
    @javafx.fxml.FXML
    private TableColumn<EmergencyRequest,String> emergencyType;
    @javafx.fxml.FXML
    private TextField enterRequestIdTextField;
    @javafx.fxml.FXML
    private TableView<EmergencyRequest> emergenctRequestTableView;

    private ConsularOfficer loggedInOfficer;

    public void setLoggedInOfficer(ConsularOfficer consularOfficer) {
        this.loggedInOfficer = consularOfficer;
    }

    private ConsularOfficerDashboardController dashboard;

    public void setDashboard(ConsularOfficerDashboardController dashboard) {
        this.dashboard = dashboard;
    }

    @javafx.fxml.FXML
    public void initialize() {
        statusCol.setCellValueFactory(new PropertyValueFactory<EmergencyRequest,String>("status"));
        requestIdCol.setCellValueFactory(new PropertyValueFactory<EmergencyRequest,String>("requestId"));
        applicantIdCol.setCellValueFactory(new PropertyValueFactory<EmergencyRequest,String>("applicantId"));
        emergencyType.setCellValueFactory(new PropertyValueFactory<EmergencyRequest,String>("emergencyType"));

//        EmergencyRequest e1 = new EmergencyRequest("2311","Lost Passport","I can't find my passport.","AA0008412");
//        EmergencyRequest e2 = new EmergencyRequest("2412","Stolen Passport","My passport is stolen.","A03295451");
//        EmergencyRequest e3 = new EmergencyRequest("2533","Medical Emergency","I had a stroke.","AG5168412");
//        EmergencyRequest.writeEmergencyRequest(e1);
//        EmergencyRequest.writeEmergencyRequest(e2);
//        EmergencyRequest.writeEmergencyRequest(e3);

    }

    @javafx.fxml.FXML
    public void markAsResolvedButtonOnAction(ActionEvent actionEvent) {
        ArrayList<EmergencyRequest> requestList = new ArrayList<>();
        File f = new File("EmergencyRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                EmergencyRequest req = (EmergencyRequest) ois.readObject();
                if(!(enterRequestIdTextField.getText().equals(req.getRequestId()))){
                    requestList.add(req);
                }
                else{
                    req.setStatus("Resolved");
                    requestList.add(req);
                }
            }
        }catch(Exception e){
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (EmergencyRequest r : requestList) {
                oos.writeObject(r);
            }
        }catch(Exception e){
            //
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Emergency Request successfully resolved");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (enterRequestIdTextField.getText().isEmpty()) {
            alert.setContentText("Invalid Request ID");
            alert.setContentText("Please enter request id");
            alert.showAndWait();
            return;
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/EmergencyRequestDetailsView.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Leave Request Detail");
            stage.setScene(scene);
            EmergencyRequestsDetailsViewController controller = fxmlLoader.getController();
            controller.setEmergencyRequestsInfo(enterRequestIdTextField.getText());
            stage.show();

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void loadTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<EmergencyRequest> list = new ArrayList<>();
        File f = new File("EmergencyRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                EmergencyRequest p = (EmergencyRequest) ois.readObject();
                if (p.getStatus().equals("Pending")) {
                    list.add(p);
                }
            }
        } catch (Exception e) {
            //
        }
        emergenctRequestTableView.getItems().clear();
        emergenctRequestTableView.getItems().addAll(list);
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