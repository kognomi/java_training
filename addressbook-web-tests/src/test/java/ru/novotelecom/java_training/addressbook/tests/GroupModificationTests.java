package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.GroupData;
import ru.novotelecom.java_training.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification () {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("2test").withFooter("3test");
        app.goTo().groupPage();
        app.group().modify(group);
        assertEquals(app.group().count(),before.size());//остается для минимального контроля того, что в морде
        Groups after = app.db().groups();
        assertThat(after,equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListWithUI();
    }



}
