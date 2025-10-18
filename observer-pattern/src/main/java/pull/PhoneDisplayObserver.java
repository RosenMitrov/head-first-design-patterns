package pull;


import lombok.extern.log4j.Log4j2;

@Log4j2
class PhoneDisplayObserver implements IObserver {

    private final WeatherDataSubject weatherDataSubject;

    public PhoneDisplayObserver(WeatherDataSubject weatherDataSubject) {
        this.weatherDataSubject = weatherDataSubject;
        this.weatherDataSubject.addObserver(this);
    }

    @Override
    public void update() {
        double newTemperature = this.weatherDataSubject.getTemperature();
        display(newTemperature);
    }

    private void display(double temperature) {
        log.info("Received new temperature: {}", "%.2f".formatted(temperature));
    }
}
