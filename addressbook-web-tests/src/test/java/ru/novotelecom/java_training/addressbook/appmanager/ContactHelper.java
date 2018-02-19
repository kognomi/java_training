package ru.novotelecom.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.novotelecom.java_training.addressbook.model.ContactData;

public class ContactHelper  extends HelperBase{


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData,boolean creation) {
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

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void selectContact() {
        click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void submitContactDeletionFromContactEditPage() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void submitContactDeletionFromHomePage() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        confirmAllert();
    }

}
