package org.example.embassyoperations;

import java.time.LocalDate;

public class ApplyForAVisa {
    private String Name,Division,FatherName,MotherName,PurposeForTravel;
    private Integer NIDno,MobileNo;
    private LocalDate TravelDate;

    public String getName() {
        return Name;
    }

    public String getDivision() {
        return Division;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "ApplyForAVisa{" +
                "Name='" + Name + '\'' +
                ", Division='" + Division + '\'' +
                ", FatherName='" + FatherName + '\'' +
                ", MotherName='" + MotherName + '\'' +
                ", PurposeForTravel='" + PurposeForTravel + '\'' +
                ", NIDno=" + NIDno +
                ", MobileNo=" + MobileNo +
                ", TravelDate=" + TravelDate +
                '}';
    }

    public void setTravelDate(LocalDate travelDate) {
        TravelDate = travelDate;
    }

    public void setMobileNo(Integer mobileNo) {
        MobileNo = mobileNo;
    }

    public void setNIDno(Integer NIDno) {
        this.NIDno = NIDno;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public void setPurposeForTravel(String purposeForTravel) {
        PurposeForTravel = purposeForTravel;
    }

    public String getFatherName() {
        return FatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public String getPurposeForTravel() {
        return PurposeForTravel;
    }

    public Integer getNIDno() {
        return NIDno;
    }

    public LocalDate getTravelDate() {
        return TravelDate;
    }

    public Integer getMobileNo() {
        return MobileNo;
    }

    public ApplyForAVisa(String purposeForTravel, String name, String division, String fatherName, String motherName, Integer NIDno, Integer mobileNo, LocalDate travelDate) {
        PurposeForTravel = purposeForTravel;
        Name = name;
        Division = division;
        FatherName = fatherName;
        MotherName = motherName;
        this.NIDno = NIDno;
        MobileNo = mobileNo;
        TravelDate = travelDate;
    }
}
