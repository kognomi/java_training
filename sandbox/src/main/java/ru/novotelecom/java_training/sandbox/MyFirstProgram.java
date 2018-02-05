package ru.novotelecom.java_training.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		hello("world");
        hello("vasya");

        Square square= new Square(5);
        System.out.println("Площадь квадрата со стороной " + square.l + " = " + square.area());

        Rectangle rectangle= new Rectangle(4,6);
        System.out.println("Площадь квадрата со сторонами " + rectangle.a +" и " + rectangle.b + " = " + rectangle.area());
	}

	public static void hello(String somebody) {

	   System.out.println("Hello, " + somebody+ "!");
    }

/*   public static double distance(Point p1, Point p2) {


return;
   }*/


}
