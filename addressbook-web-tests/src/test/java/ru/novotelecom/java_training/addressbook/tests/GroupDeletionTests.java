package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.GroupData;
import ru.novotelecom.java_training.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size()==0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {

        Groups before = app.group().all();
        GroupData deteledGroup = before.iterator().next();
        app.group().delete(deteledGroup);
        Groups after = app.group().all();
        assertEquals(after.size(),before.size()-1);
        assertThat(after,equalTo(before.without(deteledGroup)));

    }




}
