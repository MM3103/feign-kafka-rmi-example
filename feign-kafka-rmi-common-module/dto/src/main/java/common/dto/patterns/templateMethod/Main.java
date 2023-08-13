package common.dto.patterns.templateMethod;

class Main {
    public static void main(String[] args) {
        System.out.println("Draw Russian flag:");
        AbstractThreeRowsFlag russianFlag = new RussianFlag();
        russianFlag.drawFlag();

        System.out.println("Draw flag:");
        AbstractThreeRowsFlag netherlandsFlag = new NetherlandsFlag();
        netherlandsFlag.drawFlag();
    }
}
