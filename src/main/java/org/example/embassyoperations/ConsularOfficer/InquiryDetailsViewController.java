package org.example.embassyoperations.ConsularOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import org.example.embassyoperations.HRManager.Announcement;

import java.io.*;
import java.util.ArrayList;

public class InquiryDetailsViewController
{
    @javafx.fxml.FXML
    private TextArea responseTextArea;
    @javafx.fxml.FXML
    private TextArea inquiryDetailTextArea;

    private String InquiryId;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitResponseButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(responseTextArea.getText().isEmpty()){
            alert.setContentText("Invalid response");
            alert.setContentText("Please enter response");
            alert.showAndWait();
            return;
        }
        ArrayList<Inquiry> list = new ArrayList<>();
        File f = new File("InquiryInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Inquiry a = (Inquiry) ois.readObject();
                if(!(InquiryId.equals(a.getInquiryID()))){
                    list.add(a);
                }
                else{
                    a.setStatus("Resolved");
                    a.setResponse(responseTextArea.getText());
                    list.add(a);
                }
            }
        }catch(Exception e){
            //
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (Inquiry r : list) {
                oos.writeObject(r);
            }
        }catch(Exception e){
            //
        }
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setContentText("Response successfully sent");
        alert2.showAndWait();
        responseTextArea.clear();
    }

    void setInquiryDetail(String id){
        File f = new File("InquiryInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Inquiry a = (Inquiry) ois.readObject();
                if(id.equals(a.getInquiryID())){
                    InquiryId = a.getInquiryID();
                    inquiryDetailTextArea.setText(a.toString());
                    return;
                }
            }
        }catch(Exception e){
            //
        }
    }
}