package push;

import java.util.Random;

class WeatherStationMain {
    public static void main(String[] args) throws InterruptedException {
        WeatherDataSubject data = new WeatherDataSubject(25.00);
        PhoneDisplayObserver phoneDisplayObserver = new PhoneDisplayObserver();
        WatchDisplayObserver watchDisplayObserver = new WatchDisplayObserver();

        data.register(phoneDisplayObserver);
        data.register(watchDisplayObserver);

        simulateTempChanges(data);
    }

    private static void simulateTempChanges(WeatherDataSubject data) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            double temperature = -10 + (50 * new Random().nextDouble());
            data.setTemperature(temperature);
            Thread.sleep(1000);
        }
    }
}
