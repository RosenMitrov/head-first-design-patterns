package basic;

class MainBasic {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        IObserver observerA = new ConcreteObserverA();
        IObserver observerB = new ConcreteObserverB();

        subject.register(observerA);
        subject.register(observerB);

        subject.setState("First State");
        subject.setState("Second State");

    }
}
