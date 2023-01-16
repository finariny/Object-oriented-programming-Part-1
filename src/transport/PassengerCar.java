package transport;

import drivers.DriverCategoryB;

public class PassengerCar extends Transport <DriverCategoryB> {

    public PassengerCar (String brand, String model, double engineVolume, DriverCategoryB driverCategoryB) {
        super(brand, model, engineVolume, driverCategoryB);
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
}
