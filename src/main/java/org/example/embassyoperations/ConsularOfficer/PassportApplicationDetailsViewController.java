package org.example.embassyoperations.ConsularOfficer;

import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PassportApplicationDetailsViewController
{
    @javafx.fxml.FXML
    private TextArea applicationInfoTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    void setPassportApplicationInfo(String id){
        File f = new File("PassportApplicationInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                PassportApplication req = (PassportApplication) ois.readObject();
                if(id.equals(req.getApplicationId())){
                    applicationInfoTextArea.setText(req.toString());
                    return;
                }
            }
        }catch(Exception e){
            //
        }
    }
}