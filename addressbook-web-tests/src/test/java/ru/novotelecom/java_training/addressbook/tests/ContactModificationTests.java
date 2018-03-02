package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();

        if (app.contact().list().size()==0) {
            app.goTo().contactCreationPage();

            app.contact().create(new ContactData().withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddres("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555").withGroup("test1"));
        }
    }

    @Test
    public void testContactModificationSet() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddres("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before,after);
    }

    @Test(enabled = false)
    public void testContactModificationList() {
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        ContactData contact = new ContactData().withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddres("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555");
        app.contact().modify(index,contact);
        List<ContactData> after = app.contact().list();
        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }



}
