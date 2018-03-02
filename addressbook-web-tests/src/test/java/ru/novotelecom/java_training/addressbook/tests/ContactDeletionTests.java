package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();

        if (app.contact().list().size()==0) {
            app.goTo().contactCreationPage();
            app.contact().create(new ContactData("1Firstname", "1Midname", "1Lastname", "1Addr", "11111", "12222", "13333", "1email1@aaa.aa", "1email2@bbb.bb", "1email3@ccc.cc", "15555","test1"));
        }
    }

    @Test(enabled=false)
    public void testContactDeletionFromContactEditPage() {
        List<ContactData> before = app.contact().list();
        int index= before.size()-1;
        app.contact().deleteFromModificationPage(index);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        before.remove(index);
        Assert.assertEquals(before, after);
    }



    @Test(enabled=false)
    public void testContactDeletionFromHomePage () {
        List<ContactData> before = app.contact().list();
        int index= before.size()-1;
        app.contact().deleteFromHomePage(index);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        before.remove(index);
        Assert.assertEquals(before, after);
    }



}
