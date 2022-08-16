package org.example.BuilderPattern.Example1.Example2;
//https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java
public class TestBuilderPattern {

    public static void main(String[] args)
    {
        Computer comp=new Computer.ComputerBuilder()
                .setHDD("500")
                .setRAM("256GB")
                .setOS("Windows")
                .setScreenType("SAMOLED")
                .setGraphicsCard(true)
                .setBluetooth(true)
                .Build();
        comp.toString();
    }
}
