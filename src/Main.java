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
                new DriverCategoryB("Некифоров Павел Антонович", true, 4));

        printDriverAndCar(lada);

        PassengerCar audi = new PassengerCar("Audi", "A8 50 L TDI quattro", 3.0,
                new DriverCategoryB("Дементьев Николай Сергеевич", true, 3));

        printDriverAndCar(audi);

        PassengerCar bmw = new PassengerCar("BMW", "Z8", 3.0,
                new DriverCategoryB("Романов Дмитрий Николаевич", true, 7));

        printDriverAndCar(bmw);

        PassengerCar kia = new PassengerCar("Kia", "Sportage 4-го поколения", 2.4,
                new DriverCategoryB("Андреев Леонид Андреевич", true, 6));

        printDriverAndCar(kia);

        // Грузовые автомобили

        FreightCar kamAZ = new FreightCar("КамАЗ", "5320", 10.8,
                new DriverCategoryC("Головков Максим Александрович", true, -8));

        printDriverAndCar(kamAZ);

        FreightCar gaz = new FreightCar("ГАЗ", "53", 3.5,
                new DriverCategoryC("Тукмачёв Сергей Эдуардович", true, 4));

        printDriverAndCar(gaz);

        FreightCar zil = new FreightCar("ЗиЛ", "130", 5.6,
                new DriverCategoryC("Максимов Егор Андреевич", true, 7));

        printDriverAndCar(zil);

        FreightCar ural = new FreightCar("Урал", "4230", 14.9,
                new DriverCategoryC("Комаров Руслан Александрович", true, 9));

        printDriverAndCar(ural);

        // Автобусы

        Bus maz = new Bus("МАЗ", "203", 6.3,
                new DriverCategoryD("Рештников Антон Павлович", true, 5));

        printDriverAndCar(maz);

        Bus lotos = new Bus("Lotos", "206", 5.3,
                new DriverCategoryD("Кузьмин Олег Владимирович", true, 10));

        printDriverAndCar(lotos);

        Bus marz = new Bus("МАРЗ", "5277", 11.1,
                new DriverCategoryD("Сергеев Павел Евгеньевич", true, 8));

        printDriverAndCar(marz);

        Bus nefaz = new Bus("НЕФАЗ", "5299", 6.7,
                new DriverCategoryD("Суслопаров Алексей Юрьевич", true, -11));

        printDriverAndCar(nefaz);
    }

    public static void printDriverAndCar(Transport<?> transport) {
        System.out.println("Водитель " + transport.getDriver().getFullName() + " управляет " +
                transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
    }
}
