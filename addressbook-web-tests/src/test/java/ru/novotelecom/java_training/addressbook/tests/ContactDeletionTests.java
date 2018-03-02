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
            app.contact().create(new ContactData().withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddres("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555").withGroup("test1"));

        }
    }

    @Test
    public void testContactDeletionFromContactEditPage() {
        List<ContactData> before = app.contact().list();
        int index= before.size()-1;
        app.contact().deleteFromModificationPage(index);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        before.remove(index);
        Assert.assertEquals(before, after);
    }



    @Test
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
