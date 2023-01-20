package transport;

public class Mechanic {
    private final String fullName;
    private String company;

    public Mechanic(String fullName, String company) {
        if (fullName == null || fullName.isBlank()) {
            this.fullName = "Ф. И. О. механика не указано";
        } else {
            this.fullName = fullName;
        }

        setCompany(company);
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final void setCompany(String company) {
        if (company == null || company.isBlank()) {
            this.company = "Компания не указана";
        } else {
            this.company = company;
        }
    }

    public final String getCompany() {
        return this.company;
    }

    public final void carryOutMaintenance() {
        System.out.println("Механик " + getFullName() + " проводит техобслуживание машины");
    }

    public final void fixTheCar() {
        System.out.println("Механик " + getFullName() + " чинит машину");
    }

    @Override
    public String toString() {
        return "Ф. И. О. механика - " + this.fullName + "; Компания, в которой работает - " + this.company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() == o.getClass()) {
            return false;
        }
        Mechanic mechanic = (Mechanic) o;
        return this.fullName.equals(mechanic.fullName) && this.company.equals(mechanic.company);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fullName, company);
    }
}