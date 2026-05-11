package facade;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Screen {

    public void up() {
        log.info("Screen going UP..");
    }

    public void down() {
        log.info("Screen going DOWN..");
    }
}
