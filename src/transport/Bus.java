package transport;

import drivers.DriverCategoryD;

public class Bus extends Transport <DriverCategoryD> {

    public Bus(String brand, String model, double engineVolume, DriverCategoryD driverCategoryD) {
        super(brand, model, engineVolume, driverCategoryD);
    }

    @Override
    public void startMoving() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " начинает движение");
    }

    @Override
    public void finishMoving() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " заканчивает движение");
    }

    @Override
    public void pitStop() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " сделал пит-стоп");
    }

    @Override
    public void bestLapTime(double time) {
        System.out.println("Лучшее время круга у автобуса " + getBrand() + " " + getModel() + " - " + time);
    }

    @Override
    public void maximumSpeed (int speed) {
        System.out.println("Максимальная скорость у автобуса " + getBrand() + getModel() + " - " + speed);
    }
}
