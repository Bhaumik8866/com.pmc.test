package org.example.collections;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class CollectionsTest {

    Random random = new Random();

    @Test
    public void arrays() // contains basic CRUD operations on Array List interface
    {
        List<Integer> list = new ArrayList<>();

        //adding static elements in to array list by add method
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(list);
        list.stream().forEach(System.out::println);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

        //updating element in array list
        list.set(0, 0);
        System.out.println(list);
        System.out.println("list.size: " + list.size());
        List<Integer> list2 = new ArrayList<>();
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));
        list2.add(random.nextInt(10));

        boolean flag = list.containsAll(list2);
        System.out.println(flag);
        System.out.println(list.contains(30));
        System.out.println(list.hashCode());
        System.out.println(list2.hashCode());
        System.out.println(list.isEmpty());
        ListIterator<Integer> itr = list2.listIterator(); //retrive list of values using list iterator
        while (itr.hasNext()) {
            System.out.println("List Iterator: " + itr.next());
        }
        System.out.println("---------Break----------");
        for (Integer j : list)//retrive list of values using for-each loop
        {
            System.out.println("For-each loop: " + j);
        }
        list.addAll(list2);
        System.out.println(list);
        list.removeAll(list2);
        System.out.println(list);
        list.remove(list.get(0));
        System.out.println(list);

        list.clear();
        System.out.println("list.clear: " + list);

    }
}
