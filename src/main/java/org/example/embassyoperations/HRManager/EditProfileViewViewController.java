package org.example.embassyoperations.HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.embassyoperations.CreateAccountController;
import org.example.embassyoperations.LoginViewController;
import org.example.embassyoperations.User;

import java.io.File;
import java.time.LocalDate;

public class EditProfileViewViewController
{
    @javafx.fxml.FXML
    private TextField phoneNoTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private DatePicker dobDatePicker;
    @javafx.fxml.FXML
    private TextArea addressTextArea;

    private HRManager loggedInOfficer;
    @javafx.fxml.FXML
    private TextField nidTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private Label employeeIDLabel;
    @javafx.fxml.FXML
    private Label designationLabel;

    void setLoggedInOfficer(HRManager officer){
        this.loggedInOfficer = officer;
    }
    void setEmployeeID(HRManager officer){
        employeeIDLabel.setText(officer.getId());
    }
    private ObservableList<User> employee = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveChangesButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String name, id, email, address, phoneNo, password, designation,nid;
        LocalDate dob;
        name = employeeNameTextField.getText();
        id = employeeIDLabel.getText();
        email = emailTextField.getText();
        address = addressTextArea.getText();
        phoneNo = phoneNoTextField.getText();
        designation = designationLabel.getText();
        password = passwordPF.getText();
        dob = dobDatePicker.getValue();
        nid = nidTextField.getText();

        if(!User.validatePassword(password)){
            alert.setTitle("Invalid Password");
            alert.setContentText("Password cannot contain characters");
            alert.showAndWait();
            return;
        }
        if(!User.validateName(name)){
            alert.setTitle("Invalid Name");
            alert.setContentText("Please enter proper name");
            alert.showAndWait();
            return;
        }

        LoginViewController controller = new LoginViewController();
        CreateAccountController controller2 = new CreateAccountController();
        employee.setAll(controller.readHRManager());
        File f = new File("HRManager.bin");
        File f1 = new File("User.bin");
        File f2 = new File("User.txt");
        if(f.exists()){
            f.delete();
            f1.delete();
            f2.delete();
        }
        try {
            for(User hr:employee){
                if(!hr.getId().equals(loggedInOfficer.getId())){
                    controller2.writeUser2(hr);
                    controller2.writeUser(hr);
                    controller2.writeHRManager((HRManager) hr);
                }
            }
            HRManager h = new HRManager(name,nid,email,address,password,designation,phoneNo,dob);
            controller2.writeUser2(h);
            controller2.writeUser(h);
            controller2.writeHRManager(h);
            loggedInOfficer = h;
        }catch (Exception e){
            //
        }

    }
}