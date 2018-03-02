package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationSet() {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        app.goTo().contactCreationPage();
        ContactData contact = new ContactData().withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddres("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555").withGroup("test1");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);
    }

    @Test(enabled = false)
    public void testContactCreationList() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        app.goTo().contactCreationPage();
        ContactData contact = new ContactData().withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddres("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555").withGroup("test1");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }

}
