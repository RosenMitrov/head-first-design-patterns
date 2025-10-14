package duck.fly;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FlyNoWay implements FlyStrategy {

    @Override
    public void fly() {
        log.info("I cannot fly.");
    }
}
