package ru.novotelecom.java_training.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.novotelecom.java_training.addressbook.appmanager.ApplicationManager;
import ru.novotelecom.java_training.addressbook.model.ContactData;
import ru.novotelecom.java_training.addressbook.model.Contacts;
import ru.novotelecom.java_training.addressbook.model.GroupData;
import ru.novotelecom.java_training.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {


    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart (Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with params " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop (Method m) {
        logger.info("Stop test " + m.getName());
    }

    public void verifyGroupListWithUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uIGroups = app.group().all();
            assertThat(uIGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
        }
    }

    public void verifyContactListWithUI() {

        if (Boolean.getBoolean("verifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Contacts uIContacts = app.contact().all();
            assertThat(uIContacts,equalTo(dbContacts.stream()
                    .map((g)-> new ContactData().withId(g.getId()).withFirstname(g.getFirstname()).withLastname(g.getLastname()).withAddress(g.getAddress())).collect(Collectors.toSet())));
        }

    }

}
