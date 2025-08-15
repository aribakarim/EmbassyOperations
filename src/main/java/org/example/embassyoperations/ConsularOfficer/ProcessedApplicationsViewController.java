package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProcessedApplicationsViewController
{
    @javafx.fxml.FXML
    private TableColumn<PassportApplication, String> statusCol;
    @javafx.fxml.FXML
    private TableView<PassportApplication> passportApplicationTableView;
    @javafx.fxml.FXML
    private TableColumn<PassportApplication, String> applicationIdCol;
    @javafx.fxml.FXML
    private TableColumn<PassportApplication, String> applicantIdCol;
    @javafx.fxml.FXML
    private TableColumn<PassportApplication, LocalDate> applicationDateCol;

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
        applicationDateCol.setCellValueFactory(new PropertyValueFactory<PassportApplication, LocalDate>("dateOfApplication"));
        statusCol.setCellValueFactory(new PropertyValueFactory<PassportApplication, String>("status"));
        applicantIdCol.setCellValueFactory(new PropertyValueFactory<PassportApplication, String>("applicantId"));
        applicationIdCol.setCellValueFactory(new PropertyValueFactory<PassportApplication, String>("applicationId"));
    }

    @javafx.fxml.FXML
    public void showRejectedPPAButtonOnAction(ActionEvent actionEvent) {
        ArrayList<PassportApplication> list = new ArrayList<>();
        File f = new File("PassportApplicationInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                PassportApplication p = (PassportApplication) ois.readObject();
                if (p.getStatus().equals("Rejected") && p.getProcessedById().equals(this.loggedInOfficer.getId())) {
                    list.add(p);
                }
            }
        } catch (Exception e) {
            //
        }
        passportApplicationTableView.getItems().clear();
        passportApplicationTableView.getItems().addAll(list);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void showApprovedPPAButtonOnAction(ActionEvent actionEvent) {
        ArrayList<PassportApplication> list = new ArrayList<>();
        File f = new File("PassportApplicationInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                PassportApplication p = (PassportApplication) ois.readObject();
                if (p.getStatus().equals("Approved") && p.getProcessedById().equals(this.loggedInOfficer.getId())) {
                    list.add(p);
                }
            }
        } catch (Exception e) {
            //
        }
        passportApplicationTableView.getItems().clear();
        passportApplicationTableView.getItems().addAll(list);
    }
}