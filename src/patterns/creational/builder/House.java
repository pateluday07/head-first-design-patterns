package patterns.creational.builder;

public class House {

    private final String door;
    private final String window;
    private final String wall;
    private final String roof;
    private final String swimmingPool;
    private final String garden;
    private final String garage;
    private final String basement;

    private House(String door, String window, String wall, String roof, String swimmingPool, String garden, String garage, String basement) {
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
        return "House{" +
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

    public static class HouseBuilder {
        private String door;
        private String window;
        private String wall;
        private String roof;
        private String swimmingPool;
        private String garden;
        private String garage;
        private String basement;

        public HouseBuilder door(String door) {
            this.door = door;
            return this;
        }

        public HouseBuilder window(String window) {
            this.window = window;
            return this;
        }

        public HouseBuilder wall(String wall) {
            this.wall = wall;
            return this;
        }

        public HouseBuilder roof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder swimmingPool(String swimmingPool) {
            this.swimmingPool = swimmingPool;
            return this;
        }

        public HouseBuilder garden(String garden) {
            this.garden = garden;
            return this;
        }

        public HouseBuilder garage(String garage) {
            this.garage = garage;
            return this;
        }

        public HouseBuilder basement(String basement) {
            this.basement = basement;
            return this;
        }

        public House build() {
            return new House(door, window, wall, roof, swimmingPool, garden, garage, basement);
        }
    }
}
