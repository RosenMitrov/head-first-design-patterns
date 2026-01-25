package factory.abstractFactory;

class NYCheesePizza extends Pizza {
    private final PizzaIngredientFactory factory;

    public NYCheesePizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    protected void prepareDough() {
        super.dough = factory.createDough();
    }

    @Override
    protected void prepareSauce() {
        super.sauce = factory.createSauce();
    }

    @Override
    protected void prepareCheese() {
        super.cheese = factory.createCheese();
    }

}
