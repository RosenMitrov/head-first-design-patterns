package adapter.book;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Client {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Turkey wildTurkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);

        log.info("The MallardDuck START...");
        mallardDuck.quack();
        mallardDuck.fly();
        log.info("The MallardDuck END...");
        log.info("The WildTurkey START...");
        wildTurkey.gobble();
        wildTurkey.fly();
        log.info("The WildTurkey END...");
        log.info("The TurkeyAdapter START...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
        log.info("The TurkeyAdapter END...");
    }
}
