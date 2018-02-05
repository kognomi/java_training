package ru.novotelecom.java_training.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


    @Test
    public void testDistance() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        Assert.assertEquals(p1.distance(p2),1.414,0.0003);

    }
    @Test
    public void testSamePoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Assert.assertEquals(p1.distance(p2),0.0);

    }

    @Test
    public void testNotNegative() {
        Point p1 = new Point(-1, -1);
        Point p2 = new Point(-2, -2);
        Assert.assertTrue((p1.distance(p2))>0,"Расстояние не может быть < 0");

    }
    @Test
    public void testDistanceRelation() {
        Point p1 = new Point(-1, -1);
        Point p2 = new Point(-2, -2);
        Assert.assertFalse(((p1.distance(p2))-(p2.distance(p1)))!=0,"Расстояние двух точек одинаково независимо от порядка");

    }


}
