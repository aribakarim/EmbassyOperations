package org.example.embassyoperations;

import java.time.LocalDate;

public class VarifyAuthenticity {
    private String Name,PassportNumber,DocumentStatus;
    private LocalDate Date;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "VarifyAuthenticity{" +
                "Name='" + Name + '\'' +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", DocumentStatus='" + DocumentStatus + '\'' +
                ", Date=" + Date +
                '}';
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getDocumentStatus() {
        return DocumentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        DocumentStatus = documentStatus;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public VarifyAuthenticity(String name, String passportNumber, String documentStatus, LocalDate date) {
        Name = name;
        PassportNumber = passportNumber;
        DocumentStatus = documentStatus;
        Date = date;
    }
}
