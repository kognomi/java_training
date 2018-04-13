package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.ContactData;
import ru.novotelecom.java_training.addressbook.model.Contacts;
import ru.novotelecom.java_training.addressbook.model.GroupData;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactAddInGroupTests extends TestBase {

  @BeforeMethod
  public void checkPreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData()
              .withName("test1")
              .withHeader("header")
              .withFooter("footer"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().contactCreationPage();
      app.contact().create(new ContactData()
              .withFirstname("1Иван").withLastname("1Иванов").withAddress("ул.Мира 5")
              .withFirstHomePhone("333-33-33").withMobilePhone("79(999-999-999)").withWorkPhone("4444")
              .withFirstEmail("test1@mail.ru").withSecondEmail("test2@mail.ru").withThirdEmail("test3@mail.ru").withSecondHomePhone("123"));
    }

    app.goTo().homePage();
  }

  @Test
  public void testContactAddInGroup() {
    Contacts before = app.db().contacts();
    ContactData addContact = before.iterator().next();
    app.contact().addInGroup(addContact);

    Contacts after = app.db().contacts();
    assertThat(app.contact().count(), equalTo(before.size()));
    assertThat(after, equalTo(before));
    verifyContactListWithUI();
  }
}