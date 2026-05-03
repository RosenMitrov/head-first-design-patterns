package command.light;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Light {

    public void on() {
        log.info("Light ON..");
    }

    public void off() {
        log.info("Light OFF..");
    }
}
