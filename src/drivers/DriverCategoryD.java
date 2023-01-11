package drivers;

public class DriverCategoryD extends Driver {
    public DriverCategoryD (String fullName, boolean havingADriversLicense, int experience) {
        super(fullName, havingADriversLicense, experience);
    }

    @Override
    public void startMoving() {
        System.out.println("Водитель категории D " + getFullName() + " начинает движение");
    }

    @Override
    public void stay() {
        System.out.println("Водитель категории D " + getFullName() + " останавливается");
    }

    @Override
    public void refuelTheCar() {
        System.out.println("Водитель категории D " + getFullName() + " заправляет авто");
    }
}
