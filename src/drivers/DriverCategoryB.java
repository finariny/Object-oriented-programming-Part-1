package drivers;

public class DriverCategoryB extends Driver{
    public DriverCategoryB (String fullName, boolean havingADriversLicense, int experience) {
        super(fullName, havingADriversLicense, experience);
    }

    @Override
    public void startMoving() {
        System.out.println("Водитель категории B " + getFullName() + " начинает движение");
    }

    @Override
    public void stay() {
        System.out.println("Водитель категории B " + getFullName() + " останавливается");
    }

    @Override
    public void refuelTheCar() {
        System.out.println("Водитель категории B " + getFullName() + " заправляет авто");
    }
}
