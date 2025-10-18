package basic;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
class ConcreteSubject implements ISubject {

    private List<IObserver> observers;

    private String state = "No state";

    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(state);
        }
        log.info("******************************");
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}
