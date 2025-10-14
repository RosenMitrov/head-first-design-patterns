package characters;

import characters.weapon.behaviors.WeaponBehavior;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class King extends Character {

    private static final String TYPE = "KING";
    private static final Logger log = LogManager.getLogger(King.class);

    public King(WeaponBehavior weaponBehavior) {
        super(weaponBehavior);
    }

    @Override
    void fight() {
        super.weaponBehavior.useWeapon();
    }

    @Override
    void introduce() {
        log.info("I am {}", TYPE);
    }
}
