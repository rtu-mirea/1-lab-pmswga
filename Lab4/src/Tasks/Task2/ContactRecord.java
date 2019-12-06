package Tasks.Task2;

import java.util.Date;

public class ContactRecord {
    private String secondName;
    private String firstName;
    private String callNumber;
    private String dateBirthday;
    private String address;

    public ContactRecord(String secondName, String firstName, String callNumber, String dateBirthday, String address) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.callNumber = callNumber;
        this.dateBirthday = dateBirthday;
        this.address = address;
    }

    public String toString() {
        return this.secondName + " " + this.firstName + ", " + this.callNumber + ", " + this.dateBirthday + ", " + this.address;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
