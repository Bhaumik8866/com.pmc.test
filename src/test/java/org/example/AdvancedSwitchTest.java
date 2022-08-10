package org.example;

import org.testng.annotations.Test;

public class AdvancedSwitchTest {

    public enum Day {SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THRUSDAY,FRIDAY,SATURDAY;}

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
        int numLatters=0;
       System.out.println( switch (day){
           case TUESDAY -> null;
           case WEDNESDAY -> null;
           case THRUSDAY -> null;
           case SUNDAY,MONDAY,FRIDAY -> numLatters=6;
           case SATURDAY -> null;
       });
    }

}
