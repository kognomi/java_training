package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification () {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1",null,null));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "2test", "3test"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);
    }
}
