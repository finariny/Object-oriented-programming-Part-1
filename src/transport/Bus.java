package transport;

import drivers.DriverCategoryD;

public class Bus extends Transport <DriverCategoryD> {

    private CapacityType capacityType;

    public enum CapacityType {
        ESPECIALLY_SMALL(null, 10),
        SMALL(null, 25),
        AVERAGE(40, 50),
        BIG(60, 80),
        ESPECIALLY_BIG(100, 120);

        private final Integer minimumNumberOfSeats;
        private final Integer maximumNumberOfSeats;

        CapacityType(Integer minimumNumberOfSeats, Integer maximumNumberOfSeats){
            this.minimumNumberOfSeats = minimumNumberOfSeats;
            this.maximumNumberOfSeats = maximumNumberOfSeats;
        }

        public final Integer getMinimumNumberOfSeats() {
            return this.minimumNumberOfSeats;
        }

        public final Integer getMaximumNumberOfSeats() {
            return this.maximumNumberOfSeats;
        }

        @Override
        public String toString() {
            if (minimumNumberOfSeats == null) {
                return name() + ": до " + maximumNumberOfSeats + " мест";
            }
            if (maximumNumberOfSeats == null) {
                return name() + ": свыше " + minimumNumberOfSeats + " мест";
            }
            return name() + ": " + minimumNumberOfSeats + " - " + maximumNumberOfSeats + " мест";
        }
    }

    public Bus(String brand, String model, double engineVolume, DriverCategoryD driverCategoryD, CapacityType capacityType) {
        super(brand, model, engineVolume, driverCategoryD);
        setCapacityType(capacityType);
    }

    public final void setCapacityType(CapacityType capacityType) {
        if (capacityType != null) {
            this.capacityType = capacityType;
        }
    }

    public final CapacityType getCapacityType() {
        return this.capacityType;
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

    @Override
    public void printType() {
        if (capacityType != null) {
            System.out.println(capacityType);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public void passDiagnostics() {
        System.out.println("Автобусы не могут проходить диагностику!");
    }
}
