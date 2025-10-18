package basic;

import lombok.extern.log4j.Log4j2;

@Log4j2
class ConcreteObserverA implements IObserver {

    @Override
    public void update(String state) {
        displayState(state);
    }

    private void displayState(String state) {
        log.info("Observer A notified with new state: {}", state);

    }
}
