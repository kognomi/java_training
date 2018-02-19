package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("1Firstname", "1Midname", "1Lastname", "1Addr", "11111", "12222", "13333", "1email1@aaa.aa", "1email2@bbb.bb", "1email3@ccc.cc", "15555",null),false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

    }

}
