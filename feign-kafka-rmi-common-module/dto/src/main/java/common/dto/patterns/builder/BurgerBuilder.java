package common.dto.patterns.builder;

public interface BurgerBuilder {

    // Этап 1
    public BurgerBuilder putBun();

    // Этап 2
    public BurgerBuilder putCutlet();

    // Этап 3
    public BurgerBuilder putSauce();

    // Этап 4

    public BurgerBuilder putCheese();

    // Выпуск автомобиля

    public Burger build();
}
