package common.dto.patterns.composite;

import common.dto.FoodOrder;

public class Main {

    public static void main(String[] args) {
        FoodOrder foodOrder1 = new FoodOrder();
        FoodOrder foodOrder2 = new FoodOrder();
        FoodOrder foodOrder3 = new FoodOrder();
        FoodOrder foodOrder4 = new FoodOrder();

        CompositePackage package1 = new CompositePackage();
        CompositePackage package2 = new CompositePackage();
        CompositePackage package3 = new CompositePackage();

        package1.add(foodOrder1);
        package2.add(foodOrder2);
        package1.add(foodOrder3);

        package3.add(package1);
        package3.add(package2);
        package3.add(foodOrder4);

        package3.deliver();
    }
}
