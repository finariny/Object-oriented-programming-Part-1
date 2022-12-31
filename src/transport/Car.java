package transport;

public class Car {

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessEntry;

        public Key (boolean remoteEngineStart, boolean keylessEntry) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessEntry = keylessEntry;
        }

        public Key () {
            this (false, false);
        }

        public boolean getRemoteEngineStart () {
            return this.remoteEngineStart;
        }

        public boolean getKeylessEntry () {
            return this.keylessEntry;
        }

        @Override
        public String toString () {
            return "Удаленный запуск двигателя - " + remoteEngineStart + "; Бесключевой доступ - " + keylessEntry;
        }

        @Override
        public boolean equals (Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }

            Key key = (Key) object;
            return this.remoteEngineStart == key.remoteEngineStart && this.keylessEntry == key.keylessEntry;
        }

        @Override
        public int hashCode () {
            return java.util.Objects.hash(remoteEngineStart, keylessEntry);
        }
    }
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;

    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private boolean isItSummerTires;

    private Key key;

    public Car (String brand, String model, double engineVolume, String color, int year, String country,
                String transmission, String bodyType, String registrationNumber, int numberOfSeats,
                boolean isItSummerTires, Key key) {

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

        if (country == null || country.isBlank()) {
            this.country = "default";
        } else {
            this.country = country;
        }

        setEngineVolume(engineVolume);

        setColor(color);

        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }

        setTransmission(transmission);

        if (bodyType == null || bodyType.isBlank()) {
            this.bodyType = "default";
        } else {
            this.bodyType = bodyType;
        }

        setRegistrationNumber(registrationNumber);

        if (numberOfSeats < 1) {
            this.numberOfSeats = 5;
        } else {
            this.numberOfSeats = numberOfSeats;
        }

        this.isItSummerTires = isItSummerTires;

        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }
    }

    public Car(String brand, String model, double engineVolume, String color, int year, String country) {
        this (brand, model , engineVolume, color, year, country, "", "", "",
                0, false, new Key());
    }

    public void changeTiresToSeasonal (int month) {
        if (month >= 3 && month < 12) {
            System.out.println("У машины " + this.brand + " установлена летняя резина");
            this.isItSummerTires = true;
        } else if (month >= 1 && month < 3 || month == 12) {
            System.out.println("У машины " + this.brand + " установлена зимняя резина");
            this.isItSummerTires = false;
        } else {
            System.out.println("Такого месяца нет");
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public void setTransmission(String transmission) {
        if (transmission == null || transmission.isBlank()) {
            this.transmission = "default";
        } else {
            this.transmission = transmission;
        }
    }

    public String getTransmission() {
        return transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank()) {
            this.registrationNumber = "default";
        } else {
            this.registrationNumber = registrationNumber;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setIsItSummerTires(boolean isItSummerTires) {
        this.isItSummerTires = isItSummerTires;
    }

    public boolean getIsItSummerTires() {
        return isItSummerTires;
    }

    public void setKey (Key key) {
        this.key = key;
    }

    public Key getKey () {
        return this.key;
    }

    @Override
    public String toString() {
        return "Марка - " + brand + "; Модель - " + model + "; Объем двигателя в литрах - " + engineVolume
                + "; Цвет кузова - " + color + "; Год производства - " + year + "; Страна сборки - " + country
                + "; Коробка передач - " + transmission + "; Тип кузова - " + bodyType + "; Регистрационный номер - "
                + registrationNumber + "; Количество мест - " + numberOfSeats + "; Установлена "
                + (isItSummerTires ? "летняя" : "зимняя") + " резина";
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return this.brand.equals(car.brand) && this.model.equals(car.model)
                && this.year == car.year && this.country.equals(car.country);
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(brand, model, year, country);
    }
}
