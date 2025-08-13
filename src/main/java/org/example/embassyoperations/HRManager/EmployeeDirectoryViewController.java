package org.example.embassyoperations.HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.embassyoperations.LoginViewController;
import org.example.embassyoperations.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EmployeeDirectoryViewController
{
    @javafx.fxml.FXML
    private TextArea outputTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> employeeComboBox;
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

    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("HR Manager","Consular Officer","Visa Officer");
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (designationComboBox.getValue() == null) {
            alert.setTitle("Invalid Designation");
            alert.setContentText("Please select a designation");
            alert.showAndWait();
            return;
        }
        if (employeeComboBox.getValue() == null) {
            alert.setTitle("Invalid Employee");
            alert.setContentText("Please select an employee");
            alert.showAndWait();
            return;
        }

        readEmployeeInfo(this.loggedInOfficer);

    }

    @javafx.fxml.FXML
    public void designationComboBoxOnAction(ActionEvent actionEvent) {
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
        } else if(designationComboBox.getValue().equals("HR Manager")){
            try {
                employee.addAll(controller.readHRManager());
                for(User hr : employee){
                    employeeComboBox.getItems().add(hr.getName()+"-"+hr.getId());
                }
            }catch (Exception e){
                //
            }
        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        }catch (Exception e){
            //
        }
    }

    private void readEmployeeInfo(User user){
        String selected = employeeComboBox.getValue();
        String[] parts = selected.split("-");

        File f = new File("User.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true){
                user = (User) ois.readObject();
                if(user.getId().equals(parts[1])){
                    outputTextArea.setText(user.toString());
                }
            }
        }catch (Exception e){
            //
        }
    }
}