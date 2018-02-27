package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();

        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().initContactCreation();
            app.getContactHelper().createContact(new ContactData("1Firstname", "1Midname", "1Lastname", "1Addr", "11111", "12222", "13333", "1email1@aaa.aa", "1email2@bbb.bb", "1email3@ccc.cc", "15555","test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size()-1);
        ContactData contact = new ContactData("1Firstname", "1Midname", "1Lastname", "1Addr", "11111", "12222", "13333", "1email1@aaa.aa", "1email2@bbb.bb", "1email3@ccc.cc", "15555","test1");
        app.getContactHelper().fillContactForm(contact,false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }

}
