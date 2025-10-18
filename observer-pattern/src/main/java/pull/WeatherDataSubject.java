package pull;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
class WeatherDataSubject implements ISubject {

    private final List<IObserver> observers;
    private double temperature;

    WeatherDataSubject(double temperature) {
        this.observers = new ArrayList<>();
        this.temperature = temperature;
    }

    @Override
    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
        log.info("******************************");
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
