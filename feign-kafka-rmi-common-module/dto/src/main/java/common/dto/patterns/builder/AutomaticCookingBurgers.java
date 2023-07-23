package common.dto.patterns.builder;

public class AutomaticCookingBurgers {

    private BurgerBuilder burgerBuilder;

    public AutomaticCookingBurgers(BurgerBuilder builder) {
        super();
        this.burgerBuilder = builder;
    }

    public Burger CookingBurgers() {
        return burgerBuilder.putBun().putCutlet().putSauce().putCheese().build();
    }
}
