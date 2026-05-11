package adapter.basic;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AdapteeSpecific implements Adaptee {

    @Override
    public void executeAdaptee() {
        log.info("Execute AdapteeSpecific..");
    }
}
