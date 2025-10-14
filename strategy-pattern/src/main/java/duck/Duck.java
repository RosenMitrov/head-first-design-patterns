package duck;

import duck.fly.FlyStrategy;
import duck.quack.QuackStrategy;

public abstract class Duck {

    FlyStrategy flyStrategy;
    QuackStrategy quackStrategy;

    public Duck(FlyStrategy flyStrategy,
                QuackStrategy quackStrategy) {
        this.flyStrategy = flyStrategy;
        this.quackStrategy = quackStrategy;
    }

    public void performFly() {
        this.flyStrategy.fly();
    }

    public void performQuack() {
        this.quackStrategy.quack();
    }

    public abstract void display();

    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    public void setQuackStrategy(QuackStrategy quackStrategy) {
        this.quackStrategy = quackStrategy;
    }
}
