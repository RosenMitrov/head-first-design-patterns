package command.tv;

import command.Command;

public class TvVolumeUpCommand implements Command {

    private final Tv tv;

    public TvVolumeUpCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.volumeUp();
    }

    @Override
    public void undo() {
        tv.volumeDown();
    }
}
