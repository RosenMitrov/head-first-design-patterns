package adapter.book;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        log.info("Wild turkey - gobble, gobble..");
    }

    @Override
    public void fly() {
        log.info("Wild turkey - flying short distance..");
    }
}
