package facade;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DvdPlayer {

    public void on() {
        log.info("DvdPlayer ON..");
    }

    public void off() {
        log.info("DvdPlayer OFF..");
    }

    public void play(String movie) {
        log.info("DvdPlayer playing movie: {}", movie);
    }

    public void stop() {
        log.info("DvdPlayer movie stop..");
    }

}
