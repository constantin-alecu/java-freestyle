package core.nested.classes.sstatic;

public class Animal {
    static class Wolf{
        private int size = 25;
    }

    public static void main(String[] args) {
        System.out.println(new Wolf().size);
        Animal.Wolf wolf = new Wolf();
        System.out.println(wolf.size);
    }
}
