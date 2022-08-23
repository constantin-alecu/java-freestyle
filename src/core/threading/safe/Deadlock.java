package core.threading.safe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    private static final Lock eatingCage = new ReentrantLock();
    private static final Lock drinkingCage = new ReentrantLock();

    private static void firstCatEatsThenDrinks(){
        eatingCage.lock();
        System.out.println("First cat eating");
        drinkingCage.lock();
        System.out.println("First cat drinking");
        drinkingCage.unlock();
        eatingCage.unlock();
        System.out.println("First cat finished");
    }
    private static void secondCatDrinksThenEats(){
        drinkingCage.lock();
        System.out.println("Second cat drinking");
        eatingCage.lock();
        System.out.println("Second cat eating");
        eatingCage.unlock();
        drinkingCage.unlock();
        System.out.println("Second cat finished");
    }
    public static void main(String[] notUsed) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(Deadlock::firstCatEatsThenDrinks);
        service.execute(Deadlock::secondCatDrinksThenEats);
        service.shutdown();
    }
}
