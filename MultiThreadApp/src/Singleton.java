public class Singleton {

    private static Singleton singleton;

    public static void setCounter(int counter) {
        Singleton.counter = counter;
    }

    public static int getCounter() {
        return counter;
    }

    private static int counter;
    private Singleton() {
        counter++;
    }
    public synchronized static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();//counter increments
        }
        return singleton;
    }
}
