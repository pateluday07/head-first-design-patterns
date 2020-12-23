package patterns.strategy.pattern.adventure.game;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("chopping with an axe");
    }
}
