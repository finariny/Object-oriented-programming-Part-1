package transport;

import drivers.DriverCategoryC;

public class FreightCar extends Transport <DriverCategoryC> {

    private LoadType loadType;

    public enum LoadType {
        N1(null, 3.5F),
        N2(3.5F, 12F),
        N3(12F, null);

        private final Float bottomBound;
        private final Float upperBound;

        LoadType(Float bottomBound, Float upperBound) {
            this.bottomBound = bottomBound;
            this.upperBound = upperBound;
        }

        public final Float getBottomBound() {
            return this.bottomBound;
        }

        public final Float getUpperBound() {
            return this.upperBound;
        }

        @Override
        public String toString() {
            if (bottomBound == null) {
                return name() + ": до " + upperBound + " тонн";
            }
            if (upperBound == null) {
                return name() + ": свыше " + bottomBound + " тонн";
            }
            return name() + ": от " + bottomBound + " до " + upperBound + " тонн";
        }
    }

    public FreightCar (String brand, String model, double engineVolume, DriverCategoryC driverCategoryC, LoadType loadType) {
        super(brand, model, engineVolume, driverCategoryC);
        setLoadType(loadType);
    }

    public final void setLoadType(LoadType loadType) {
        if (loadType != null) {
            this.loadType = loadType;
        }
    }

    public final LoadType getLoadType() {
        return this.loadType;
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

    @Override
    public void printType() {
        if (loadType != null) {
            System.out.println(loadType);
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
