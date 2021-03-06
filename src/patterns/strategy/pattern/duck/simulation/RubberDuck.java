package patterns.strategy.pattern.duck.simulation;

public class RubberDuck extends Duck {

    public RubberDuck(){
        setQuackBehavior(new Squeak());
        setFlyBehavior(new FlyNoWay());
    }

    @Override
    protected void display() {
        System.out.println("I am a Rubber Duck!");
    }
}
