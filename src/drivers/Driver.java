package drivers;

public abstract class Driver {
    private final String fullName;
    private final boolean havingADriversLicense;
    private int experience;

    public Driver (String fullName, boolean havingADriversLicense, int experience) {
        if (fullName == null || fullName.isBlank()) {
            this.fullName = "Ф. И. О. водителя не указано";
        } else {
            this.fullName = fullName;
        }

        this.havingADriversLicense = havingADriversLicense;

        setExperience(experience);
    }

    public String getFullName() {
        return this.fullName;
    }

    public boolean isHavingADriversLicense() {
        return this.havingADriversLicense;
    }

    public void setExperience(int experience) {
        if (experience < 0) {
            this.experience = Math.abs(experience);
        } else {
            this.experience = experience;
        }
    }

    public int getExperience() {
        return this.experience;
    }

    public abstract void startMoving();

    public abstract void stay();

    public abstract void refuelTheCar();

    @Override
    public String toString() {
        return "Ф. И. О. - " + this.fullName + "; Водительские права - " + (havingADriversLicense ? "есть" : "нет") +
                "; Стаж - " + this.experience + " года";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() == o.getClass()) {
            return false;
        }
        Driver driver = (Driver) o;
        return this.fullName.equals(driver.fullName) && this.havingADriversLicense == driver.havingADriversLicense &&
                this.experience == driver.experience;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fullName, havingADriversLicense, experience);
    }
}
