package ru.novotelecom.java_training.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		hello("world");
        hello("vasya");
        double vasek =5;
        double a=4;
        double b=6;
        System.out.println("Площадь квадрата со стороной " + vasek + " = " + area (vasek));
        System.out.println("Площадь квадрата со сторонами " + a +" и " + b + " = " + area(a,b));
	}

	public static void hello(String somebody) {

	   System.out.println("Hello, " + somebody+ "!");
    }
    public static double area (double kot) {
	    return kot*kot;
    }
    public static double area (double a,double b) {
	    return a*b;
    }
}
