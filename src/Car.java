public class Car {
    String brand;
    String model;
    double engineVolume;
    String color;
    int year;
    String country;

    public Car (String brand, String model, double engineVolume, String color, int year, String country) {

        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }

        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = brand;
        }

        if (country == null || country.isEmpty() || country.isBlank()) {
            this.country = "default";
        } else {
            this.country = brand;
        }

        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }

        if (color == null || color.isEmpty() || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }

        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return "Марка - " + brand + "; Модель - " + model + "; Объем двигателя в литрах - " + engineVolume
                + "; Цвет кузова - " + color + "; Год производства - " + year + "; Страна сборки - " + country;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Car automobile = (Car) object;
        return this.brand.equals(automobile.brand) && this.model.equals(automobile.model)
                && this.engineVolume == automobile.engineVolume;
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(brand, model, engineVolume);
    }
}
