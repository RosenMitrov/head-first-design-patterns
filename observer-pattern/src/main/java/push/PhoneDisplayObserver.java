package push;

import lombok.extern.log4j.Log4j2;

@Log4j2
class PhoneDisplayObserver implements IObserver {

    //no need to keep reference of the Subject as it is push based

    @Override
    public void update(double temperature) {
        display(temperature);
    }

    private void display(double temperature) {
        log.info("Received new temperature: {}", "%.2f".formatted(temperature));
    }
}
