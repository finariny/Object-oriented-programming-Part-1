package transport;

public class Car extends Transport {

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
    private double engineVolume;

    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private boolean isItSummerTires;

    private Key key;

    public Car (String brand, String model, double engineVolume, String color, int year, String country,
                String transmission, String bodyType, String registrationNumber, int numberOfSeats,
                boolean isItSummerTires, Key key, int maxMovementSpeed) {

        super(brand, model, year, country, color, maxMovementSpeed);

        setEngineVolume(engineVolume);
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
                0, false, new Key(), 0);
    }

    public final void changeTiresToSeasonal (int month) {
        if (month >= 3 && month < 12) {
            System.out.println("У машины " + this.getBrand() + " установлена летняя резина");
            this.isItSummerTires = true;
        } else if (month >= 1 && month < 3 || month == 12) {
            System.out.println("У машины " + this.getBrand() + " установлена зимняя резина");
            this.isItSummerTires = false;
        } else {
            System.out.println("Такого месяца нет");
        }
    }

    public final void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public final double getEngineVolume() {
        return engineVolume;
    }

    public final void setTransmission(String transmission) {
        if (transmission == null || transmission.isBlank()) {
            this.transmission = "default";
        } else {
            this.transmission = transmission;
        }
    }

    public final String getTransmission() {
        return transmission;
    }

    public final String getBodyType() {
        return bodyType;
    }

    public final void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank()) {
            this.registrationNumber = "default";
        } else {
            this.registrationNumber = registrationNumber;
        }
    }

    public final String getRegistrationNumber() {
        return registrationNumber;
    }

    public final int getNumberOfSeats() {
        return numberOfSeats;
    }

    public final void setIsItSummerTires(boolean isItSummerTires) {
        this.isItSummerTires = isItSummerTires;
    }

    public final boolean getIsItSummerTires() {
        return isItSummerTires;
    }

    public final void setKey (Key key) {
        this.key = key;
    }

    public final Key getKey () {
        return this.key;
    }

    @Override
    public String toString() {
        return "Марка - " + getBrand() + "; Модель - " + getModel() + "; Объем двигателя в литрах - " + engineVolume +
                "; Цвет кузова - " + getColor() + "; Год производства - " + getYear() + "; Страна сборки - " +
                getCountry() + "; Максимальная скорость передвижения - " + getMaxMovementSpeed() +
                "; Коробка передач - " + transmission + "; Тип кузова - " + bodyType + "; Регистрационный номер - " +
                registrationNumber + "; Количество мест - " + numberOfSeats + "; Установлена " +
                (isItSummerTires ? "летняя" : "зимняя") + " резина";
    }
}
