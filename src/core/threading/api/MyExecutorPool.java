package core.threading.api;

import java.util.concurrent.Executors;

public class MyExecutorPool {

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(10);
        Executors.newScheduledThreadPool(10);
    }
}
