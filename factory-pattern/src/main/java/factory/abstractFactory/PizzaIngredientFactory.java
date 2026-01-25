package factory.abstractFactory;

interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();
}
