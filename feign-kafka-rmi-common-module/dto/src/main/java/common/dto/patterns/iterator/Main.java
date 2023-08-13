package common.dto.patterns.iterator;

import common.dto.FoodOrder;


public class Main {
    public static void main(String[] args) {
        Food snack = new Food("Salat", 10, 10);
        Food soup = new Food("Soup", 10, 10);
        Food entree = new Food("Burger", 10, 10);
        Food dessert = new Food("Cake", 10, 10);

        FoodOrder foodOrder = new FoodOrder(snack, soup, entree, dessert,4);

        for (Food food: foodOrder) {
            System.out.println(food.getName());
        }
    }
}
