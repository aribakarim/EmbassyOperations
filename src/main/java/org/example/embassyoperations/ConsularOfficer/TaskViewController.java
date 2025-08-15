package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.HRManager.Announcement;
import org.example.embassyoperations.HRManager.Task;
import org.example.embassyoperations.MainApplication;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskViewController
{
    @javafx.fxml.FXML
    private TableColumn<Task, LocalDate> dueDateCol;
    @javafx.fxml.FXML
    private TableColumn<Task,String> statusCol;
    @javafx.fxml.FXML
    private TextField enterTaskIdTextField;
    @javafx.fxml.FXML
    private TableView<Task> taskTableView;
    @javafx.fxml.FXML
    private TableColumn<Task,String> taskIdCol;

    private ConsularOfficer loggedInOfficer;

    public void setLoggedInOfficer(ConsularOfficer consularOfficer) {
        this.loggedInOfficer = consularOfficer;
    }
    private ConsularOfficerDashboardController dashboard;

    public void setDashboard(ConsularOfficerDashboardController dashboard){
        this.dashboard = dashboard;
    }

    @javafx.fxml.FXML
    public void initialize() {
        dueDateCol.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("dueDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Task,String>("status"));
        taskIdCol.setCellValueFactory(new PropertyValueFactory<Task,String>("taskID"));
    }

    @javafx.fxml.FXML
    public void markAsCompleteButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(enterTaskIdTextField.getText().isEmpty()){
            alert.setContentText("Invalid Task ID");
            alert.setContentText("Please enter task id");
            alert.showAndWait();
            return;
        }
        if (validation(this.loggedInOfficer)) {
            alert.setContentText("Task already completed");
            alert.showAndWait();
            return;
        }
        ArrayList<Task> taskList = new ArrayList<>();
        File f = new File("TaskInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Task t = (Task) ois.readObject();
                if(!(enterTaskIdTextField.getText().equals(t.getTaskID()))){
                    taskList.add(t);
                }
                else{
                    t.setStatus("Completed");
                    taskList.add(t);
                }
            }
        }catch(Exception e){
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (Task r : taskList) {
                oos.writeObject(r);
            }
        }catch(Exception e){
            //
        }
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setContentText("Task marked as completed");
        alert2.showAndWait();
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/TaskDetailsView.fxml"));
            Parent root = fxmlLoader.load();

            TaskDetailsViewController controller = fxmlLoader.getController();
            controller.setTaskDetail(enterTaskIdTextField.getText());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Task Details");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void loadTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<Task> list = new ArrayList<>();
        File f = new File("TaskInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                Task t = (Task) ois.readObject();
                if (t.getEmployeeID().equals(this.loggedInOfficer.getId())) {
                    list.add(t);
                }
            }
        }
        catch(Exception e){
            //
        }
        taskTableView.getItems().clear();
        taskTableView.getItems().addAll(list);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        } catch (Exception e) {
            //
        }
    }

    private boolean validation(ConsularOfficer c){
        boolean flag = false;
        File f = new File("TaskInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Task t = (Task) ois.readObject();
                if(t.getTaskID().equals(enterTaskIdTextField.getText()) && t.getStatus().equals("Completed")){
                    flag = true;
                }
            }
        }catch(Exception e){
            //
        }
        return flag;
    }
}