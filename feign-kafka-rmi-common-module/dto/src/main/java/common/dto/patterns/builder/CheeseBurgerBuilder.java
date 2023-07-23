package common.dto.patterns.builder;

public class CheeseBurgerBuilder implements BurgerBuilder{

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
        this.cutlet = "Говяжья котлета";
        return this;
    }

    @Override
    public BurgerBuilder putSauce() {
        this.sauce = "Кетчуп";
        return this;
    }

    @Override
    public BurgerBuilder putCheese() {
        this.cheese = "Cыр чеддер";
        return this;
    }

    @Override
    public Burger build() {
        return new Burger(bun, cutlet, sauce, cheese);
    }
}
