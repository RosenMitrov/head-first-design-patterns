package factory.abstractFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        ChicagoThickCrustDough dough = new ChicagoThickCrustDough();
        log.info("Creating Dough: {} with Factory: {}",
                dough.getClass().getSimpleName(),
                this.getClass().getSimpleName());
        return dough;
    }

    @Override
    public Sauce createSauce() {
        ChicagoPlumTomatoSauce sauce = new ChicagoPlumTomatoSauce();
        log.info("Creating Sauce: {} with Factory: {}",
                sauce.getClass().getSimpleName(),
                this.getClass().getSimpleName());
        return sauce;
    }

    @Override
    public Cheese createCheese() {
        ChicagoMozzarellaCheese cheese = new ChicagoMozzarellaCheese();
        log.info("Creating Cheese: {} with Factory: {}",
                cheese.getClass().getSimpleName(),
                this.getClass().getSimpleName());
        return cheese;
    }
}
