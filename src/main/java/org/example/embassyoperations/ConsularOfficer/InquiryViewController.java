package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.HRManager.Calendar;
import org.example.embassyoperations.MainApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class InquiryViewController
{
    @javafx.fxml.FXML
    private TableColumn<Inquiry, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Inquiry, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableView<Inquiry> inquiryTableView;
    @javafx.fxml.FXML
    private TextField enterInquiryIdTextField;
    @javafx.fxml.FXML
    private TableColumn<Inquiry, String> applicantIdCol;
    @javafx.fxml.FXML
    private TableColumn<Inquiry, String> inquiryIdCol;

    private ConsularOfficerDashboardController dashboard;

    public void setDashboard(ConsularOfficerDashboardController dashboard){
        this.dashboard = dashboard;
    }

    @javafx.fxml.FXML
    public void initialize() {
        Inquiry a1 = new Inquiry("2311339","Do I need to submit XY document?");
        Inquiry a2 = new Inquiry("2211339","Do I need to submit YZ document?");
        Inquiry a3 = new Inquiry("2411339","Do I need to submit AZ document?");
        Inquiry.writeInquiryInfo(a1);
        Inquiry.writeInquiryInfo(a2);
        Inquiry.writeInquiryInfo(a3);

        statusCol.setCellValueFactory(new PropertyValueFactory<Inquiry, String>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Inquiry, LocalDate>("inquiryDate"));
        applicantIdCol.setCellValueFactory(new PropertyValueFactory<Inquiry, String>("applicantID"));
        inquiryIdCol.setCellValueFactory(new PropertyValueFactory<Inquiry, String>("inquiryID"));
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(enterInquiryIdTextField.getText().isEmpty()){
            alert.setContentText("Invalid Inquiry ID");
            alert.setContentText("Please enter inquiry id");
            alert.showAndWait();
            return;
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/InquiryDetailsView.fxml"));
            Parent root = fxmlLoader.load();

            InquiryDetailsViewController controller = fxmlLoader.getController();
            controller.setInquiryDetail(enterInquiryIdTextField.getText());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Inquiry Details");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void loadTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<Inquiry> list = new ArrayList<>();
        File f = new File("InquiryInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Inquiry c = (Inquiry) ois.readObject();
                if(c.getStatus().equals("Pending")){
                    list.add(c);
                }
            }
        }catch(Exception e){
            //
        }
        inquiryTableView.getItems().clear();
        inquiryTableView.getItems().addAll(list);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            dashboard.setHomePage();
        } catch (Exception e) {
            //
        }
    }
}


