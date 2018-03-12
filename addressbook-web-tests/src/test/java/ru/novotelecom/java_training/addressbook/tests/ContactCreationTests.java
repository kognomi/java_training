package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;
import ru.novotelecom.java_training.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationSet() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/grass.png");
        app.goTo().contactCreationPage();
        ContactData contact = new ContactData().withFirstname("1Firstname").withMidname("1Midname").
                withLastname("1Lastname").withAddress("1Addr").withFirstHomePhone("11111").
                withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").
                withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555").withGroup("test1").withPhoto(photo);
        app.contact().create(contact);
        assertThat(app.contact().count(),equalTo(before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }



}
