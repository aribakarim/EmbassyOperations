package org.example.embassyoperations;

public class ViewCurrentStatus {
    private String UserId,Password;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    @Override
    public String toString() {
        return "ViewCurrentStatus{" +
                "UserId='" + UserId + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public ViewCurrentStatus(String userId, String password) {
        UserId = userId;
        Password = password;
    }
}
