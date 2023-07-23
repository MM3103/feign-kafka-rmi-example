package common.dto.patterns.builder;

public class СhickenBurger implements BurgerBuilder {

    private String bun;
    private String cutlet;
    private String sauce;
    private String cheese;

    @Override
    public BurgerBuilder putBun() {
        this.bun = "Булочка для бургеров";
        return this;
    }

    @Override
    public BurgerBuilder putCutlet() {
        this.cutlet = "Куриная котлета";
        return this;
    }

    @Override
    public BurgerBuilder putSauce() {
        this.sauce = "Майонез";
        return this;
    }

    @Override
    public BurgerBuilder putCheese() {
        this.cheese = "Без сыра";
        return this;
    }

    @Override
    public Burger build() {
        return new Burger(bun, cutlet, sauce, cheese);
    }
}
