package ru.novotelecom.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.novotelecom.java_training.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


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

    public void selectContact(int index) {
        wd.findElements(By.cssSelector("tr[name='entry']")).get(index).findElement(By.xpath(".//td[1]/input")).click();


    }

    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("tr[name='entry']")).get(index).findElement(By.xpath(".//td[8]/a/img")).click();

    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void submitContactDeletionFromContactEditPage()  {
        click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
    }

    public void submitContactDeletionFromHomePage()  {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
        confirmAllert();
    }

    public void create(ContactData contact) {
        fillContactForm(contact,true);
        submitContactCreation();
        returnToHomePage();
    }

    public void deleteFromModificationPage(int index) {
        initContactModification(index);
        submitContactDeletionFromContactEditPage();

    }

    public void deleteFromHomePage(int index) {
        selectContact(index);
        submitContactDeletionFromHomePage();
    }

    public void modify(int index, ContactData contact) {
        initContactModification(index);
        fillContactForm(contact,false);
        submitContactModification();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public List<ContactData> list() {
        List <ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname =  element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("td")).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id,firstname, null, lastname, null, null, null, null, null,null,null,null,null);
            contacts.add(contact);
        }
        return contacts;
    }
}
