package patterns.strategy.pattern.duck.simulation;

public class RedHeadDuck extends Duck {

    public RedHeadDuck(){
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyWithWings());
    }

    @Override
    protected void display() {
        System.out.println("I am Red Head Duck!");
    }
}
