package core.threading;

public class Counter {

    static int counter = 0;

    public static void main(String[] args) {
        Thread arrayT[] = new Thread[100];
        for (int i = 0; i < 100; i++) {
            arrayT[i] = new Thread(() -> {
                System.out.println("i=" + counter++);
            });
        }

        for (int i = 0; i < 100; i++) {
            arrayT[i].start();
        }

        System.out.println("counter = " + counter);
    }
}
