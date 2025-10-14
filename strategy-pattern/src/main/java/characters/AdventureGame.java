package characters;

import characters.weapon.behaviors.AxeBehavior;
import characters.weapon.behaviors.BowAndArrowBehavior;
import characters.weapon.behaviors.KnifeBehavior;
import characters.weapon.behaviors.SwordBehavior;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AdventureGame {
    public static void main(String[] args) {
        Character king = new King(new SwordBehavior());
        performCharacter(king);
        logWhenSettingNewWeaopn();
        king.setWeaponBehavior(new KnifeBehavior());
        performCharacter(king);

        Character queen = new Queen(new KnifeBehavior());
        performCharacter(queen);
        logWhenSettingNewWeaopn();
        queen.setWeaponBehavior(new SwordBehavior());
        performCharacter(queen);

        Character troll = new Troll(new AxeBehavior());
        performCharacter(troll);
        logWhenSettingNewWeaopn();
        troll.setWeaponBehavior(new BowAndArrowBehavior());
        performCharacter(troll);

        Character knight = new Knight(new BowAndArrowBehavior());
        performCharacter(knight);
        logWhenSettingNewWeaopn();
        knight.setWeaponBehavior(new AxeBehavior());
        performCharacter(knight);

    }

    private static void logWhenSettingNewWeaopn() {
        log.info("Set new weapon to character");
    }

    public static void performCharacter(Character character) {
        log.info("============= START FIGHTING ================");
        character.introduce();
        character.fight();
    }
}
