package facade;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HomeTheaterTestDrive {

    public static void main(String[] args) {

        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        PopcornPopper popper = new PopcornPopper();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights, screen, popper);

        log.info("****************");
        homeTheater.watchMovie("Inception");

        log.info("****************");
        homeTheater.endMovie();
    }
}