package org.example;

import org.testng.annotations.Test;


public class AdvancedSwitchTest {

    public enum Day {SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THRUSDAY,FRIDAY,SATURDAY;}

    public String getDepartment()
    {
        return "IT";
    }

    @Test
    public void oldSwitch() {
        int numLatters = 0;
        Day day = Day.SATURDAY;
        switch (day)
        {
            case SUNDAY:
                numLatters=6;
                break;
            case MONDAY:
                numLatters=6;
                break;
            case TUESDAY:
                numLatters=7;
                break;
            case WEDNESDAY:
                numLatters=9;
                break;
            case THRUSDAY:
                numLatters=8;
                break;
            case FRIDAY:
                numLatters=6;
                break;
            case SATURDAY:
                numLatters=8;
                break;
        }
        System.out.println(numLatters);
    }

    @Test
    public void newSwitch()
    {
        Day day=Day.WEDNESDAY;
        int numLatters=( switch (day){
           case WEDNESDAY -> 9;
           case THRUSDAY,SATURDAY -> 8;
           case SUNDAY,MONDAY,FRIDAY,TUESDAY -> 6;
            default -> 0;
       });
        System.out.println(numLatters);
    }

    @Test
    public void switchExpression()
    {
        Day day=Day.WEDNESDAY;
        switch (day){
                case WEDNESDAY -> {
                String c=Day.WEDNESDAY.toString();
                char[] ch = c.toCharArray();
                int length = ch.length;
                System.out.println(length>8?Day.WEDNESDAY:Day.MONDAY);
            }
            default -> System.out.println("Invalid day selection");
        }
    }

    @Test
    public void patternMatching()
    {

        Object obj=new String("XYZ");
        int obj1 = 10;
        AdvancedSwitchTest a=new AdvancedSwitchTest();

        switch (a)
        {
//            case String s->System.out.println("It is a string");
//            case Integer i->System.out.println("It is a int");
            case AdvancedSwitchTest a1 && a1.getDepartment().equalsIgnoreCase("IT")
                    ->System.out.println("IT Employee");
            default -> throw new IllegalStateException("Unexpected value: " + obj);
        };

    }

}
