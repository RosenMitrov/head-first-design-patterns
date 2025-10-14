package basic;

public class StrategyB implements ClientStrategy {
    @Override
    public void run() {
        System.out.println("Running... Strategy B");
    }
}
