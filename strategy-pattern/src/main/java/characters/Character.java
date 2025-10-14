package characters;

import characters.weapon.behaviors.WeaponBehavior;

public abstract class Character {

    WeaponBehavior weaponBehavior;

    public Character(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    abstract void fight();

    abstract void introduce();

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
