package org.example.embassyoperations.HRManager;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.embassyoperations.User;

import java.io.*;
import java.util.ArrayList;

public class EditProfileViewController
{

    private HRManager loggedInOfficer;
    @javafx.fxml.FXML
    private Label employeeIDLabel;
    @javafx.fxml.FXML
    private Label designationLabel;
    @javafx.fxml.FXML
    private TextArea changeTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> optionComboBox;
    @javafx.fxml.FXML
    private DatePicker changeDateDatePicker;

    void setLoggedInOfficer(HRManager officer){
        this.loggedInOfficer = officer;
    }
    void setEmployeeID(HRManager officer){
        employeeIDLabel.setText(officer.getId());
    }
    @javafx.fxml.FXML
    public void initialize() {
        optionComboBox.getItems().addAll("Name","NID","Email","Address","Password","Phone No","Date of Birth");
    }

    @javafx.fxml.FXML
    public void saveChangesButtonOnAction(ActionEvent actionEvent) {
        if(optionComboBox.getValue().equals("Name")){
            changeInfo("Name");
        }
        else if(optionComboBox.getValue().equals("NID")){
            changeInfo("NID");
        }
        else if(optionComboBox.getValue().equals("Email")){
            changeInfo("Email");
        }
        else if(optionComboBox.getValue().equals("Address")){
            changeInfo("Address");
        }
        else if(optionComboBox.getValue().equals("Password")){
            changeInfo("Password");
        }
        else if(optionComboBox.getValue().equals("Phone No")){
            changeInfo("Phone No");
        }
        else if(optionComboBox.getValue().equals("Date of Birth")){
            changeInfo("Date of Birth");
        }
    }
    @javafx.fxml.FXML
    public void optionComboBoxButtonOnAction(ActionEvent actionEvent) {
        if(optionComboBox.getValue().equals("Date of Birth")){
            changeDateDatePicker.setDisable(false);
            changeTextArea.setDisable(true);
        }
    }

    private void changeInfo(String str){
        ArrayList<User> userList = new ArrayList<>();
        File f = new File("User.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                User user = (User) ois.readObject();
                if(user.getId().equals(loggedInOfficer.getId())){
                    if(str.equals("Name")){
                        user.setName(changeTextArea.getText());
                        userList.add(user);
                    }
                    else if(str.equals("NID")){
                        user.setNid(changeTextArea.getText());
                        userList.add(user);
                    }
                    else if(str.equals("Email")){
                        user.setEmail(changeTextArea.getText());
                        userList.add(user);
                    }
                    else if(str.equals("Address")){
                        user.setAddress(changeTextArea.getText());
                        userList.add(user);
                    }
                    else if(str.equals("Phone No")){
                        user.setPhoneNo(changeTextArea.getText());
                        userList.add(user);
                    }
                    else if(str.equals("Date of Birth")){
                        user.setDob(changeDateDatePicker.getValue());
                        userList.add(user);
                    }
                }
                else{
                    userList.add(user);
                }
            }
        }catch(Exception e){
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (User r : userList) {
                oos.writeObject(r);
            }
        }catch(Exception e){
            //
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Changes successfully saved");
        alert.showAndWait();
    }
}