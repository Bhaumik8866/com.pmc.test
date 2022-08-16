package org.example.BuilderPattern.Example1;

public class ColdDrink implements Item{
    @Override
    public String name() {
        return "Cold Drink";
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float price() {
        return 0;
    }
}
