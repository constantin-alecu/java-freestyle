package core.threading;

public class Deamon {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("starting thread");
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            System.out.println("ending thread");
        });
        t.setDaemon(true);
        t.start();
        System.out.println("end main");

    }
}
