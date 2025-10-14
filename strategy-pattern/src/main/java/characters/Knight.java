package characters;

import characters.weapon.behaviors.WeaponBehavior;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Knight extends Character {
    private static final String TYPE = "KNIGHT";

    public Knight(WeaponBehavior weaponBehavior) {
        super(weaponBehavior);
    }

    @Override
    void fight() {
        this.weaponBehavior.useWeapon();
    }

    @Override
    void introduce() {
        log.info("I am {}", TYPE);
    }
}
