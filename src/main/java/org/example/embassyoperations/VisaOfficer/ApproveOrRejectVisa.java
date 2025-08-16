package org.example.embassyoperations;

import java.time.LocalDate;

public class ApproveOrRejectVisa {
    private String Name,PassportNumber,VisaType,Nationality,TravelReason;
    private LocalDate ApplicationDate;

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "ApproveOrRejectVisa{" +
                "Name='" + Name + '\'' +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", VisaType='" + VisaType + '\'' +
                ", Nationality='" + Nationality + '\'' +
                ", TravelReason='" + TravelReason + '\'' +
                ", ApplicationDate=" + ApplicationDate +
                '}';
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getVisaType() {
        return VisaType;
    }

    public void setVisaType(String visaType) {
        VisaType = visaType;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getTravelReason() {
        return TravelReason;
    }

    public void setTravelReason(String travelReason) {
        TravelReason = travelReason;
    }

    public LocalDate getApplicationDate() {
        return ApplicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        ApplicationDate = applicationDate;
    }

    public ApproveOrRejectVisa(LocalDate applicationDate, String visaType, String passportNumber, String name, String nationality, String travelReason) {
        ApplicationDate = applicationDate;
        VisaType = visaType;
        PassportNumber = passportNumber;
        Name = name;
        Nationality = nationality;
        TravelReason = travelReason;
    }
}
