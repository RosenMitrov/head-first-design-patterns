package adapter.book;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MallardDuck implements Duck {

    @Override
    public void quack() {
       log.info("Mallard duck - quack, quack..");
    }

    @Override
    public void fly() {
        log.info("Mallard duck flying long distance..");
    }
}
