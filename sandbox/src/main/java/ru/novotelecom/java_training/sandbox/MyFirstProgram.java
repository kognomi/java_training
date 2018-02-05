package ru.novotelecom.java_training.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		hello("world");
        hello("vasya");

        Square square= new Square(5);
        System.out.println("Площадь квадрата со стороной " + square.l + " = " + square.area());

        Rectangle rectangle= new Rectangle(4,6);
        System.out.println("Площадь квадрата со сторонами " + rectangle.a +" и " + rectangle.b + " = " + rectangle.area());

        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        System.out.println("Расстояние между точками (" +p1.x + "," + p1.y + ")"  +" и " +  "(" +p2.x + "," + p2.y + ")"+ " = " + distance(p1,p2));
        // есть подозрения, что написанное тут - жуть жутчайшая, но как по-другому я без понятия, и вроде оно работает
        System.out.println("Расстояние между точками (" +p1.x + "," + p1.y + ")"  +" и " +  "(" +p2.x + "," + p2.y + ")"+ " = " + p1.distance(p2));


	}

	public static void hello(String somebody) {

	   System.out.println("Hello, " + somebody+ "!");
    }

 public static double distance(Point p1, Point p2) {

	    return Math.sqrt((Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2)));
   }


}
