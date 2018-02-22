package ru.novotelecom.java_training.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main (String[] args) {

        //По старинке
        String[] langs0 =new String[4];
        langs0[0] = "Java";
        langs0[1] = "C#";
        langs0[2] = "Python";
        langs0[3] = "PHP";

        for (int i=0;i<langs0.length;i++) {
            System.out.println("Я хочу выучить "+ langs0[i]);
        }

        //Сокращенная версия
        String[] langs ={"Java", "C#", "Python", "PHP"};

        for (String l: langs) {
            System.out.println("Я хочу выучить "+ l);
        }

        // Списки (сокращенного варианта нету, указать массив низзя)
        List <String> languages0 = new ArrayList<String>();
        languages0.add("Java");
        languages0.add("C#");
        languages0.add("Python");
        languages0.add("PHP");

        for (String l: languages0) {
            System.out.println("Я хочу выучить "+ l);
        }


        //но есть хитрое сокращение
        List <String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
        //пробежка со счетчиком
        for (int i=0;i<languages.size();i++) {
            System.out.println("Я хочу выучить "+ languages.get(i));
        }


        //с рандомными элементами
        List  language = Arrays.asList("Java", "C#", "Python", "PHP");

        for (Object l: language) {
             System.out.println("Я хочу выучить "+ l);
        }



    }
}
