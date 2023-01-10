package transport;

public class Bus extends Transport{

    public Bus (String brand, String model) {
        super(brand, model, 0, "default", "белый", 60);
    }

    public Bus(String brand, String model, int year, String country, String color, int maxMovementSpeed) {
        super(brand, model, year, country, color, maxMovementSpeed);
    }
}
