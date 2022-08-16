package org.example.BuilderPattern.Example1;

public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "Checken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
