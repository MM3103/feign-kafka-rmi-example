package common.dto.patterns.decorator;

public class NoCheeseDecorator extends PizzaDecorator {
    public NoCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription().replace(", Cheese", "");
    }

    public double getCost() {
        return pizza.getCost() - 2.00;
    }
}
