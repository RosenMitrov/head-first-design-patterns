package factory.abstractFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        NYThinCrustDough dough = new NYThinCrustDough();
        log.info("Creating Dough: {} with Factory: {}",
                dough.getClass().getSimpleName(),
                this.getClass().getSimpleName());
        return dough;
    }

    @Override
    public Sauce createSauce() {
        NYMarinaraSauce sauce = new NYMarinaraSauce();
        log.info("Creating Sauce: {} with Factory: {}",
                sauce.getClass().getSimpleName(),
                this.getClass().getSimpleName());
        return sauce;
    }

    @Override
    public Cheese createCheese() {
        NYReggianoCheese cheese = new NYReggianoCheese();
        log.info("Creating Cheese: {} with Factory: {}",
                cheese.getClass().getSimpleName(),
                this.getClass().getSimpleName());
        return cheese;
    }
}
