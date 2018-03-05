package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();

        if (app.contact().all().size()==0) {
            app.goTo().contactCreationPage();

            app.contact().create(new ContactData().withFirstname("1Firstname").withMidname("1Midname").withLastname("1Lastname").withAddres("1Addr").withFirstHomePhone("11111").withMobilePhone("12222").withWorkPhone("13333").withFirstEmail("1email1@aaa.aa").withSecondEmail("1email2@bbb.bb").withThirdEmail("1email3@ccc.cc").withSecondHomePhone("15555").withGroup("test1"));
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getFirstHomePhone(),equalTo(cleaned(contactInfoFromEditForm.getFirstHomePhone())));
        assertThat(contact.getMobilePhone(),equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(),equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
        assertThat(contact.getSecondHomePhone(),equalTo(cleaned(contactInfoFromEditForm.getSecondHomePhone())));
    }

    public String cleaned (String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

}
