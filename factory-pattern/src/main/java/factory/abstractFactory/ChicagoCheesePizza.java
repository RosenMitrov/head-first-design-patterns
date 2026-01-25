package factory.abstractFactory;

class ChicagoCheesePizza extends Pizza {
    private final PizzaIngredientFactory factory;

    public ChicagoCheesePizza(PizzaIngredientFactory factory) {
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
