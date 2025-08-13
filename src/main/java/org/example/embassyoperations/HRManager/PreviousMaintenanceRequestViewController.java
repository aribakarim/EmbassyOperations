package org.example.embassyoperations.HRManager;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class PreviousMaintenanceRequestViewController
{
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,String> statusCol;
    @javafx.fxml.FXML
    private TableView<MaintenanceRequest> previousRequestsTableView;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,String> requestIDCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,LocalDate> requestDateCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,String> employeeIDCol;
    @javafx.fxml.FXML
    private TableColumn<MaintenanceRequest,String> issueDescriptionCol;

    private HRManager loggedInOfficer;


    void setLoggedInOfficer(HRManager officer) {
        this.loggedInOfficer = officer;
    }

    @javafx.fxml.FXML
    public void initialize() {
        statusCol.setCellValueFactory(new PropertyValueFactory<MaintenanceRequest, String>("status"));
        employeeIDCol.setCellValueFactory(new PropertyValueFactory<MaintenanceRequest, String>("employeeId"));
        requestIDCol.setCellValueFactory(new PropertyValueFactory<MaintenanceRequest, String>("requestId"));
        requestDateCol.setCellValueFactory(new PropertyValueFactory<MaintenanceRequest, LocalDate>("requestDate"));
        issueDescriptionCol.setCellValueFactory(new PropertyValueFactory<MaintenanceRequest,String>("issueDescription"));

    }


    @javafx.fxml.FXML
    public void loadTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<MaintenanceRequest> filteredRequests = new ArrayList<>();
        File f = new File("MaintenanceRequestInfo.bin");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                MaintenanceRequest req = (MaintenanceRequest) ois.readObject();
                if(req.getEmployeeId().equals(this.loggedInOfficer.getId())){
                    filteredRequests.add(req);
                }
            }
        }
        catch(Exception e){
            //
        }
        previousRequestsTableView.getItems().clear();
        previousRequestsTableView.getItems().addAll(filteredRequests);
    }
}