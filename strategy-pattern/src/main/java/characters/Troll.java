package characters;

import characters.weapon.behaviors.WeaponBehavior;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Troll extends Character {

    private static final String TYPE = "TROLL";

    public Troll(WeaponBehavior weaponBehavior) {
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
