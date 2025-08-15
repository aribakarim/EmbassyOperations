package org.example.embassyoperations.HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.embassyoperations.MainApplication;
import org.example.embassyoperations.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MyProfileViewController
{

    private HRManager loggedInOfficer;
    @javafx.fxml.FXML
    private TextArea profileInfoTextArea;

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
            EditProfileViewController controller = fxmlLoader.getController();
            controller.setLoggedInOfficer(this.loggedInOfficer);
            controller.setEmployeeID(this.loggedInOfficer);
            stage.show();
        }catch (Exception e){
            //
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

    void setProfileInfo(HRManager hr){
        profileInfoTextArea.setText(hr.toString());
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {
        File f = new File("User.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                User user = (User) ois.readObject();
                if(user.getId().equals(this.loggedInOfficer.getId())){
                    profileInfoTextArea.setText(user.toString());
                }
            }

        }catch(Exception e){
            //
        }
    }
}