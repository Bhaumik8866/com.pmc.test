package org.example.streams;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//find the use case of this scenario on : https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#use-case
public class Person {

    WebDriver driver;
 public enum gender{MALE,FEMALE}

    String name;
    LocalDate birthday;
    gender gen;
    String emailaddress;
    public HashMap<Integer,String> p;

    public List<Integer> getAge()
    {
        HashMap<Integer, String> h1;
        List<Integer> age=new ArrayList<>();
        h1=createPersonsList();
        for(Map.Entry m: h1.entrySet())
        {
            age.add((int)m.getKey());
        }
        return age;

    }

    public HashMap<Integer, String> createPersonsList() {
        p=new HashMap<>(); //Here integer refer to Age and string is the name of the person
        p.put(1,"P1");
        p.put(2,"P2");
        p.put(3,"P3");
        p.put(4,"P4");
        p.put(5,"P5");
        p.put(6,"P6");
        p.put(7,"P7");
        p.put(8,"P8");
        p.put(9,"P9");
        p.put(10,"P10");
        return p;
    }

    //Approach 1: Create Methods That Search for Members That Match One Characteristic
    public void printPersonOlderThan(HashMap<Integer,String> map,int age)
    {
        for(Map.Entry m: map.entrySet()) {
            if ((int)m.getKey() < age) {
                System.out.println(m.getValue());
            }
        }
    }
    public void printPersonsWithinAgeRange(HashMap<Integer,String> map,int l,int h)
    {
        for(Map.Entry m:map.entrySet())
        {
            if((int)m.getKey()>l && (int)m.getKey()<h)
            {
                System.out.println(m.getValue());
            }
        }
    }
    @Test
    public void main() throws InterruptedException {
     HashMap<Integer,String> list=createPersonsList();
     //Approach 1: Create Methods That Search for Members That Match One Characteristic
     System.out.println("Persons older than 6:");
     printPersonOlderThan(list,6);
     System.out.println("--------------");
     //Approach 2: Create More Generalized Search Methods
     System.out.println("Persons between the ages of 2 and 8:");
     printPersonsWithinAgeRange(list,2,8);
     System.out.println("-----------------");
     //Search for Members That Match One Characteristic [age is >6]
     list.entrySet().stream().filter(e -> (int)e.getKey() >6).forEach(e -> System.out.println("Stream: "+e.getValue()));
     //Search for Members That Match One Characteristic [age is >2 & <8]
     list.entrySet().stream().filter(e->e.getKey()<8 && e.getKey()>2).forEach(e->System.out.println("Age is >2 & <8 "+e.getValue()));
     //Search for Members That Match One Characteristic [if age >4 then print P9 else print P1]
     list.entrySet().stream().filter(e->e.getKey()>4?e.getValue().equalsIgnoreCase("P9"):e.getValue()
             .equalsIgnoreCase("P1"))
             .forEach(System.out::println);
    //Test use of System.out::println
     list.entrySet().stream().filter(s->s.getValue().contains("8")).forEach(System.out::println);
     //Basic difference between filter & map is as below
     // filter operation is used to filter records of the stream based on filter conditions provided. it will return filtred stream records.
     // in case of map, it is used to manipulate data of stream before or after filter operation.
        // as a result it will return updated records based on manipulation operation performed
     // Both operation will not change any data of list. to get updated data, collect operation has to be performed at the end.
        //collecit operation stored manipulated data in to new list. original list is always unaltered
     list.entrySet().stream().map(s->s.getKey() %2 ).forEach(System.out::print);
     List maplist= list.entrySet().stream().map(s->s.getValue().concat(": PMC Test "))
                     .map(e->e.toUpperCase()).collect(Collectors.toList());
     System.out.print(maplist);


    }
    @Test
    public void webtest() throws InterruptedException {
        //Project
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://gateway-dev.carousel.eu/");
        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("hitesh.prajapati@pmcretail.com");
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("GatewayDev@2020");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Admin']")).click();
        Thread.sleep(2000);
        List<WebElement> adminpages=new ArrayList<>();
        adminpages=driver.findElements(By.xpath("//a[contains(@href,'Admin')]"));
        long countpages=adminpages.stream().filter(e->e.isDisplayed()).count();
        System.out.println(countpages);
        adminpages.stream().filter(e->e.isDisplayed())
                .map(e->e.getText()).forEach(e->System.out.println(e));
//        List<String> pagenames= adminpages.stream().filter(e->e.isDisplayed())
//                .map(e->e.getText()).collect(Collectors.toList());
//        pagenames.stream().forEach(e->System.out.println());

//        adminpages.stream().filter(e->e.isDisplayed())
//                .forEach(e-> {
//                  e.click();
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });

        List<WebElement> filteredlist= adminpages.stream().filter(e->e.isDisplayed())
                .collect(Collectors.toList());
        filteredlist.forEach(e-> {
            e.sendKeys(Keys.CONTROL,Keys.ENTER);
            try {
                Thread.sleep(5000);

            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        driver.quit();
    }


}
