package facade;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TheaterLights {

    public void dim(int level) {
        log.info("TheaterLights dimmed to {}%..", level);
    }

    public void on() {
        log.info("TheaterLights ON..");
    }
}
