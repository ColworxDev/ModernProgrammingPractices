import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    //static ExecutorService service = Executors.newCachedThreadPool();

    static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            createAndStartThreads();
            System.out.println(Singleton.getCounter());
        }
        service.shutdown();

    }

    private static void createAndStartThreads() {

//        for (int i = 0; i < 5000; i++) {
//            (new Thread(
//                    () -> Singleton.getInstance()
//            )).start();
//        }

        for (int i = 0; i < 5; i++) {
            service.execute(() -> Singleton.getInstance());
            System.out.println("Task# " + ((ThreadPoolExecutor)service).getTaskCount());
            System.out.println("Active# " + ((ThreadPoolExecutor)service).getActiveCount());
        }

    }
}