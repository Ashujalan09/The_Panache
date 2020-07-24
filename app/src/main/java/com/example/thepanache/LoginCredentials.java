package com.example.thepanache;

public class LoginCredentials {

    private String number;

    private String password;

    public LoginCredentials(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
}
