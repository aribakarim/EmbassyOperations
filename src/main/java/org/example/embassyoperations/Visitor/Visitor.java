package org.example.embassyoperations.Visitor;

public class Visitor {
    private int visaApplicationCount;

    public Visitor( int visaApplicationCount){
        this.visaApplicationCount = visaApplicationCount;
    }

    public int getVisaApplicationCount() {
        return visaApplicationCount;
    }

    public void setVisaApplicationCount(int visaApplicationCount) {
        this.visaApplicationCount = visaApplicationCount;
    }

    public void applyForVisa(){
        System.out.println("Apply For Visa");
    }
    public void askQuestion(){
        System.out.println("Ask Question");

    }
    public void bookAppointment(){
        System.out.println("Book For Appointment");
    }
    public void cancelApplication(){
        System.out.println("Cancel Visa Application");
    }
    public void submitDocument(){
        System.out.println("Submit Additional Documents");
    }
    public void trackApplication(){
        System.out.println("Track Visa Application");
    }
    public void urgentProcessing(){
        System.out.println("Urgent Visa Processing");
    }
}
