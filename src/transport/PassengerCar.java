package transport;

import drivers.DriverCategoryB;

public class PassengerCar extends Transport <DriverCategoryB> {

    private BodyType bodyType;

    public enum BodyType {
        SEDAN("седан"),
        HATCHBACK("хетчбек"),
        COUPE("купе"),
        UNIVERSAL("универсал"),
        SUV("внедорожник"),
        CROSSOVER("кроссовер"),
        PICKUP("пикап"),
        VAN("фургон"),
        MINIVAN("минивэн");

        private final String typeInRussian;

        BodyType(String typeInRussian) {
            this.typeInRussian = typeInRussian;
        }

        public final String getTypeInRussian() {
            return this.typeInRussian;
        }

        @Override
        public String toString() {
            return name() + ": " + typeInRussian;
        }
    }

    public PassengerCar (String brand, String model, double engineVolume, DriverCategoryB driverCategoryB, BodyType bodyType) {
        super(brand, model, engineVolume, driverCategoryB);
        setBodyType(bodyType);
    }

    public final void setBodyType(BodyType bodyType) {
        if (bodyType != null) {
            this.bodyType = bodyType;
        }
    }

    public final BodyType getBodyType() {
        return this.bodyType;
    }

    @Override
    public void startMoving() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " начинает движение");
    }

    @Override
    public void finishMoving() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " заканчивает движение");
    }

    @Override
    public void pitStop() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " сделал пит-стоп");
    }

    @Override
    public void bestLapTime(double time) {
        System.out.println("Лучшее время круга у автомобиля " + getBrand() + " " + getModel() + " - " + time);
    }

    @Override
    public void maximumSpeed (int speed) {
        System.out.println("Максимальная скорость у автомобиля " + getBrand() + getModel() + " - " + speed);
    }

    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println(bodyType);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public void passDiagnostics() {
        try {
            this.checkDriverLicense();
        }
        catch (DriverLicenseNotSpecifiedException e) {
            System.out.println(e.getMessage());
        }
    }
}
