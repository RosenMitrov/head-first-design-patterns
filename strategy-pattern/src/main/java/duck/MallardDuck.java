package duck;

import duck.fly.FlyWithWinds;
import duck.quack.Quack;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MallardDuck extends Duck {

    public MallardDuck() {
        super(new FlyWithWinds(), new Quack());
    }

    @Override
    public void display() {
        log.info("I am Mallard duck... :)");
    }
}
