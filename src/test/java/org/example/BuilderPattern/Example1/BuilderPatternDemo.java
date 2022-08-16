package org.example.BuilderPattern.Example1;
//https://www.tutorialspoint.com/design_pattern/builder_pattern.htm#
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        vegMeal.getPrice();

        Meal nonVegMeal=mealBuilder.prepareNonVegMeal();
        nonVegMeal.showItems();
        nonVegMeal.getPrice();
    }

}
