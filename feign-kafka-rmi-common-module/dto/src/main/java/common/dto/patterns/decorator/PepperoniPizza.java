package common.dto.patterns.decorator;

public class PepperoniPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Pepperoni";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}
