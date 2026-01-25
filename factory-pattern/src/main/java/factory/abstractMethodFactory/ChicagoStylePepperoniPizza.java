package factory.abstractMethodFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
class ChicagoStylePepperoniPizza implements Pizza {

    @Override
    public void prepare() {
        log.info("[{}] Preparing Pizza...", this.getClass().getSimpleName());
    }

    @Override
    public void bake() {
        log.info("[{}] Baking Pizza...", this.getClass().getSimpleName());
    }

    @Override
    public void cut() {
        log.info("[{}] Cutting Pizza...", this.getClass().getSimpleName());
    }

    @Override
    public void box() {
        log.info("[{}] Boxing Pizza...", this.getClass().getSimpleName());
    }
}
