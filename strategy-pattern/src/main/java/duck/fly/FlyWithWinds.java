package duck.fly;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FlyWithWinds implements FlyStrategy {

    @Override
    public void fly() {
        log.info("FLying with wings...");
    }
}
