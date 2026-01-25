package factory.abstractMethodFactory;

class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(PizzaType type) {
        return switch (type) {
            case PizzaType.CHEESE -> new ChicagoStyleCheesePizza();
            case PizzaType.PEPPERONI -> new ChicagoStylePepperoniPizza();
            case PizzaType.CLAM -> new ChicagoStyleClamPizza();
            case PizzaType.VEGGIE -> new ChicagoStyleVeggiePizza();
            case null -> throw new IllegalArgumentException("No such pizza");
        };
    }
}
