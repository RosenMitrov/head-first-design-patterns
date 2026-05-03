package command.tv;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Tv {

    public void on() {
        log.info("TV ON..");
    }

    public void off() {
        log.info("TV OFF..");
    }

    public void volumeUp() {
        log.info("TV volume UP..");
    }

    public void volumeDown() {
        log.info("TV volume DOWN..");
    }
}
