package coffee;

public class WithSugar extends CoffeeDecorator {

    private final Coffee coffee;

    public WithSugar(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.20;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", Sugar";
    }
}
