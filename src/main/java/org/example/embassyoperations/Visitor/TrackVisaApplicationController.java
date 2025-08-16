package org.example.embassyoperations.Visitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackVisaApplicationController
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TableColumn colName;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableView visaStatusTable;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TextField applicationIDField;
    @javafx.fxml.FXML
    private TableColumn colRemarks;
    @javafx.fxml.FXML
    private TableColumn colSubmissionDate;
    @javafx.fxml.FXML
    private TableColumn colApplicationId;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    private void goBackToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getclass().getsource("VisitorDashboard.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}