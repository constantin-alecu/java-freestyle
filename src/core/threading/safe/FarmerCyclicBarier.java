package core.threading.safe;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FarmerCyclicBarier {

    private void removeLions(){
        System.out.println("removing lions");
    }
    private void cleanCage(){
        System.out.println("cleaning cage");
    }
    private void addLions(){
        System.out.println("add lions back to the cage");
    }

    private void performTask(CyclicBarrier c1, CyclicBarrier c2){
        try {
            removeLions();
            c1.await();
            cleanCage();
            c2.await();
            addLions();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FarmerCyclicBarier farmer = new FarmerCyclicBarier();
        ExecutorService service = Executors.newFixedThreadPool(4);
        CyclicBarrier c1 = new CyclicBarrier(4);
        CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("****FINISHED CLEANING****"));

        for (int i = 0; i < 4; i++) {
            service.submit(() -> farmer.performTask(c1, c2));
        }
        service.shutdown();
    }
}
