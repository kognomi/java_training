package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.GroupData;

import java.util.Set;

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

        Set<GroupData> before = app.group().all();
        GroupData deteledGroup = before.iterator().next();
        app.group().delete(deteledGroup);
        Set<GroupData> after = app.group().all();
        before.remove(deteledGroup);
        Assert.assertEquals(before, after);
    }




}
