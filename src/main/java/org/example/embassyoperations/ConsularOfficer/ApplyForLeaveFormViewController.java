package org.example.embassyoperations.ConsularOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.embassyoperations.LoginViewController;
import org.example.embassyoperations.User;

import java.time.LocalDate;

public class ApplyForLeaveFormViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> employeeCombobox;
    @javafx.fxml.FXML
    private DatePicker endDateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> designationComboBox;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;
    @javafx.fxml.FXML
    private TextArea reasonTextArea;

    private ConsularOfficer loggedInOfficer;

    public void setLoggedInOfficer(ConsularOfficer loggedInOfficer) {
        this.loggedInOfficer = loggedInOfficer;
    }

    private ObservableList<User> employee = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("Consular Officer","HR Manager");
    }

    @javafx.fxml.FXML
    public void applyButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (designationComboBox.getValue() == null) {
            alert.setTitle("Invalid Designation");
            alert.setContentText("Please select a designation");
            alert.showAndWait();
            return;
        }
        if (employeeCombobox.getValue() == null) {
            alert.setTitle("Invalid Employee");
            alert.setContentText("Please select an employee");
            alert.showAndWait();
            return;
        }
        if (startDateDatePicker.getValue() == null) {
            alert.setTitle("Invalid Start Date");
            alert.setContentText("Please select a start date");
            alert.showAndWait();
            return;
        }
        if (endDateDatePicker.getValue() == null) {
            alert.setTitle("Invalid End Date");
            alert.setContentText("Please select an end Date");
            alert.showAndWait();
            return;
        }
        if (startDateDatePicker.getValue().isBefore(LocalDate.now())) {
            alert.setTitle("Invalid start date");
            alert.setContentText("Start date cannot be before current date!");
            alert.showAndWait();
            return;
        }
        if(endDateDatePicker.getValue().isBefore(startDateDatePicker.getValue())){
            alert.setTitle("Invalid Date");
            alert.setContentText("End date cannot be before start date!");
            alert.showAndWait();
            return;
        }
        if(reasonTextArea.getText().isEmpty()){
            alert.setTitle("Invalid Reason Date");
            alert.setContentText("Please enter reason for leave");
            alert.showAndWait();
            return;
        }

        LeaveRequest req = new LeaveRequest(loggedInOfficer.getId(),loggedInOfficer.getUsertype(),reasonTextArea.getText(),startDateDatePicker.getValue(),endDateDatePicker.getValue());
        LeaveRequest.writeLeaveRequest(req);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setContentText("Request submitted successfully");
        alert2.showAndWait();
        designationComboBox.setValue("");
        employeeCombobox.setValue("");
        startDateDatePicker.setValue(null);
        endDateDatePicker.setValue(null);
        reasonTextArea.clear();

    }

    @javafx.fxml.FXML
    public void designationComboBoxOnAction(ActionEvent actionEvent) {
        employeeCombobox.getItems().clear();
        employee.clear();
        LoginViewController controller = new LoginViewController();
        if (designationComboBox.getValue().equals("Consular Officer")) {
            try {
                employee.addAll(controller.readConsularOfficer());
                for (User hr : employee) {
                    employeeCombobox.getItems().add(hr.getName() + "-" + hr.getId());
                }
            } catch (Exception e) {
                //
            }
        }
    }
}