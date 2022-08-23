package core.threading.safe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FarmerSynchronized {

    private int sheeps = 0;

    private synchronized void incrementSheepCounterAndReport(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        synchronized (this) {
            System.out.println(++sheeps + " ");
//        }
    }

    public static void main(String[] args) {

        FarmerSynchronized farmer = new FarmerSynchronized();
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
        System.out.println("farmer.sheeps = " + farmer.sheeps);

    }
}
