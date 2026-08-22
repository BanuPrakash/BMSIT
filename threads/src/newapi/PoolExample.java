package newapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PoolExample {
    public static void main(String[] args) throws  Exception{
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Integer> f1 = service.submit(new Counter(1, 100));
        Future<Integer> f2 = service.submit(new Counter(100, 200));
        Future<Integer> f3 = service.submit(new Counter(300, 400));
        Future<Integer> f4 = service.submit(new Counter(1000, 1200));

        System.out.println(f1.get()); // blocking
        System.out.println(f2.get()); // blocking
        System.out.println(f3.get()); // blocking
        System.out.println(f4.get()); // blocking

        service.shutdown();
    }
}
