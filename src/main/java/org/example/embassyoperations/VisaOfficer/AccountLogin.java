package org.example.embassyoperations;

public class AccountLogin {
    private String Email;
    private String Password;

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "AccountLogin{" +
                "Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        Password = password;
    }

    public AccountLogin(String email, String password) {
        Email = email;
        Password = password;
    }
}
