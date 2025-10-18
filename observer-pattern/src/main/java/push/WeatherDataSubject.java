package push;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
class WeatherDataSubject implements ISubject {

    private final List<IObserver> observers;
    private double temperature;

    public WeatherDataSubject(double temperature) {
        this.observers = new ArrayList<>();
        this.temperature = temperature;
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
            observer.update(temperature);
        }
        log.info("******************************");
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
