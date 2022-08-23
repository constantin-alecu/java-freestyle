package core.threading;

public class Interrupted {

    static int counter = 0;

    public static void main(String[] args) {

        var mainThread = Thread.currentThread();
        Thread t = new Thread(() -> {
            for (int i = 0; i < 1_000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
            mainThread.interrupt();
        });
        t.start();
        while(counter < 1_000){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                break;
            }
            System.out.println("Not reached yet ");
        }
        System.out.println("Reached counter =" + counter);
    }
}
