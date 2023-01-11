package transport;

import drivers.DriverCategoryC;

public class FreightCar extends Transport <DriverCategoryC> {

    public FreightCar (String brand, String model, double engineVolume, DriverCategoryC driverCategoryC) {
        super(brand, model, engineVolume, driverCategoryC);
    }

    @Override
    public void startMoving() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() + " начинает движение");
    }

    @Override
    public void finishMoving() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() + " заканчивает движение");
    }

    @Override
    public void pitStop() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() + " сделал пит-стоп");
    }

    @Override
    public void bestLapTime(double time) {
        System.out.println("Лучшее время круга у грузовика " + getBrand() + " " + getModel() + " - " + time);
    }

    @Override
    public void maximumSpeed (int speed) {
        System.out.println("Максимальная скорость у грузовика " + getBrand() + getModel() + " - " + speed);
    }
}
