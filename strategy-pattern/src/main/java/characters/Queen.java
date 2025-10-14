package characters;

import characters.weapon.behaviors.WeaponBehavior;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Queen extends Character {
    private static final String TYPE = "QUEEN";

    public Queen(WeaponBehavior weaponBehavior) {
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
