package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;
import ru.novotelecom.java_training.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.goTo().contactCreationPage();
            app.contact().create(new ContactData().withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddress("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555")
            //        .withGroup("test1")
            );
        }
    }

    @Test
    public void testContactModificationSet() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddress("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555").withPhoto(new File("src/test/resources/grass.png"));
        app.contact().modify(contact);
        assertEquals(app.contact().count(),before.size());
        Contacts after = app.db().contacts();
        assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListWithUI();
    }



}
