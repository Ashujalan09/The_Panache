package ModelClassPackage;

public class UserData {

    String FirstName;
    String LastName;
    String PhoneNumber;
    String Address;
    String Email;
    String UserId;

    public UserData(){}

    public UserData(String firstName, String lastName, String phoneNumber, String address, String email, String userId) {
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Address = address;
        Email = email;
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    public String getUserId() {
        return UserId;
    }
}
