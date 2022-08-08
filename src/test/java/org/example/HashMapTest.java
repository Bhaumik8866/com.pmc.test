package org.example;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, String> h1 = new HashMap<Integer, String>();
        h1.put(1, "Demo1");
        h1.put(2, "Demo2");
        h1.put(3, "Demo3");
        h1.put(4, "Demo4");
        h1.put(5, "Demo5");
        h1.put(6, "Demo6");
        System.out.println("Iterating Hash map...");

        for (Map.Entry m : h1.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
//            int key= (int) m.getKey();
//            System.out.println(key);
        }

    }
}
