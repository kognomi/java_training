package ru.novotelecom.java_training.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String midname;
    private final String lastname;
    private final String addres;
    private final String firstHomePhone;
    private final String mobilePhone;
    private final String workPhone;
    private final String firstEmail;
    private final String secondEmail;
    private final String thirdEmail;
    private final String secondHomePhone;

    public ContactData(String firstname, String midname, String lastname, String addres, String firstHomePhone, String mobilePhone, String workPhone, String firstEmail, String secondEmail, String thirdEmail, String secondHomePhone) {
        this.firstname = firstname;
        this.midname = midname;
        this.lastname = lastname;
        this.addres = addres;
        this.firstHomePhone = firstHomePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.thirdEmail = thirdEmail;
        this.secondHomePhone = secondHomePhone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMidname() {
        return midname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddres() {
        return addres;
    }

    public String getFirstHomePhone() {
        return firstHomePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getThirdEmail() {
        return thirdEmail;
    }

    public String getSecondHomePhone() {
        return secondHomePhone;
    }
}
