package ru.novotelecom.java_training.sandbox;

public class Equality {
    public static void main(String[] args ) {
        //String s1 = "firefox";
        String s1 = "firefox 2.0";
        //String s2 = new String(s1);
        //String s2 = "firefox";
        //String s2 = "fir" +"efox";
        String s2 = "firefox " + Math.sqrt(4.0);


        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
