package factory.abstractMethodFactory;

class NYStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(PizzaType type) {

        return switch (type) {
            case PizzaType.CHEESE -> new NYStyleCheesePizza();
            case PizzaType.PEPPERONI -> new NYStylePepperoniPizza();
            case PizzaType.CLAM -> new NyStyleClamPizza();
            case PizzaType.VEGGIE -> new NyStyleVeggiePizza();
            case null -> throw new IllegalArgumentException("No such pizza");
        };
    }
}
