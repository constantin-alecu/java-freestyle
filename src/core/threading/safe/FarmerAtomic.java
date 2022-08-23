package core.threading.safe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FarmerAtomic {

    private AtomicInteger atomicSheeps = new AtomicInteger(0);

    private void incrementSheepCounterAndReport(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicSheeps.incrementAndGet());
    }

    public static void main(String[] args) {

        FarmerAtomic farmer = new FarmerAtomic();
        ExecutorService service = Executors.newFixedThreadPool(20);
        try{
            for (int i = 0; i <= 100; i++) {
                service.execute(farmer::incrementSheepCounterAndReport);
            }
        }finally {
            service.shutdown();
        }
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("farmer.atomicSheeps = " + farmer.atomicSheeps.get());
    }
}
