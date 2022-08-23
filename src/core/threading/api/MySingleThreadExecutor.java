package core.threading.api;

import core.threading.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySingleThreadExecutor {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            service.execute(() -> {
                System.out.println("print from executor thread");
            });
            System.out.println("start");
            service.execute(myThread.print);
            service.execute(myThread.iterateAndPrint);
            service.execute(myThread.print);
            System.out.println("end");
        } finally {
            service.shutdown();// not calling it will make application run endlessly (executor service is not a daemon)
                               // will continue to run previously submitted tasks
                                //will reject any newly submitted tasks -> RejectedExecutionException
            System.out.println(service.isShutdown()); // true
            System.out.println(service.isTerminated()); // false if threads still running
            while(!service.isTerminated()){
                System.out.println("not terminated yet");
            }
        }
    }
}
