package factory.simpleFactory;

class SimpleMain {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());

        pizzaStore.orderPizza("cheese");
    }
}
