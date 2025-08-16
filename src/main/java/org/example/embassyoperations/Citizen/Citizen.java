package org.example.embassyoperations.Citizen;

public class Citizen {
    private String passportNumber;
    private String nidNumber;

    public Citizen( String passportNumber, String nidNumber){

        this.passportNumber = passportNumber;
        this.nidNumber = nidNumber;
    }
    public Citizen(){

    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNidNumber() {
        return nidNumber;
    }

    public void setNidNumber(String nidNumber) {
        this.nidNumber = nidNumber;
    }
    public void applyForPassportRenewal(){
        System.out.println("Apply for Passport Renewal");
    }
    public void requestEmergencyTravelDoc(){
        System.out.println("Emergency Travel Document");
    }
    public void requestAttestation(){
        System.out.println("Request Document Attestation");
    }
    public void registerForNID(){
        System.out.println("Register NID");
    }
    public void fileComplaint(){
        System.out.println("File Complaint");
    }
    public void requestCitizenshipCertificate(){
        System.out.println("Citizenship Certificate");
    }
    public void contactConsularOffice(){
        System.out.println("Contact Consular");
    }

    public void requestEmargencyAsistance(){
        System.out.println("Emargency Assistance");
    }
}
