package core.threading.safe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FarmerLock {

    private int sheeps = 0;
    private Lock lock = new ReentrantLock();

    private void incrementSheepCounterAndReport(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        System.out.println(++sheeps + " ");
        lock.unlock();
    }

    public static void main(String[] args) {

        FarmerLock farmer = new FarmerLock();
        farmer.lock.lock();
        farmer.lock.lock();
        farmer.lock.unlock();

        ExecutorService service = Executors.newFixedThreadPool(20);
        try{
            for (int i = 0; i <= 100; i++) {
                service.execute(farmer::incrementSheepCounterAndReport);
            }
        }finally {
            service.shutdown();
        }
        System.out.println("unlocking so counting should start");
        farmer.lock.unlock();

        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("farmer.sheeps = " + farmer.sheeps);
    }
}
