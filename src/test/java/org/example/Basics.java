package org.example;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

enum section {DASHBOARD, ADMIN, SHIPMENTS, ADDRESSBOOK, CASES, LANES, REPORTS, SERVICE, CUSTOMS}

enum country {AT, EE, ES}

@Test
public class Basics {


    public static void main(String[] args) {
        section s = section.DASHBOARD;
        System.out.println(s);
        List<section> sectionlist = new ArrayList<>();
        for (section s1 : section.values()) {
            System.out.println(s1);
            sectionlist.add(s1);
        }
        int var = sectionlist.size();
        System.out.println(var);
        for (section l : sectionlist) {
            System.out.println("Section list array: " + l);
        }
    }
}

