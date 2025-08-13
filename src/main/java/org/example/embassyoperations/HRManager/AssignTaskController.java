package org.example.embassyoperations.HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import org.example.embassyoperations.LoginViewController;
import org.example.embassyoperations.MainApplication;
import org.example.embassyoperations.User;

import java.time.LocalDate;

public class AssignTaskController {
    @javafx.fxml.FXML
    private ComboBox<String> employeeComboBox;
    @javafx.fxml.FXML
    private TextArea taskDescriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> designationComboBox;
    @javafx.fxml.FXML
    private DatePicker dueDateDatePicker;

    private HRManager loggedInOfficer;
    private HRManagerDashboardController dashboard;

    void setDashboard(HRManagerDashboardController dashboard) {
        this.dashboard = dashboard;
    }

    void setLoggedInOfficer(HRManager loggedInOfficer) {
        this.loggedInOfficer = loggedInOfficer;
    }

    private ObservableList<User> employee = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("HR Manager", "ConsularOfficer");
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
    public void assignTaskButtonOnAction(ActionEvent actionEvent) {
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
        if (dueDateDatePicker.getValue() == null) {
            alert.setTitle("Invalid Due Date");
            alert.setContentText("Please select a due date");
            alert.showAndWait();
            return;
        }
        if (taskDescriptionTextArea.getText().isEmpty()) {
            alert.setTitle("Invalid Task Description");
            alert.setContentText("Please enter task description");
            alert.showAndWait();
            return;
        }

        String taskDescription = taskDescriptionTextArea.getText();
        LocalDate dueDate = dueDateDatePicker.getValue();

        Task newTask = new Task(loggedInOfficer.getId(), taskDescription, dueDate);
        this.loggedInOfficer.assignTask(newTask);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setTitle("Request successfully submitted!");
        alert2.showAndWait();

        designationComboBox.setValue("");
        employeeComboBox.setValue("");
        dueDateDatePicker.setValue(null);
        taskDescriptionTextArea.clear();
    }

    @javafx.fxml.FXML
    public void designationComboBoxOnAction(ActionEvent actionEvent) {
        employeeComboBox.getItems().clear();
        employee.clear();
        LoginViewController controller = new LoginViewController();
        if (designationComboBox.getValue().equals("ConsularOfficer")) {
            try {
                employee.addAll(controller.readConsularOfficer());
                for (User hr : employee) {
                    employeeComboBox.getItems().add(hr.getName() + "-" + hr.getId());
                }
            } catch (Exception e) {
                //
            }
        }
        else if(designationComboBox.getValue().equals("HR Manager")){
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
}