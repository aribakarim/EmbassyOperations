package org.example.embassyoperations;

import java.time.LocalDate;

public class VarifyVisaApplication {
    private String Name,VisaType,Reason,PassportNumber,Nationality;
    private LocalDate Date;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "VarifyVisaApplication{" +
                "Name='" + Name + '\'' +
                ", VisaType='" + VisaType + '\'' +
                ", Reason='" + Reason + '\'' +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", Nationality='" + Nationality + '\'' +
                ", Date=" + Date +
                '}';
    }

    public String getVisaType() {
        return VisaType;
    }

    public void setVisaType(String visaType) {
        VisaType = visaType;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public VarifyVisaApplication(String name, String visaType, String reason, String passportNumber, String nationality, LocalDate date) {
        Name = name;
        VisaType = visaType;
        Reason = reason;
        PassportNumber = passportNumber;
        Nationality = nationality;
        Date = date;
    }
}
