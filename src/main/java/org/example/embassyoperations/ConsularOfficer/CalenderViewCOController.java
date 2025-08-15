package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.embassyoperations.HRManager.Calendar;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalenderViewCOController
{
    @javafx.fxml.FXML
    private TableColumn<Calendar, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Calendar, String> eventIdCol;
    @javafx.fxml.FXML
    private TableColumn<Calendar, String> eventCol;
    @javafx.fxml.FXML
    private TableView<Calendar> calendartableView;
    @javafx.fxml.FXML
    private TableColumn<Calendar, String> timeCol;

    private ConsularOfficerDashboardController dashboard;

    public void setDashboard(ConsularOfficerDashboardController dashboard){
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