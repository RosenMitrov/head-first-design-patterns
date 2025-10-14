package characters.weapon.behaviors;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        log.info("Using SWORD !");
    }
}
