package facade;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Amplifier {


    public void on() {
        log.info("Amplifier ON..");
    }

    public void off() {
        log.info("Amplifier OFF..");
    }

    public void setVolume(int level) {
        log.info("Amplifier setting volume to: {}", level);
    }
}
