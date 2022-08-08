package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountName {

    public static List<String> getname()
    {
        List<String> accountName= Arrays.asList("PMC01 - PMC Test","PMC02 - PMC Test","CAR01 - Carousel Test","CAR02 - Carousel Test");

        return accountName;
    }

//    public static void main(String[] args)
//    {
//        Faker f=new Faker();
//        getname().stream().forEach(e->System.out.println(e));
//        System.out.println("Selected: "+f.options().nextElement(getname()));
//    }
}
