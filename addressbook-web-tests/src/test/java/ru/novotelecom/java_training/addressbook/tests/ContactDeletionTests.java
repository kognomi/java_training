package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletionFromContactEditPage() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactDeletionFromContactEditPage();
    }

    @Test
    public void testContactDeletionFromHomePage () {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactDeletionFromHomePage();
    }

}
