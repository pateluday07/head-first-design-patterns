package patterns.strategy.pattern.duck.simulation;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Sorry I can't fly!");
    }
}
