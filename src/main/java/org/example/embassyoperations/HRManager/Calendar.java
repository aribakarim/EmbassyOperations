package org.example.embassyoperations.HRManager;

import org.example.embassyoperations.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Calendar implements Serializable {
    private String eventID, event,time;
    private LocalDate eventDate;

    public Calendar(String event, String time, LocalDate eventDate) {
        this.eventID = generateID();
        this.event = event;
        this.time = time;
        this.eventDate = eventDate;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "eventID='" + eventID + '\'' +
                ", event='" + event + '\'' +
                ", time='" + time + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }

    private String generateID(){
        Random r = new Random();
        int num = r.nextInt(10000,999999);
        String str = Integer.toString(num);
        return str;
    }

    public static void writeCalendarInfo(Calendar calendar){
        File f = new File("CalendarInfo.bin");
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
            oos.writeObject(calendar);
            oos.close();
        }catch(Exception e){
            //
        }
    }
}
