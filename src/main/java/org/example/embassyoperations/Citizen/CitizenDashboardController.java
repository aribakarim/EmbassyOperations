package org.example.embassyoperations.Citizen;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class CitizenDashboardController {

    private void switchScene(ActionEvent event, String fxmlFile)throws IOException{
        root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage = (Stage)((Node) event. getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    private Button PassportRenewal;
    @javafx.fxml.FXML
    private Button DocumentVerify;
    @javafx.fxml.FXML
    private Button RegisterNID;
    @javafx.fxml.FXML
    private Button EmargencyTravelDocument;
    @javafx.fxml.FXML
    private Button CitizenshipCertificate;
    @javafx.fxml.FXML
    private Button CnsularAssistancenInEmargency1;
    @javafx.fxml.FXML
    private Button Logout;
    @javafx.fxml.FXML
    private Button ComplaintaIssue;
    @javafx.fxml.FXML
    private Button SubmitInquiry;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void PassportRenewalOnAction(ActionEvent actionEvent) {
        switchScene(event,"/org/example/embassyoperations/Citizen/ApplyForPassportRenewal.fxml");
    }

    @javafx.fxml.FXML
    public void SubmitInquiryOnAction(ActionEvent actionEvent) {
        switchScene(event,"/org/example/embassyoperations/Citizen/SubmitInquiry.fxml");
    }

    @javafx.fxml.FXML
    public void CnsularAssistancenInEmargencyOnAction(ActionEvent actionEvent) {
        switchScene(event,"/org/example/embassyoperations/Citizen/EmargencyAssistance.fxml");
    }

    @javafx.fxml.FXML
    public void CitizenshipCertificateOnAction(ActionEvent actionEvent) {
        switchScene(event,"/org/example/embassyoperations/Citizen/CitizenshipCertificate.fxml");
    }

    @javafx.fxml.FXML
    public void DocumentVerifyOnAction(ActionEvent actionEvent) {
        switchScene(event,"/org/example/embassyoperations/Citizen/DocumentAttestation.fxml");
    }

    @javafx.fxml.FXML
    public void EmargencyTravelDocumentOnAction(ActionEvent actionEvent) {
        switchScene(event,"/org/example/embassyoperations/Citizen/EmargencyTravelDocument.fxml");
    }

    @javafx.fxml.FXML
    public void RegisterNIDOnAction(ActionEvent actionEvent) {
        switchScene(event,"/org/example/embassyoperations/Citizen/RegisterNID.fxml");

    }

    @javafx.fxml.FXML
    public void CmplaintIssueOnAction(ActionEvent actionEvent) {
        switchScene(event,"/org/example/embassyoperation/Citizen/FileComplaint.fxml");
    }


}