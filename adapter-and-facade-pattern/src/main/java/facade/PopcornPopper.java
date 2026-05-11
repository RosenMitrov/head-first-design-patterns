package facade;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PopcornPopper {

    public void on() {
        log.info("PopcornPopper ON..");
    }

    public void off() {
        log.info("PopcornPopper OFF..");
    }

    public void pop() {
        log.info("PopcornPopper popping POPCORN..");
    }
}
