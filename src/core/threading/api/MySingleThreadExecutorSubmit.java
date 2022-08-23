package core.threading.api;

import core.threading.MyThread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MySingleThreadExecutorSubmit {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> value = service.submit(myThread.callableString);
        try {
            System.out.println(value.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            var values = service.invokeAll(List.of(myThread.callableString));
            for(var val: values){
                System.out.println(val.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            var valu = service.invokeAny(List.of(myThread.callableStringRandom, myThread.callableString, myThread.callableStringRandom));
            System.out.println(valu);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
