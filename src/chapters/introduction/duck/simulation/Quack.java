package chapters.introduction.duck.simulation;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack Quack..");
    }
}