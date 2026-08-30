package patterns.creational.builder;

import patterns.creational.builder.bad.BadHouse;

public class Tester {

    public static void main(String[] args) {

        // Bad implementation
        System.out.println("Bad implementation:");
        BadHouse badHouse = new BadHouse(
                "Wooden Door", "Glass Window", "Brick Wall", "Concrete Roof", "Big Pool", "Big Garden with Trees", "Medium", "Small"
        );
        System.out.println(badHouse);

        // Good implementation using Builder pattern
        System.out.println("\nGood implementation using Builder pattern:");
        House house = new House.HouseBuilder()
                .door("Wooden Door")
                .window("Glass Window")
                .wall("Brick Wall")
                .roof("Concrete Roof")
                .swimmingPool("Big Pool")
                .garden("Big Garden with Trees")
                .garage("Medium")
                .basement("Small")
                .build();
        System.out.println(house);
    }
}
