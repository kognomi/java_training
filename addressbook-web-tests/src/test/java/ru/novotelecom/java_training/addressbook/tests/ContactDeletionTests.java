package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletionFromContactEditPage() {

        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactDeletionFromContactEditPage();
    }

    @Test
    public void testContactDeletionFromHomePage () {
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactDeletionFromHomePage();
    }

}
