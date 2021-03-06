package patterns.strategy.pattern.adventure.game;

public class AdventureGame {

    public static void main(String[] args) {
        Character king = new King();
        king.setWeaponBehavior(new SwordBehavior());
        king.fight();
        king.useWeapon();
        king.setWeaponBehavior(new AxeBehavior());
        king.useWeapon();

        System.out.println();
        Character queen = new Queen();
        queen.setWeaponBehavior(new KnifeBehavior());
        queen.fight();
        queen.useWeapon();
        queen.setWeaponBehavior(new BowAndArrowBehavior());
        queen.useWeapon();
    }
}
