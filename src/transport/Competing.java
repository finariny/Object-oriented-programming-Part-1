package transport;

public interface Competing {
    void pitStop();

    void bestLapTime(double time);

    void maximumSpeed(int speed);
}
