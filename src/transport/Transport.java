package transport;

import drivers.Driver;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport <T extends Driver> implements Competing {
    private final String brand;
    private final String model;
    private double engineVolume;
    private T driver;

    private final List<Mechanic<?>> listOfAllMechanics = new ArrayList<>();

    public Transport(String brand, String model, double engineVolume, T driver) {
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

        setEngineVolume(engineVolume);

        this.driver = driver;

        try {
            checkDriverLicense();
        } catch (DriverLicenseNotSpecifiedException e) {
            System.out.println("У водителя " + this.driver.getFullName() + " " + e.getMessage());
        }
    }

    public final String getBrand() {
        return brand;
    }

    public final String getModel() {
        return model;
    }

    public final void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public final double getEngineVolume () {
        return this.engineVolume;
    }

    public final void setDriver(T driver) {
        this.driver = driver;
    }

    public final T getDriver() {
        return this.driver;
    }

    public final void addMechanic(Mechanic<?> mechanic) {
        this.listOfAllMechanics.add(mechanic);
    }

    public final List<Mechanic<?>> getListOfAllMechanics() {
        return this.listOfAllMechanics;
    }

    public abstract void startMoving();

    public abstract void finishMoving();

    public abstract void printType();

    protected void checkDriverLicense() throws DriverLicenseNotSpecifiedException {
        if (!this.getDriver().isHavingADriversLicense()) {
            throw new DriverLicenseNotSpecifiedException("необходимо указать наличие прав!");
        }
    }

    public void passDiagnostics() {

    }

    @Override
    public String toString() {
        return "Марка - " + brand + "; Модель - " + model + "; Объем двигателя - " + engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Transport<?> transport = (Transport<?>) o;
        return this.brand.equals(transport.brand) && this.model.equals(transport.model);
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(brand, model);
    }
}