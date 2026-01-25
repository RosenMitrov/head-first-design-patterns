package factory.abstractFactory;

public class AbstractMain {
    public static void main(String[] args) {
        PizzaIngredientFactory nyFactory = new NYPizzaIngredientFactory();
        Pizza nyCheesePizza = new NYCheesePizza(nyFactory);
        nyCheesePizza.prepare();

        PizzaIngredientFactory chicagoFactory = new ChicagoPizzaIngredientFactory();
        Pizza chicagoCheesePizza = new ChicagoCheesePizza(chicagoFactory);
        chicagoCheesePizza.prepare();
    }
}
