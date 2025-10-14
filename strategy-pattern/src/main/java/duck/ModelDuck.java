package duck;

import duck.fly.FlyNoWay;
import duck.quack.MuteQuack;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ModelDuck extends Duck {

    public ModelDuck() {
        super(new FlyNoWay(), new MuteQuack());
    }

    @Override
    public void display() {
        log.info("I am model duck.. :)");
    }
}
