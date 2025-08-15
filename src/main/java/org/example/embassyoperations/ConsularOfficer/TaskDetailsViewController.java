package org.example.embassyoperations.ConsularOfficer;

import javafx.scene.control.TextArea;
import org.example.embassyoperations.HRManager.Announcement;
import org.example.embassyoperations.HRManager.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TaskDetailsViewController
{
    @javafx.fxml.FXML
    private TextArea taskDetailTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    void setTaskDetail(String id){
        File f = new File("TaskInfo.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                Task t = (Task) ois.readObject();
                if(id.equals(t.getTaskID())){
                    taskDetailTextArea.setText(t.toString());
                    return;
                }
            }
        }catch(Exception e){
            //
        }
    }
}