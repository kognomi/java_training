package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;
import ru.novotelecom.java_training.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();

        if (app.contact().all().size()==0) {
            app.goTo().contactCreationPage();
            app.contact().create(new ContactData().withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddres("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555").withGroup("test1"));

        }
    }

    @Test
    public void testContactDeletionFromContactEditPageSet() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().deleteFromModificationPage(deletedContact);
        app.goTo().homePage();
        assertEquals(app.contact().count(),before.size()-1);
        Contacts after = app.contact().all();
        assertThat(after,equalTo(before.without(deletedContact)));
    }

    @Test
    public void testContactDeletionFromHomePageSet () {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().deleteFromHomePage(deletedContact);
        app.goTo().homePage();
        assertEquals(app.contact().count(),before.size()-1);
        Contacts after = app.contact().all();
        assertThat(after,equalTo(before.without(deletedContact)));
    }

}
