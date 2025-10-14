package duck.quack;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Quack implements QuackStrategy {

    @Override
    public void quack() {
        log.info("Quacking...");
    }
}
