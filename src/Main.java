import drivers.DriverCategoryB;
import drivers.DriverCategoryC;
import drivers.DriverCategoryD;
import transport.Bus;
import transport.FreightCar;
import transport.PassengerCar;
import transport.Transport;

public class Main {
    public static void main(String[] args) {

        // Легковые автомобили

        PassengerCar lada = new PassengerCar("Lada", "Granta", 1.7,
                new DriverCategoryB("Некифоров Павел Антонович", true, 4), null);

//        printDriverAndCar(lada);
        lada.printType();

        PassengerCar audi = new PassengerCar("Audi", "A8 50 L TDI quattro", 3.0,
                new DriverCategoryB("Дементьев Николай Сергеевич", true, 3), PassengerCar.BodyType.SEDAN);

//        printDriverAndCar(audi);
        audi.printType();

        PassengerCar bmw = new PassengerCar("BMW", "Z8", 3.0,
                new DriverCategoryB("Романов Дмитрий Николаевич", true, 7), PassengerCar.BodyType.COUPE);

//        printDriverAndCar(bmw);
        bmw.printType();

        PassengerCar kia = new PassengerCar("Kia", "Sportage 4-го поколения", 2.4,
                new DriverCategoryB("Андреев Леонид Андреевич", true, 6), PassengerCar.BodyType.SUV);

//        printDriverAndCar(kia);
        kia.printType();

        // Грузовые автомобили

        FreightCar kamAZ = new FreightCar("КамАЗ", "5320", 10.8,
                new DriverCategoryC("Головков Максим Александрович", true, -8), FreightCar.LoadType.N2);

//        printDriverAndCar(kamAZ);
        kamAZ.printType();

        FreightCar gaz = new FreightCar("ГАЗ", "53", 3.5,
                new DriverCategoryC("Тукмачёв Сергей Эдуардович", true, 4), FreightCar.LoadType.N1);

//        printDriverAndCar(gaz);
        gaz.printType();

        FreightCar zil = new FreightCar("ЗиЛ", "130", 5.6,
                new DriverCategoryC("Максимов Егор Андреевич", true, 7), FreightCar.LoadType.N2);

//        printDriverAndCar(zil);
        zil.printType();

        FreightCar ural = new FreightCar("Урал", "4230", 14.9,
                new DriverCategoryC("Комаров Руслан Александрович", true, 9), FreightCar.LoadType.N2);

//        printDriverAndCar(ural);
        ural.printType();

        // Автобусы

        Bus maz = new Bus("МАЗ", "203", 6.3,
                new DriverCategoryD("Рештников Антон Павлович", true, 5), Bus.CapacityType.ESPECIALLY_BIG);

//        printDriverAndCar(maz);
        maz.printType();

        Bus lotos = new Bus("Lotos", "206", 5.3,
                new DriverCategoryD("Кузьмин Олег Владимирович", true, 10), Bus.CapacityType.BIG);

//        printDriverAndCar(lotos);
        lotos.printType();

        Bus marz = new Bus("МАРЗ", "5277", 11.1,
                new DriverCategoryD("Сергеев Павел Евгеньевич", true, 8), Bus.CapacityType.ESPECIALLY_BIG);

//        printDriverAndCar(marz);
        marz.printType();

        Bus nefaz = new Bus("НЕФАЗ", "5299", 6.7,
                new DriverCategoryD("Суслопаров Алексей Юрьевич", true, -11), Bus.CapacityType.AVERAGE);

//        printDriverAndCar(nefaz);
        nefaz.printType();
    }

    public static void printDriverAndCar(Transport<?> transport) {
        System.out.println("Водитель " + transport.getDriver().getFullName() + " управляет " +
                transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
    }
}
