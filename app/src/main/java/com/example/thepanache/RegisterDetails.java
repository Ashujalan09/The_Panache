package com.example.thepanache;

public class RegisterDetails {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;

    public RegisterDetails(){}

    public RegisterDetails(String firstName, String lastName, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
