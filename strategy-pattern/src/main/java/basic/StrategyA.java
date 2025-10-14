package basic;

public class StrategyA implements ClientStrategy {
    @Override
    public void run() {
        System.out.println("Running... Strategy A");
    }
}
