package org.example.embassyoperations.ConsularOfficer;

import javafx.scene.control.TextArea;
import org.example.embassyoperations.HRManager.Announcement;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class NotificationsDetailsViewController {
    @javafx.fxml.FXML
    private TextArea notificationDetailTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    void setNotificationDetail(String id){
        File f = new File("AnnouncementInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Announcement a = (Announcement) ois.readObject();
                if(id.equals(a.getAnnouncementID())){
                    notificationDetailTextArea.setText(a.toString());
                    return;
                }
            }
        }catch(Exception e){
            //
        }
    }

}