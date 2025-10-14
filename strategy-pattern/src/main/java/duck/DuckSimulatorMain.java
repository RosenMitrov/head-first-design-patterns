package duck;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DuckSimulatorMain {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        doDuckStuff(duck);
        duck = new ModelDuck();
        doDuckStuff(duck);
        duck = new RubberDuck();
        doDuckStuff(duck);
    }

    public static void doDuckStuff(Duck duck) {
        log.info("=============== START =====================");
        duck.display();
        duck.performFly();
        duck.performQuack();
        log.info("=============== END =======================");
    }
}
