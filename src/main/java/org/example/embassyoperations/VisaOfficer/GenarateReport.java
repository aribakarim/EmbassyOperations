package org.example.embassyoperations;

import java.time.LocalDate;

public class GenarateReport {
    private String Name,PassportNumber;
    private LocalDate StartDate,EndDate;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "GenarateReport{" +
                "Name='" + Name + '\'' +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                '}';
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public GenarateReport(String name, String passportNumber, LocalDate startDate, LocalDate endDate) {
        Name = name;
        PassportNumber = passportNumber;
        StartDate = startDate;
        EndDate = endDate;
    }
}
