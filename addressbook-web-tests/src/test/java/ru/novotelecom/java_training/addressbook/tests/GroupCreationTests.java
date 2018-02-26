package ru.novotelecom.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.novotelecom.java_training.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List <GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test3", null, null);
        app.getGroupHelper().createGroup(group);
        List <GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size()+1);

        //по старинке
       /* int max=0;
        for (GroupData g:after) {
            if (g.getId()>max) {
                max=g.getId();
            }
        }*/

        // чуть более читаемый вид, для понимания того, что тут делалось
       /* Comparator<? super GroupData> byId = new Comparator<GroupData>() {
            @Override
            public int compare(GroupData o1, GroupData o2) {
                return Integer.compare(o1.getId(),o2.getId());
            }
        };*/

        // а вот так можно сделать, начиная с java8

/*      Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
        int max =  after.stream().max(byId).get().getId();
        group.setId(max);
        */

        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(group);

        Comparator<? super GroupData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }

}
