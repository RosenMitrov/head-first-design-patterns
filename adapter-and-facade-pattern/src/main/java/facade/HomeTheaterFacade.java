package facade;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HomeTheaterFacade implements TheaterFacade {

    private final Amplifier amplifier;
    private final DvdPlayer dvdPlayer;
    private final Projector projector;
    private final TheaterLights theaterLights;
    private final Screen screen;
    private final PopcornPopper popcornPopper;

    public HomeTheaterFacade(Amplifier amplifier,
                             DvdPlayer dvdPlayer,
                             Projector projector,
                             TheaterLights theaterLights,
                             Screen screen,
                             PopcornPopper popcornPopper) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.theaterLights = theaterLights;
        this.screen = screen;
        this.popcornPopper = popcornPopper;
    }

    @Override
    public void watchMovie(String movie) {
        log.info("Get ready to watch movie..");

        popcornPopper.on();
        popcornPopper.pop();

        theaterLights.on();
        theaterLights.dim(10);

        screen.down();

        projector.on();
        projector.wideScreenMode();

        amplifier.on();
        amplifier.setVolume(5);

        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    @Override
    public void endMovie() {
        log.info("Shutting movie theater down...");

        popcornPopper.off();

        theaterLights.on();

        projector.off();

        screen.up();

        amplifier.off();

        dvdPlayer.stop();
        dvdPlayer.off();
    }
}
