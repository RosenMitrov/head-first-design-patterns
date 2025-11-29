package coffee;

public class Espresso extends Coffee {


    public Espresso() {
        super.setDescription("Espresso");
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
