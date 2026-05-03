package command;

import command.light.Light;
import command.light.LightOffCommand;
import command.light.LightOnCommand;
import command.tv.*;

public class Client {
    public static void main(String[] args) {

        Light livingRoomLight = new Light();



        RemoteControl remote = new RemoteControl();

        Command lightOn = new LightOnCommand(livingRoomLight);
        remote.setCommand(lightOn);
        remote.pressButton();
        remote.pressUndo();

        Command lightOff = new LightOffCommand(livingRoomLight);
        remote.setCommand(lightOff);
        remote.pressButton();
        remote.pressUndo();

        Tv livingRommTv = new Tv();

        Command tvOn = new TvOnCommand(livingRommTv);
        remote.setCommand(tvOn);
        remote.pressButton();
        remote.pressUndo();

        Command tvOff = new TvOffCommand(livingRommTv);
        remote.setCommand(tvOff);
        remote.pressButton();
        remote.pressUndo();

        Command tvVolumeUp = new TvVolumeUpCommand(livingRommTv);
        remote.setCommand(tvVolumeUp);
        remote.pressButton();
        remote.pressUndo();

        Command tvVolumeDown = new TvVolumeDownCommand(livingRommTv);
        remote.setCommand(tvVolumeDown);
        remote.pressButton();
        remote.pressUndo();


    }
}
