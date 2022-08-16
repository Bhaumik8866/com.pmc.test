package org.example.BuilderPattern.Example1;

public class Burger implements Item{

    @Override
    public String name() {
        return "Burger";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 0;
    }
}
