package org.example.embassyoperations.HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.LoginViewController;
import org.example.embassyoperations.MainApplication;
import org.example.embassyoperations.User;

import java.time.LocalDate;
import java.util.ArrayList;


public class MaintenanceRequestViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> employeeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> designationComboBox;
    @javafx.fxml.FXML
    private TextArea issueDescriptionTextArea;

    private HRManager loggedInOfficer;

    void setLoggedInOfficer(HRManager officer) {
        this.loggedInOfficer = officer;
    }

    private HRManagerDashboardController dashboard;
    void setDashboard(HRManagerDashboardController dashboard){
        this.dashboard = dashboard;
    }

    private ObservableList<User> employee = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("HR Manager","Consular Officer");

    }

    @javafx.fxml.FXML
    public void designationComboboxOnAction (ActionEvent actionEvent) {
        try{
            employeeComboBox.getItems().clear();
            employee.clear();
            LoginViewController controller = new LoginViewController();
            if(designationComboBox.getValue().equals("HR Manager")){
                employee.addAll(controller.readHRManager());
                for(User hr : employee){
                    employeeComboBox.getItems().add(hr.getName()+"-"+hr.getId());
                }
            }
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void submitRequestButtonOnAction(ActionEvent actionEvent) {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        if(designationComboBox.getValue() == null){
            alert1.setTitle("Invalid Designation");
            alert1.setContentText("Please select designation");
            alert1.showAndWait();
            return;
        }
        if(employeeComboBox.getValue() == null){
            alert1.setTitle("Invalid Employee");
            alert1.setContentText("Please select employee");
            alert1.showAndWait();
            return;
        }
        if(issueDescriptionTextArea.getText().isEmpty()){
            alert1.setTitle("Invalid Description");
            alert1.setContentText("Please enter decription");
            alert1.showAndWait();
            return;
        }

        String employeeID;
        LocalDate requestDate;

        MaintenanceRequest newRequest = new MaintenanceRequest(loggedInOfficer.getId(),issueDescriptionTextArea.getText());
        loggedInOfficer.submitMaintenanceRequest(newRequest);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setTitle("Request successfully submitted!");
        alert.showAndWait();

        issueDescriptionTextArea.clear();
        designationComboBox.setValue("");
        employeeComboBox.setValue("");
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
    public void showPreviousRequestsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/PreviousMaintenanceRequestView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            PreviousMaintenanceRequestViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(loggedInOfficer);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            //
        }
    }
}