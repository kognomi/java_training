package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletionFromContactEditPage() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().initContactCreation();
            app.getContactHelper().createContact(new ContactData("1Firstname", "1Midname", "1Lastname", "1Addr", "11111", "12222", "13333", "1email1@aaa.aa", "1email2@bbb.bb", "1email3@ccc.cc", "15555","test1"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactDeletionFromContactEditPage();
    }

    @Test
    public void testContactDeletionFromHomePage () {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().initContactCreation();
            app.getContactHelper().createContact(new ContactData("1Firstname", "1Midname", "1Lastname", "1Addr", "11111", "12222", "13333", "1email1@aaa.aa", "1email2@bbb.bb", "1email3@ccc.cc", "15555","test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactDeletionFromHomePage();
    }

}
