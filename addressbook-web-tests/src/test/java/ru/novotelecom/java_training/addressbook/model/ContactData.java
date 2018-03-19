package ru.novotelecom.java_training.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="addressbook")
@XStreamAlias("contact")

public class ContactData {

    @Id
    @Column(name = "id")
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    @Expose
    private String firstname;

     @Column(name = "middlename")
    @Expose
    private String midname;

    @Column(name = "lastname")
    @Expose
    private String lastname;

    @Column(name = "address")
    @Type(type="text")
    @Expose
    private String address;

    @Column(name = "home")
    @Type(type="text")
    @Expose
    private String firstHomePhone;

    @Column(name = "mobile")
    @Type(type="text")
    @Expose
    private String mobilePhone;

    @Column(name = "work")
    @Type(type="text")
    @Expose
    private String workPhone;

    @Column(name = "email")
    @Type(type="text")
    @Expose
    private String firstEmail;

    @Column(name = "email2")
    @Type(type="text")
    @Expose
    private String secondEmail;

    @Column(name = "email3")
    @Type(type="text")
    @Expose
    private String thirdEmail;

    @Column(name = "phone2")
    @Type(type="text")
    @Expose
    private String secondHomePhone;


    @Transient
    private String allPhones;
    @Transient
    private String allEmails;

    @Column(name = "photo")
    @Type(type="text")
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();



    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

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

    public ContactData withAddress(String address) {
        this.address = address;
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
        if (midname != null ? !midname.equals(that.midname) : that.midname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (firstHomePhone != null ? !firstHomePhone.equals(that.firstHomePhone) : that.firstHomePhone != null)
            return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
        if (firstEmail != null ? !firstEmail.equals(that.firstEmail) : that.firstEmail != null) return false;
        if (secondEmail != null ? !secondEmail.equals(that.secondEmail) : that.secondEmail != null) return false;
        if (thirdEmail != null ? !thirdEmail.equals(that.thirdEmail) : that.thirdEmail != null) return false;
        return secondHomePhone != null ? secondHomePhone.equals(that.secondHomePhone) : that.secondHomePhone == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (midname != null ? midname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (firstHomePhone != null ? firstHomePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (firstEmail != null ? firstEmail.hashCode() : 0);
        result = 31 * result + (secondEmail != null ? secondEmail.hashCode() : 0);
        result = 31 * result + (thirdEmail != null ? thirdEmail.hashCode() : 0);
        result = 31 * result + (secondHomePhone != null ? secondHomePhone.hashCode() : 0);
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

    public String getAddress() {
        return address;
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

    public Groups getGroups() {
        return new Groups(groups);
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

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
