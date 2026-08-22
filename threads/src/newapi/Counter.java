package newapi;

import java.util.concurrent.Callable;

// public class FlightService implements Callable<List<Flight>> {
// public class HotelService implements Callable<List<Hotel>> {

public class Counter implements Callable<Integer> {
    private int start;
    private  int end;

    public Counter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " executing!!!");
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum+= i;
        }
        return sum;
    }
}
