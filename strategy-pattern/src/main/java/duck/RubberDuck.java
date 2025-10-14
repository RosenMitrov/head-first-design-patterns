package duck;

import duck.fly.FlyNoWay;
import duck.quack.Squeak;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RubberDuck extends Duck {

    public RubberDuck() {
        super(new FlyNoWay(), new Squeak());
    }

    @Override
    public void display() {
        log.info("I am Rubber duck.. :)");
    }
}
