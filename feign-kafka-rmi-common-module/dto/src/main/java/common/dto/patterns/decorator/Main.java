package common.dto.patterns.decorator;

public class Main {

    public static void main(String[] args) {

        Pizza pepperoniPizzaWithCheese = new PepperoniPizza();
        pepperoniPizzaWithCheese = new CheeseDecorator(pepperoniPizzaWithCheese);
        System.out.println(pepperoniPizzaWithCheese.getDescription() + ": $" + pepperoniPizzaWithCheese.getCost());

        Pizza pepperoniPizzaWithoutCheese = new PepperoniPizza();
        pepperoniPizzaWithoutCheese = new CheeseDecorator(pepperoniPizzaWithoutCheese);
        pepperoniPizzaWithoutCheese = new NoCheeseDecorator(pepperoniPizzaWithoutCheese);
        System.out.println(pepperoniPizzaWithoutCheese.getDescription() + ": $" + pepperoniPizzaWithoutCheese.getCost());
    }
}
