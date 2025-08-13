package org.example.embassyoperations.HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.embassyoperations.LoginViewController;
import org.example.embassyoperations.MainApplication;
import org.example.embassyoperations.User;

import java.io.IOException;
import java.time.LocalDate;

public class MyProfileViewController
{
    @javafx.fxml.FXML
    private Label dateOfBirthLabel;
    @javafx.fxml.FXML
    private Label phoneNoLabel;
    @javafx.fxml.FXML
    private Label employeeNameLabel;
    @javafx.fxml.FXML
    private Label employeeIdLabel;
    @javafx.fxml.FXML
    private TextArea addressTextArea;
    @javafx.fxml.FXML
    private Label designationLabel;
    @javafx.fxml.FXML
    private Label emailLabel;

    private HRManager loggedInOfficer;
    @javafx.fxml.FXML
    private Label nidLabel;
    @javafx.fxml.FXML
    private Label passwordLabel;

    void setLoggedInOfficer(HRManager officer){
        this.loggedInOfficer = officer;
    }

    private HRManagerDashboardController dashboard;
    void setDashboard(HRManagerDashboardController dashboard){
        this.dashboard = dashboard;
    }

    private ObservableList<User> employee = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void editButtonOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/EditProfileView.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Edit Profile");
            stage.setScene(scene);
            EditProfileViewViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.loggedInOfficer);
            controller.setEmployeeID(this.loggedInOfficer);
            stage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {
        employee.clear();
        LoginViewController controller = new LoginViewController();
        employee.setAll(controller.readHRManager());
        for(User hr: employee){
            if(hr.getId().equals(loggedInOfficer.getId())){
                employeeNameLabel.setText(hr.getName());
                employeeIdLabel.setText(hr.getId());
                designationLabel.setText(hr.getUsertype());
                phoneNoLabel.setText(hr.getPhoneNo());
                emailLabel.setText(hr.getEmail());
                LocalDate date = hr.getDob();
                dateOfBirthLabel.setText(date.toString());
                nidLabel.setText(hr.getNid());
                passwordLabel.setText(hr.getPassword());
                addressTextArea.setText(hr.getAddress());
            }
        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        } catch (IOException e) {
            //
        }
    }
}