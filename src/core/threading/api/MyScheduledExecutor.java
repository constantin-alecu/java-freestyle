package core.threading.api;

import core.threading.MyThread;

import java.util.concurrent.*;

public class MyScheduledExecutor {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(myThread.iterateAndPrint, 2, TimeUnit.SECONDS);

        ScheduledFuture<String> value = service.schedule(myThread.callableString, 2, TimeUnit.SECONDS);
        System.out.println(value.isCancelled());
        System.out.println(value.isDone());
        value.cancel(true);
        System.out.println(value.isCancelled());
        try {
            System.out.println(value.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e){
            e.printStackTrace();
        }

        service.shutdown();
    }
}
