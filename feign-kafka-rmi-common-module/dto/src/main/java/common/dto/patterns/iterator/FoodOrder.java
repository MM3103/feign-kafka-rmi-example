package common.dto;

import common.dto.patterns.composite.Package;
import common.dto.patterns.iterator.Food;
import common.dto.patterns.iterator.FoodOrderIterator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class FoodOrder implements Iterable<Food>, Package {
    Food snack;
    Food soup;
    Food entree;
    Food dessert;
    Integer countOfFood;

    public boolean hasSnack() {
        return this.snack != null;
    }

    public boolean hasSoup() {
        return this.soup != null;
    }

    public boolean hasEntree() {
        return this.entree != null;
    }

    public boolean hasDessert() {
        return this.dessert != null;
    }

    @Override
    public Iterator<Food> iterator() {
        return new FoodOrderIterator(this);
    }

    @Override
    public void deliver() {
        log.info("Заказ доставлен: " + this.toString());
    }
}
