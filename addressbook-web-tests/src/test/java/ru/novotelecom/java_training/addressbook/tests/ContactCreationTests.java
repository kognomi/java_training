package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().initContactCreation();
        ContactData contact = new ContactData("1Firstname", "1Midname", "1Lastname", "1Addr", "11111", "12222", "13333", "1email1@aaa.aa", "1email2@bbb.bb", "1email3@ccc.cc", "15555","test1");
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }

}
