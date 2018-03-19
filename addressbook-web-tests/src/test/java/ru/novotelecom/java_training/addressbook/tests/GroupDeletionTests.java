package ru.novotelecom.java_training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.GroupData;
import ru.novotelecom.java_training.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {

        Groups before = app.db().groups();
        GroupData deteledGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deteledGroup);
        assertEquals(app.group().count(),before.size()-1);
        Groups after = app.db().groups();
        assertThat(after,equalTo(before.without(deteledGroup)));
        verifyGroupListWithUI();
    }




}
