package org.example.embassyoperations.HRManager;

import javafx.scene.control.TextArea;
import org.example.embassyoperations.ConsularOfficer.LeaveRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LeaveRequestDetailsViewController
{
    @javafx.fxml.FXML
    private TextArea leaveRequestDetailTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    void setLeaveRequestInfo(String id){
        File f = new File("LeaveRequestInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                LeaveRequest req = (LeaveRequest) ois.readObject();
                if(id.equals(req.getRequestId())){
                    leaveRequestDetailTextArea.setText(req.toString());
                    return;
                }
            }
        }catch(Exception e){
            //
        }
    }
}