package org.example.embassyoperations.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.ConsularOfficer.LeaveRequest;
import org.example.embassyoperations.MainApplication;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarViewController
{
    @javafx.fxml.FXML
    private TableColumn<Calendar, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Calendar, String> eventCol;
    @javafx.fxml.FXML
    private TableView<Calendar> calendartableView;
    @javafx.fxml.FXML
    private TableColumn<Calendar, String> timeCol;
    @javafx.fxml.FXML
    private TableColumn<Calendar, String> eventIdCol;
    @javafx.fxml.FXML
    private TextField eventIdTextField;

    private HRManagerDashboardController dashboard;
    void setDashboard(HRManagerDashboardController dashboard){
        this.dashboard = dashboard;
    }

    @javafx.fxml.FXML
    public void initialize() {
        eventCol.setCellValueFactory(new PropertyValueFactory<Calendar, String>("event"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Calendar, LocalDate>("eventDate"));
        timeCol.setCellValueFactory(new PropertyValueFactory<Calendar, String>("time"));
        eventIdCol.setCellValueFactory(new PropertyValueFactory<Calendar, String>("eventID"));
    }

    @javafx.fxml.FXML
    public void addNewEventButtonOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HRManager/CalendarCreateEventView.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Calendar Create Event");
            stage.setScene(scene);
            stage.show();

        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void deleteButtonOnAction(ActionEvent actionEvent) {
        ArrayList<Calendar> list = new ArrayList<>();
        File f = new File("CalendarInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Calendar c = (Calendar) ois.readObject();
                if(!(eventIdTextField.getText().equals(c.getEventID()))){
                    list.add(c);
                }
            }
        }catch(Exception e){
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (Calendar r : list) {
                oos.writeObject(r);
            }
        }catch(Exception e){
            //
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Event successfully deleted");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void loadTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<Calendar> list = new ArrayList<>();
        File f = new File("CalendarInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Calendar c = (Calendar) ois.readObject();
                list.add(c);
            }
        }catch(Exception e){
            //
        }
        calendartableView.getItems().clear();
        calendartableView.getItems().addAll(list);
    }
}