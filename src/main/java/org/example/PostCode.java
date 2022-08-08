package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostCode {
    public static List<String> getPostCode()
    {
        List<String> postCode= new ArrayList<>();
        postCode.add("B29 4AA");
        postCode.add("BD4 8SJ");
        postCode.add("BN11 1DL");
        postCode.add("BN11 4AR");
        postCode.add("CH49 4NE");
        postCode.add("CT1 2XJ");
        postCode.add("CV5 9FE");
        postCode.add("DE13 7DB");
        postCode.add("G75 0YF");
        postCode.add("GL10 3SX");
        postCode.add("GU1 1EZ");
        postCode.add("ME10 3UP");
        postCode.add("ME12 2PS");
        postCode.add("ME17 2DE");
        postCode.add("MK41 7UL");
        postCode.add("MK5 6EX");
        postCode.add("OX15 4AL");
        postCode.add("PE2 7EA");
        postCode.add("PE28 5TQ");
        postCode.add("WS11 7FU");
        postCode.add("WS12 4NP");
        postCode.add("WS3 4DG");

        return postCode;
    }

    public static void main(String[] args)
    {
        Faker f=new Faker();
        getPostCode().stream().forEach(e->System.out.println(e));
        System.out.println("Selected: "+f.options().nextElement(getPostCode()));
    }
}
