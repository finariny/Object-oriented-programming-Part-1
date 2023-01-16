package drivers;

public class DriverCategoryC extends Driver{
    public DriverCategoryC (String fullName, boolean havingADriversLicense, int experience) {
        super(fullName, havingADriversLicense, experience);
    }

    @Override
    public void startMoving() {
        System.out.println("Водитель категории C " + getFullName() + " начинает движение");
    }

    @Override
    public void stay() {
        System.out.println("Водитель категории C " + getFullName() + " останавливается");
    }

    @Override
    public void refuelTheCar() {
        System.out.println("Водитель категории C " + getFullName() + " заправляет авто");
    }
}
