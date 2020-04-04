package Beverage;

abstract class BeverageBase {

    protected String description = "";

    public String getDescription() {
        return description;
    }

    public abstract double getCost();
}

class BlackTea extends BeverageBase {

    public BlackTea() {
        description = "Black tea from teabag";
    }

    @Override
    public double getCost() {
        return 5;
    }
}

class GreenTea extends BeverageBase {

    public GreenTea() {
        description = "Green leaf tea";
    }

    @Override
    public double getCost() {
        return 8;
    }
}

class Espresso extends BeverageBase {

    public Espresso() {
        description = "Small portion of strong coffee";
    }

    @Override
    public double getCost() {
        return 12;
    }
}

//////////////////////////////////////////////////////////////////

abstract class CondimentsDecoratorBase extends BeverageBase {

}

class MilkCondiment extends CondimentsDecoratorBase {

    private BeverageBase beverage;

    public MilkCondiment(BeverageBase beverage) {
        this.beverage = beverage;
        description = this.beverage.getDescription() + " + Milk";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 3;
    }
}

class ChocolateCondiment extends CondimentsDecoratorBase {

    private BeverageBase beverage;

    public ChocolateCondiment(BeverageBase beverage) {
        this.beverage = beverage;
        description = this.beverage.getDescription() + " + Chocolate";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 4;
    }
}

class SugarCondiment extends CondimentsDecoratorBase {

    private BeverageBase beverage;

    public SugarCondiment(BeverageBase beverage) {
        this.beverage = beverage;
        description = beverage.getDescription() + " + Sugar";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 1;
    }
}

////////////////////////////////////////////////////////////////////////

public class Beverage {

    static void printBeverage(BeverageBase beverage) {
        System.out.println("Beverage: " + beverage.getDescription()
                + ", Cost: " + beverage.getCost());
    }

    public static void main(String args[]) throws Exception {
        BeverageBase espresso = new Espresso();
        BeverageBase blackTea = new BlackTea();
        BeverageBase greenTea = new GreenTea();

        printBeverage(espresso);
        printBeverage(blackTea);
        printBeverage(greenTea);

        System.out.println("========================");

        BeverageBase capuccino = new SugarCondiment(new MilkCondiment(new Espresso()));
        printBeverage(capuccino);

        BeverageBase greenTeaWithSugar = new SugarCondiment(new GreenTea());
        printBeverage(greenTeaWithSugar);

    }
}