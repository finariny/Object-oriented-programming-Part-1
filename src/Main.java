import drivers.DriverCategoryB;
import drivers.DriverCategoryC;
import drivers.DriverCategoryD;
import transport.*;
import drivers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Transport<?>> listOfAllCars = new ArrayList<>();
    public static List<Driver> listOfAllDrivers = new ArrayList<>();

    public static Map<Transport<?>, Mechanic<?>> transportAndMechanic = new HashMap<>();

    public static void main(String[] args) {

        // Легковые автомобили

        PassengerCar lada = new PassengerCar("Lada", "Granta", 1.7,
                new DriverCategoryB("Некифоров Павел Антонович", false, 4), null);

        listOfAllCars.add(lada);
        listOfAllDrivers.add(lada.getDriver());

        PassengerCar audi = new PassengerCar("Audi", "A8 50 L TDI quattro", 3.0,
                new DriverCategoryB("Дементьев Николай Сергеевич", true, 3), PassengerCar.BodyType.SEDAN);

        listOfAllCars.add(audi);
        listOfAllDrivers.add(audi.getDriver());

        PassengerCar bmw = new PassengerCar("BMW", "Z8", 3.0,
                new DriverCategoryB("Романов Дмитрий Николаевич", true, 7), PassengerCar.BodyType.COUPE);

        listOfAllCars.add(bmw);
        listOfAllDrivers.add(bmw.getDriver());

        PassengerCar kia = new PassengerCar("Kia", "Sportage 4-го поколения", 2.4,
                new DriverCategoryB("Андреев Леонид Андреевич", true, 6), PassengerCar.BodyType.SUV);

        listOfAllCars.add(kia);
        listOfAllDrivers.add(kia.getDriver());

        // Грузовые автомобили

        FreightCar kamAZ = new FreightCar("КамАЗ", "5320", 10.8,
                new DriverCategoryC("Головков Максим Александрович", false, -8), FreightCar.LoadType.N2);

        listOfAllCars.add(kamAZ);
        listOfAllDrivers.add(kamAZ.getDriver());

        FreightCar gaz = new FreightCar("ГАЗ", "53", 3.5,
                new DriverCategoryC("Тукмачёв Сергей Эдуардович", true, 4), FreightCar.LoadType.N1);

        listOfAllCars.add(gaz);
        listOfAllDrivers.add(gaz.getDriver());

        FreightCar zil = new FreightCar("ЗиЛ", "130", 5.6,
                new DriverCategoryC("Максимов Егор Андреевич", true, 7), FreightCar.LoadType.N2);

        listOfAllCars.add(zil);
        listOfAllDrivers.add(zil.getDriver());

        FreightCar ural = new FreightCar("Урал", "4230", 14.9,
                new DriverCategoryC("Комаров Руслан Александрович", true, 9), FreightCar.LoadType.N2);

        listOfAllCars.add(ural);
        listOfAllDrivers.add(ural.getDriver());

        // Автобусы

        Bus maz = new Bus("МАЗ", "203", 6.3,
                new DriverCategoryD("Рештников Антон Павлович", false, 5), Bus.CapacityType.ESPECIALLY_BIG);

        listOfAllCars.add(maz);
        listOfAllDrivers.add(maz.getDriver());

        Bus lotos = new Bus("Lotos", "206", 5.3,
                new DriverCategoryD("Кузьмин Олег Владимирович", true, 10), Bus.CapacityType.BIG);

        listOfAllCars.add(lotos);
        listOfAllDrivers.add(lotos.getDriver());

        Bus marz = new Bus("МАРЗ", "5277", 11.1,
                new DriverCategoryD("Сергеев Павел Евгеньевич", true, 8), Bus.CapacityType.ESPECIALLY_BIG);

        listOfAllCars.add(marz);
        listOfAllDrivers.add(marz.getDriver());

        Bus nefaz = new Bus("НЕФАЗ", "5299", 6.7,
                new DriverCategoryD("Суслопаров Алексей Юрьевич", true, -11), Bus.CapacityType.AVERAGE);

        listOfAllCars.add(nefaz);
        listOfAllDrivers.add(nefaz.getDriver());

        Mechanic<Transport<?>> mechanic1 = new Mechanic<>("Нестеров Владимир Игнатьевич", "");
        Mechanic<PassengerCar> mechanic2 = new Mechanic<>("Сапожников Антон Валерьевич", "Механик");
        Mechanic<FreightCar> mechanic3 = new Mechanic<>("Стародубов Николай Александрович", "");

        lada.addMechanic(mechanic1);
        lada.addMechanic(mechanic1);
        lada.addMechanic(mechanic2);
        System.out.println(lada.getListOfAllMechanics());

        transportAndMechanic.put(kia, mechanic2);
        transportAndMechanic.put(kamAZ, mechanic3);
        transportAndMechanic.put(lotos, mechanic1);
        for(Map.Entry<Transport<?>, Mechanic<?>> transport: transportAndMechanic.entrySet()) {
            System.out.println("Машина: " + transport.getKey().getBrand() + " " + transport.getKey().getModel() +
                    "; Механик: " + transport.getValue().getFullName());
        }
    }


    public static void printDriverAndCar(Transport<?> transport) {
        System.out.println("Водитель " + transport.getDriver().getFullName() + " управляет " +
                transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
    }

    public static void printDriverAndMechanicOfTheCar(Transport<?> transport) {
        if (transport.getListOfAllMechanics().isEmpty()) {
            throw new NullPointerException("Необходимо добавить механика!");
        } else {
            System.out.println("Машина - " + transport.getBrand() + " " + transport.getModel() + "; Ф. И. О. водителя - " +
                    transport.getDriver().getFullName() + "; Список механиков машины - " + transport.getListOfAllMechanics());
        }
    }
}
