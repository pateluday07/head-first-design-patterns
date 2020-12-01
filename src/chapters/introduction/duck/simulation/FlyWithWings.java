package chapters.introduction.duck.simulation;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I am flying with my wings!");
    }
}
