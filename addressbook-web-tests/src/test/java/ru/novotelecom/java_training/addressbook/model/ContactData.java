package ru.novotelecom.java_training.addressbook.model;

public class ContactData {
    private int id;
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
    private String group;

    public ContactData(int id,String firstname, String midname, String lastname, String addres, String firstHomePhone, String mobilePhone, String workPhone, String firstEmail, String secondEmail, String thirdEmail, String secondHomePhone, String group) {
        this.id = id;
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
        this.group = group;
    }

    public ContactData(String firstname, String midname, String lastname, String addres, String firstHomePhone, String mobilePhone, String workPhone, String firstEmail, String secondEmail, String thirdEmail, String secondHomePhone, String group) {
        this.id = Integer.MAX_VALUE;
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
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
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
}
