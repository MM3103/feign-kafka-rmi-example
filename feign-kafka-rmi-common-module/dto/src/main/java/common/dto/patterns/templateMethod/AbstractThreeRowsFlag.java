package common.dto.patterns.templateMethod;

public abstract class AbstractThreeRowsFlag {

    abstract void drawUpperLevel();
    abstract void drawMiddleLevel();
    abstract void drawBottomLevel();

    final void drawFlag() {
        drawFlagpole();
        drawUpperLevel();
        drawMiddleLevel();
        drawBottomLevel();
        drawBlazon();
    }

    void drawFlagpole() {
        System.out.println("Флагшток нарисован");
    }

    void drawBlazon() {}
}
