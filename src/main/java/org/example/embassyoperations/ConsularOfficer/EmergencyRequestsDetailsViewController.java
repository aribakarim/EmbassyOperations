package org.example.embassyoperations.ConsularOfficer;

import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EmergencyRequestsDetailsViewController
{
    @javafx.fxml.FXML
    private TextArea requestDetailsTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }
    void setEmergencyRequestsInfo(String id){
        File f = new File("EmergencyRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                EmergencyRequest req = (EmergencyRequest) ois.readObject();
                if(id.equals(req.getRequestId())){
                    requestDetailsTextArea.setText(req.toString());
                    return;
                }
            }
        }catch(Exception e){
            //
        }
    }
}