package org.example.embassyoperations;

public class CreatNewAccount {
    private String Name,Email,Password,Nationality;
    private Integer MobileNo;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "CreatNewAccount{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Nationality='" + Nationality + '\'' +
                ", MobileNo=" + MobileNo +
                '}';
    }

    public Integer getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(Integer mobileNo) {
        MobileNo = mobileNo;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public CreatNewAccount(String name, Integer mobileNo, String nationality, String password, String email) {
        Name = name;
        MobileNo = mobileNo;
        Nationality = nationality;
        Password = password;
        Email = email;
    }
}
