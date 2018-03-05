package ru.novotelecom.java_training.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String midname;
    private String lastname;
    private String addres;
    private String firstHomePhone;
    private String mobilePhone;
    private String workPhone;
    private String firstEmail;
    private String secondEmail;
    private String thirdEmail;
    private String secondHomePhone;
    private String group;
    private String allPhones;
    private String allEmails;




    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;

    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMidname(String midname) {
        this.midname = midname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddres(String addres) {
        this.addres = addres;
        return this;
    }

    public ContactData withFirstHomePhone(String firstHomePhone) {
        this.firstHomePhone = firstHomePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
        return this;
    }

    public ContactData withSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
        return this;
    }

    public ContactData withThirdEmail(String thirdEmail) {
        this.thirdEmail = thirdEmail;
        return this;
    }

    public ContactData withSecondHomePhone(String secondHomePhone) {
        this.secondHomePhone = secondHomePhone;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
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

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmails() {
        return allEmails;
    }
}
