package transport;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final int year;
    private final String country;
    private String color;
    private int maxMovementSpeed;

    public Transport(String brand, String model, int year, String country, String color, int maxMovementSpeed) {
        if (brand == null || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }

        if (model == null || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }

        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }

        if (country == null || country.isBlank()) {
            this.country = "default";
        } else {
            this.country = country;
        }

        setColor(color);
        setMaxMovementSpeed(maxMovementSpeed);
    }

    public final String getBrand() {
        return brand;
    }

    public final String getModel() {
        return model;
    }

    public final int getYear() {
        return year;
    }

    public final String getCountry() {
        return country;
    }

    public final void setColor(String color) {
        if (color == null || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
    }

    public final String getColor() {
        return color;
    }

    public final void setMaxMovementSpeed (int speed) {
        if (speed <= 0) {
            this.maxMovementSpeed = 60;
        } else {
            this.maxMovementSpeed = speed;
        }
    }

    public final int getMaxMovementSpeed () {
        return this.maxMovementSpeed;
    }

    @Override
    public String toString() {
        return "Марка - " + brand + "; Модель - " + model + "; Год производства - " + year + "; Страна сборки - " +
                country + "; Цвет кузова - " + color + "; Максимальная скорость передвижения - " + maxMovementSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Transport transport = (Transport) o;
        return this.brand.equals(transport.brand) && this.model.equals(transport.model) && this.year == transport.year &&
                this.country.equals(transport.country);
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(brand, model, year, country);
    }
}