package basic;

public class Client {
    ClientStrategy clientStrategy;

    public Client(ClientStrategy clientStrategy) {
        this.clientStrategy = clientStrategy;
    }

    public void execute() {
        this.clientStrategy.run();
    }
}
