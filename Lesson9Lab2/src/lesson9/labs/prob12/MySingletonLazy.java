package lesson9.labs.prob12;

import java.util.Optional;

public class MySingletonLazy {

    private static int count = 0;
    private static MySingletonLazy instance = null;
    private MySingletonLazy() {
        count++;
    }
    //Uses ofNullable in place of null checks
    public static MySingletonLazy getInstance() {
        //return Optional.ofNullable(instance).orElseGet(() -> updateInstance());
        return Optional.ofNullable(instance).orElseGet(MySingletonLazy::updateInstance);
    }

    private static MySingletonLazy updateInstance() {
        instance = new MySingletonLazy();
        return instance;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; ++i) {
            getInstance();
        }
        System.out.println(count);
    }
}
