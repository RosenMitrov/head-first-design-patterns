package facade;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Projector {

    public void on() {
        log.info("Projector ON..");
    }

    public void off() {
        log.info("Projector OFF..");
    }

    public void wideScreenMode() {
        log.info("Projector in widescreen mode..");
    }
}
