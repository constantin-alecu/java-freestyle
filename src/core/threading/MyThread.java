package core.threading;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("first thread"));
        t.start();

        Thread arrayT[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            arrayT[i] = new Thread(() -> {
                System.out.println("i=" + finalI);
            });
        }

        for (int i = 0; i < 10; i++) {
            arrayT[i].start();
        }
    }

    public Thread print = new Thread(() -> System.out.println("print"));
    public Thread iterateAndPrint = new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            System.out.println(" printing iteration " + i);
        }
    });
    public Callable<String> callableString = new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(100);
            return "callable string";
        }
    };

    public Callable<String> callableStringRandom = new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(100);
            return new Random().nextInt() + "callable string";
        }
    };
}
