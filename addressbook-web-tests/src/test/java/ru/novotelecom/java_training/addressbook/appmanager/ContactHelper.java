package ru.novotelecom.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.novotelecom.java_training.addressbook.model.ContactData;
import ru.novotelecom.java_training.addressbook.model.Contacts;
import ru.novotelecom.java_training.addressbook.model.GroupData;

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
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getFirstHomePhone());
        type(By.name("mobile"),contactData.getMobilePhone());
        type(By.name("work"),contactData.getWorkPhone());
        type(By.name("email"),contactData.getFirstEmail());
        type(By.name("email2"),contactData.getSecondEmail());
        type(By.name("email3"),contactData.getThirdEmail());
        type(By.name("phone2"),contactData.getSecondHomePhone());
//        attach(By.name("photo"),contactData.getPhoto());

        if (creation) {
 /*           if (contactData.getGroups().size()>0) {
                Assert.assertTrue(contactData.getGroups().size()==1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            }*/
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }
    public void goToHomePage() {
        click(By.linkText("home"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.id(""+id+"")).click();
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
    }


    private void initContactModificationByIdTraining59(int id) {
        // с помощью xpath зная только чекбокс
        /*WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id))); // '%s' - переменная, их может быть сколько угодно
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click(); // тут 7 т.к в списке нумерация с 0
        */

//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click(); // тут 8 т.к. в xpath нумерация с 1
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click(); // c подзапросами (ищем строки где есть чекбокс, а потом в строке ищем нужную ячейку)
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();// тут почти как у меня только с переменной, а не со склейкой.
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
        contactCache= null;
        returnToHomePage();
    }

    public void deleteFromModificationPage(ContactData contact) {
        initContactModificationById(contact.getId());
        submitContactDeletionFromContactEditPage();
        contactCache = null;

    }

    public void deleteFromHomePage(ContactData contact) {
        selectContactById(contact.getId());
        submitContactDeletionFromHomePage();
        contactCache = null;
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact,false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            String address = cells.get(3).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String homeFirst = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String homeSecond = wd.findElement(By.name("phone2")).getAttribute("value");
        String firstEmail = wd.findElement(By.name("email")).getAttribute("value");
        String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
        String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");

        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withFirstHomePhone(homeFirst).withMobilePhone(mobile).withWorkPhone(work).withSecondHomePhone(homeSecond).withFirstEmail(firstEmail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail).withAddress(address);
    }

    public void selectContactByIdForDelete(int id) {
            wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
          }

    private void selectGroupforAdding(String group) {

        new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(group);
    }

    public void submitContactAddInGroup() {
           click(By.cssSelector("input[name='add']"));

         }
    public void submitContactDeleteFromGroup() {
        click(By.cssSelector("input[name='remove']"));

    }

    public void goToContactsFromGroupsPage(int group) {
        wd.findElement(By.cssSelector(String.format("a[href='./index.php?group=%s']", group))).click();
    }


    public void addInGroup(ContactData contact,GroupData group) {
        selectContactById(contact.getId());
        selectGroupforAdding(group.getName());
        submitContactAddInGroup();
        contactCache = null;
        goToHomePage();
         }

  public void deleteFromGroup(ContactData contact, GroupData group) {
    selectContactByIdForDelete(contact.getId());
    goToContactsFromGroupsPage(group.getId());
    selectContactById(contact.getId());
    submitContactDeleteFromGroup();
   contactCache = null;
   goToHomePage();
    }
}
