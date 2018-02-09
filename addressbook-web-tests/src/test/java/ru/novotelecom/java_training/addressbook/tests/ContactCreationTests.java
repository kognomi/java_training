package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        app.getNavigationHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Firstname", "Midname", "Lastname", "Addr", "1111", "2222", "3333", "email1@aaa.aa", "email2@bbb.bb", "email3@ccc.cc", "5555"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
    }

}
