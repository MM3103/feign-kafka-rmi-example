package common.dto.patterns.iterator;

import common.dto.FoodOrder;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FoodOrderIterator implements Iterator<Food> {

    FoodOrder foodOrder;
    Integer countOfFood;

    public FoodOrderIterator(FoodOrder foodOrder) {
        this.foodOrder = foodOrder;
        this.countOfFood = foodOrder.getCountOfFood();
    }

    @Override
    public boolean hasNext() {

        if ( countOfFood == 4) {
            return foodOrder.hasSnack() || foodOrder.hasSoup() || foodOrder.hasEntree() || foodOrder.hasDessert();
        } else if (countOfFood == 3) {
            return foodOrder.hasSoup() || foodOrder.hasEntree() || foodOrder.hasDessert();
        } else if (countOfFood == 2) {
            return foodOrder.hasEntree() || foodOrder.hasDessert();
        } else if (countOfFood == 1) {
            return foodOrder.hasDessert();
        }
        return false;
    }

    @Override
    public Food next() {
        if (countOfFood <= 0) {
            throw new NoSuchElementException("No more elements in this word!");
        }

        try {
            if (countOfFood == 4) {
                return foodOrder.getSnack();
            }
            if (countOfFood == 3) {
                return foodOrder.getSoup();
            }
            if (countOfFood == 2) {
                return foodOrder.getEntree();
            }
            return foodOrder.getDessert();
        } finally {
            countOfFood--;
        }
    }
}
