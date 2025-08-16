package org.example.embassyoperations;

import java.time.LocalDate;

public class RequestAdditionalDocument {
    private String Name,PassportNumber,VisaType,Nationality;
    private LocalDate RequestDate;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "RequestAdditionalDocument{" +
                "Name='" + Name + '\'' +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", VisaType='" + VisaType + '\'' +
                ", Nationality='" + Nationality + '\'' +
                ", RequestDate=" + RequestDate +
                '}';
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

    public LocalDate getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        RequestDate = requestDate;
    }

    public RequestAdditionalDocument(String name, String passportNumber, String visaType, String nationality, LocalDate requestDate) {
        Name = name;
        PassportNumber = passportNumber;
        VisaType = visaType;
        Nationality = nationality;
        RequestDate = requestDate;
    }
}
