package factory.abstractFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
abstract class Pizza {

    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;

    final void prepare() {
        prepareDough();
        prepareSauce();
        prepareCheese();
        log.info("Prepared Pizza: {}", this.getClass().getSimpleName());
    }

    protected abstract void prepareDough();

    protected abstract void prepareSauce();

    protected abstract void prepareCheese();
}
