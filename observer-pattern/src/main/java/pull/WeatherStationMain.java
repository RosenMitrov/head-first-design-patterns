package pull;

import java.util.Random;

class WeatherStationMain {
    public static void main(String[] args) throws InterruptedException {
        WeatherDataSubject station = new WeatherDataSubject(25);
        PhoneDisplayObserver phoneDisplayObserver = new PhoneDisplayObserver(station);
        WatchDisplayObserver watchDisplayObserver = new WatchDisplayObserver(station);
        station.notifyObservers();


        simulateTempChanges(station);
    }

    private static void simulateTempChanges(WeatherDataSubject station) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            double temperature = -10 + (50 * new Random().nextDouble());
            station.setTemperature(temperature);
            Thread.sleep(1000);
        }
    }
}
