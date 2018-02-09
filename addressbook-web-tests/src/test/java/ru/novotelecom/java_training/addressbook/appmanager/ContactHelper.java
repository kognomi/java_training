package ru.novotelecom.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.novotelecom.java_training.addressbook.model.ContactData;

public class ContactHelper  extends HelperBase{


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMidname());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("address"),contactData.getAddres());
        type(By.name("home"),contactData.getFirstHomePhone());
        type(By.name("mobile"),contactData.getMobilePhone());
        type(By.name("work"),contactData.getWorkPhone());
        type(By.name("email"),contactData.getFirstEmail());
        type(By.name("email2"),contactData.getSecondEmail());
        type(By.name("email3"),contactData.getThirdEmail());
        type(By.name("phone2"),contactData.getSecondHomePhone());
    }
}
