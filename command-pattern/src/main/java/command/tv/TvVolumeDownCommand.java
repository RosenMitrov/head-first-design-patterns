package command.tv;

import command.Command;

public class TvVolumeDownCommand implements Command {

    private final Tv tv;

    public TvVolumeDownCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.volumeDown();
    }

    @Override
    public void undo() {
        tv.volumeUp();
    }
}
