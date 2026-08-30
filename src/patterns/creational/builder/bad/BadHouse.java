package patterns.creational.builder.bad;

public class BadHouse {

    private final String door;
    private final String window;
    private final String wall;
    private final String roof;
    private final String swimmingPool;
    private final String garden;
    private final String garage;
    private final String basement;

    public BadHouse(String door, String window, String wall, String roof, String swimmingPool, String garden, String garage, String basement) {
        this.door = door;
        this.window = window;
        this.wall = wall;
        this.roof = roof;
        this.swimmingPool = swimmingPool;
        this.garden = garden;
        this.garage = garage;
        this.basement = basement;
    }

    @Override
    public String toString() {
        return "BadHouse{" +
                "door='" + door + '\'' +
                ", window='" + window + '\'' +
                ", wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                ", swimmingPool='" + swimmingPool + '\'' +
                ", garden='" + garden + '\'' +
                ", garage='" + garage + '\'' +
                ", basement='" + basement + '\'' +
                '}';
    }
}
