package org.example.assertJTest;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;
import static org.testng.collections.Lists.newArrayList;

public class DemoAssertJ {
    protected Employee yoda;
    protected Employee ben;
    protected Employee jhon;
    protected Employee berry;
    protected Employee glen;
    protected Employee thor;

    @Test
    public void BasicAssert() {
        List<String> players = new ArrayList<>();
        players.add("Gwendoline Odin");
        players.add("Betsy Yancy");
        players.add("Ursula Karena");
        players.add("Johanna Matilda");
        players.add("Divina Charlene");
        assertThat(players.get(2)).isEqualTo("Ursula Karena");
        assertThat(players.get(2)).isNotEqualTo("Bhaumik");

        assertThat(players.get(3)).startsWith("Joha")
                .endsWith("lda")
                .isEqualToIgnoringCase("Johanna Matilda");

        assertThat(filter(players).with("Ben123tsy").get());

        yoda = new Employee(101, "Yoda", 26);
        ben = new Employee(102, "Ben", 25);
        jhon = new Employee(103, "Jhon", 28);
        berry = new Employee(1104, "Berry", 27);
        glen = new Employee(1011, "Glen", 30);
        thor = new Employee(11, "Thor", 4300);
        List<Employee> employee = newArrayList(yoda, ben, jhon, berry, glen, thor);
        System.out.println(employee.get(yoda.id));
        assertThat(filter(employee).with("yoda1").equals("employee"));

    }

    private class Employee {

        int id;
        String name;
        int age;

        Employee(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public boolean getdata() {
            System.out.println("id:" + id + " name:" + name + " age:" + age);
            return false;
        }
    }
}
