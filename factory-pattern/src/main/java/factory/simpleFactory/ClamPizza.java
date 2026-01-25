package factory.simpleFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
class ClamPizza implements Pizza {

    @Override
    public void prepare() {
        log.info("Preparing Pizza...");
    }

    @Override
    public void bake() {
        log.info("Baking Pizza...");
    }

    @Override
    public void cut() {
        log.info("Cutting Pizza...");
    }

    @Override
    public void box() {
        log.info("Boxing Pizza...");
    }
}
