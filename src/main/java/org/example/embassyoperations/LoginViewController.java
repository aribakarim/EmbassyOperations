package org.example.embassyoperations;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.example.embassyoperations.ConsularOfficer.ConsularOfficer;
import org.example.embassyoperations.ConsularOfficer.ConsularOfficerDashboardController;
import org.example.embassyoperations.HRManager.HRManager;
import org.example.embassyoperations.HRManager.HRManagerDashboardController;


import java.io.*;

public class LoginViewController
{
    @javafx.fxml.FXML
    private TextField userIdTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        String id, password;
        Alert alert1 = new Alert(Alert.AlertType.ERROR);

        id = userIdTextField.getText();
        password = passwordPasswordField.getText();

        if(id.isEmpty()){
            alert1.setTitle("Invalid ID");
            alert1.setContentText("Please enter your ID!");
            alert1.showAndWait();
            return;
        }
        if(password.isEmpty()){
            alert1.setTitle("Invalid password");
            alert1.setContentText("Please enter your password!");
            alert1.showAndWait();
            return;
        }

        if(id.length() == 6) {
            ObservableList<ConsularOfficer> consularOffObservableList = this.readConsularOfficer();
            for (ConsularOfficer c : consularOffObservableList) {
                if (c.login(id, password) != null) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/ConsularOfficerDashboard.fxml"));
                        Parent root = fxmlLoader.load();
                        ConsularOfficerDashboardController controller = fxmlLoader.getController();
                        controller.setLoggedInOfficer(c);

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Consular Officer Dashboard");
                        stage.show();
                        return;
                    } catch (Exception e) {
                        System.out.println("Error loading FXML: " + e.getMessage());
                    }
                }
            }//loop
        }
        else if(id.length() == 5){
            ObservableList<HRManager> hrManagerObservableList = this.readHRManager();
            for(HRManager hr: hrManagerObservableList){
                if(hr.login(id,password) != null){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/HRManagerDashboard.fxml"));
                        Parent root = fxmlLoader.load();
                        HRManagerDashboardController controller = fxmlLoader.getController();
                        controller.setLoggedInOfficer(hr);

                        Scene scene = new Scene(root);
                        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("HR Manager Dashboard");
                        stage.show();
                        return;
                    }catch (Exception e){
                        System.out.println("Error loading FXML: " + e.getMessage());
                    }
                }
            }

        }
        else{
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Invalid user");
            alert2.setContentText("User doesn't exist");
        }


    }

    @javafx.fxml.FXML
    public void signUpButtonOnAction(ActionEvent actionEvent) {
    }

    public ObservableList<ConsularOfficer> readConsularOfficer() throws IOException {
        ObservableList<ConsularOfficer> consularOfficerList = FXCollections.observableArrayList();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("ConsularOfficer.bin");
            ConsularOfficer consularOfficer;
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("File doesn't exist");
                alert.showAndWait();
            }
            if(fis!=null){
                ois = new ObjectInputStream(fis);
            }
            while(true){
                consularOfficer = (ConsularOfficer) ois.readObject();
                consularOfficerList.add(consularOfficer);
            }
        }catch (Exception e){
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return consularOfficerList;
   }


    public ObservableList<HRManager> readHRManager(){
        ObservableList<HRManager> hrManagerList = FXCollections.observableArrayList();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("HRManager.bin");
            HRManager hrManager;
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("File doesn't exist");
                alert.showAndWait();
            }
            if(fis!=null){
                ois = new ObjectInputStream(fis);
            }
            while(true){
                hrManager = (HRManager) ois.readObject();
                hrManagerList.add(hrManager);
            }
        }catch (Exception e){
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return hrManagerList ;
    }

    public ObservableList<User> readUser(){
        ObservableList<User> userList = FXCollections.observableArrayList();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("User.bin");
            User user;
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("File doesn't exist");
                alert.showAndWait();
            }
            if(fis!=null){
                ois = new ObjectInputStream(fis);
            }
            while(true){
                user = (User) ois.readObject();
                userList.add(user);
            }
        }catch (Exception e){
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return userList ;
    }

}