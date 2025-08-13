package org.example.embassyoperations.HRManager;

import org.example.embassyoperations.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Announcement implements Serializable {
    private String announcementID,message,title;
    private LocalDate date;

    public Announcement(String message, String title) {
        this.announcementID = generateID();
        this.message = message;
        this.date = LocalDate.now();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(String announcementID) {
        this.announcementID = announcementID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementID='" + announcementID + '\'' +
                ", message='" + message + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }

    private String generateID(){
        Random r = new Random();
        int num = r.nextInt(10000,999999);
        String str = Integer.toString(num);
        return str;
    }

    public static void writeAnnouncementInfo(Announcement announcement){
        File f = new File("AnnouncementInfo.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(announcement);
            oos.close();
        }catch(Exception e){
            //
        }
    }
}
