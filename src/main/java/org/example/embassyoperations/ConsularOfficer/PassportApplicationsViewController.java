package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.embassyoperations.HRManager.LeaveRequestDetailsViewController;
import org.example.embassyoperations.MainApplication;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PassportApplicationsViewController {
    @javafx.fxml.FXML
    private TableColumn<PassportApplication, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<PassportApplication, String> statusCol;
    @javafx.fxml.FXML
    private TableView<PassportApplication> passportApplicationTableView;
    @javafx.fxml.FXML
    private TableColumn<PassportApplication, String> applicantIdCol;
    @javafx.fxml.FXML
    private TextField enterApplicationIdTextField;
    @javafx.fxml.FXML
    private TableColumn<PassportApplication, String> applicationIdCol;

    private ConsularOfficer loggedInOfficer;

    public void setLoggedInOfficer(ConsularOfficer consularOfficer) {
        this.loggedInOfficer = consularOfficer;
    }

    private ConsularOfficerDashboardController dashboard;

    public void setDashboard(ConsularOfficerDashboardController dashboard) {
        this.dashboard = dashboard;
    }


    @javafx.fxml.FXML
    public void initialize() {
        dateCol.setCellValueFactory(new PropertyValueFactory<PassportApplication, LocalDate>("dateOfApplication"));
        statusCol.setCellValueFactory(new PropertyValueFactory<PassportApplication, String>("status"));
        applicantIdCol.setCellValueFactory(new PropertyValueFactory<PassportApplication, String>("applicantId"));
        applicationIdCol.setCellValueFactory(new PropertyValueFactory<PassportApplication, String>("applicationId"));

//        PassportApplication p1 = new PassportApplication("Mrittika","1234","AG8148412","5566","Bangladeshi");
//        PassportApplication p2 = new PassportApplication("Orin","5678","AA0008412","6466","Bangladeshi");
//        PassportApplication p3 = new PassportApplication("Fateeha","4567","A0000000","4949","Bangladeshi");
//        PassportApplication p4 = new PassportApplication("Tashfia","8910","A03295451","2222","Bangladeshi");
//        PassportApplication p5 = new PassportApplication("Erika","1112","AG5168412","7878","Bangladeshi");
//        PassportApplication.writePassportApplicationInfo(p1);
//        PassportApplication.writePassportApplicationInfo(p2);
//        PassportApplication.writePassportApplicationInfo(p3);
//        PassportApplication.writePassportApplicationInfo(p4);
//        PassportApplication.writePassportApplicationInfo(p5);
    }

    @javafx.fxml.FXML
    public void approveButtonOnAction(ActionEvent actionEvent) {
        ArrayList<PassportApplication> list = new ArrayList<>();
        File f = new File("PassportApplicationInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                PassportApplication req = (PassportApplication) ois.readObject();
                if (!(enterApplicationIdTextField.getText().equals(req.getApplicationId()))) {
                    list.add(req);
                } else {
                    req.setStatus("Approved");
                    req.setProcessedById(this.loggedInOfficer.getId());
                    list.add(req);
                }
            }
        } catch (Exception e) {
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (PassportApplication r : list) {
                oos.writeObject(r);
            }
        } catch (Exception e) {
            //
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Passport Application successfully approved");
        alert.showAndWait();
        enterApplicationIdTextField.clear();
    }


    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (enterApplicationIdTextField.getText().isEmpty()) {
            alert.setContentText("Invalid Application ID");
            alert.setContentText("Please enter application id");
            alert.showAndWait();
            return;
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ConsularOfficer/PassportApplicationDetailsView.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Leave Request Detail");
            stage.setScene(scene);
            PassportApplicationDetailsViewController controller = fxmlLoader.getController();
            controller.setPassportApplicationInfo(enterApplicationIdTextField.getText());
            stage.show();

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void loadTableButtonOnAction(ActionEvent actionEvent) {
        ArrayList<PassportApplication> list = new ArrayList<>();
        File f = new File("PassportApplicationInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                PassportApplication p = (PassportApplication) ois.readObject();
                if (p.getStatus().equals("Pending")) {
                    list.add(p);
                }
            }
        } catch (Exception e) {
            //
        }
        passportApplicationTableView.getItems().clear();
        passportApplicationTableView.getItems().addAll(list);

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
    public void rejectButtonOnAction(ActionEvent actionEvent) {
        ArrayList<PassportApplication> list = new ArrayList<>();
        File f = new File("PassportApplicationInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                PassportApplication req = (PassportApplication) ois.readObject();
                if (!(enterApplicationIdTextField.getText().equals(req.getApplicationId()))) {
                    list.add(req);
                } else {
                    req.setStatus("Rejected");
                    req.setProcessedById(this.loggedInOfficer.getId());
                    list.add(req);
                }
            }
        } catch (Exception e) {
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (PassportApplication r : list) {
                oos.writeObject(r);
            }
        } catch (Exception e) {
            //
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Passport Application successfully rejected");
        alert.showAndWait();
        enterApplicationIdTextField.clear();
    }
}
