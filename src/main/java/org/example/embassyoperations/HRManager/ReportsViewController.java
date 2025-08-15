package org.example.embassyoperations.HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import org.example.embassyoperations.ConsularOfficer.PassportApplication;
import org.example.embassyoperations.LoginViewController;
import org.example.embassyoperations.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReportsViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> employeeComboBox;
    @javafx.fxml.FXML
    private PieChart approvedRejectedRatioPieChart;
    @javafx.fxml.FXML
    private ComboBox<String> designationComboBox;

    private HRManager loggedInOfficer;

    public void setLoggedInOfficer(HRManager loggedInOfficer) {
        this.loggedInOfficer = loggedInOfficer;
    }

    private HRManagerDashboardController dashboard;
    public void setDashboard(HRManagerDashboardController dashboard){
        this.dashboard = dashboard;
    }
    private ObservableList<User> employee = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("Consular Officer","Visa Officer");
    }

    @javafx.fxml.FXML
    public void designationComboBoxButtonOnAction(ActionEvent actionEvent) {
        employeeComboBox.getItems().clear();
        employee.clear();
        LoginViewController controller = new LoginViewController();
        if(designationComboBox.getValue().equals("Consular Officer")){
            try {
                employee.addAll(controller.readConsularOfficer());
                for(User c : employee){
                    employeeComboBox.getItems().add(c.getName()+"-"+c.getId());
                }
            }catch (Exception e){
                //
            }
        }
    }

    @javafx.fxml.FXML
    public void generateReportButtonOnAction(ActionEvent actionEvent) {
        String selected = employeeComboBox.getValue();
        String[] parts = selected.split("-");
        int approved = 0;
        int rejected = 0;
        File f = new File("PassportApplicationInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                PassportApplication p = (PassportApplication) ois.readObject();
                if(p.getStatus().equals("Approved") && p.getProcessedById().equals(parts[1])){
                    approved+=1;
                }
                else if(p.getStatus().equals("Rejected") && p.getProcessedById().equals(parts[1])){
                    rejected+=1;
                }
            }
        }catch(Exception e){
            //
        }
        list.add(new PieChart.Data("Approved Passport Applications",approved));
        list.add(new PieChart.Data("Rejected Passport Applications",rejected));
        approvedRejectedRatioPieChart.setData(list);
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