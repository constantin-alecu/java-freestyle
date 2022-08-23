package core.abstracts;

public interface AnimalInterface {

    void eat();
    private void sleep(){
        System.out.println("Animal Sleeping");
    }
    private static void stay(){
        System.out.println("Animal Staying");
    }
    public static void wakeUp(){
        System.out.println("Animal Waking up");

    }
    default void live(){ // may be overriden
        eat();
        sleep();
        wakeUp();
        stay();
    }
}

class WolfClass implements AnimalInterface{

    @Override
    public void eat() {
        System.out.println("Wolf eating");
    }

    public static void main(String[] args) {
        AnimalInterface animal = new WolfClass();
        animal.live();
        ((WolfClass)animal).live();
        WolfClass wolf = new WolfClass();
        ((AnimalInterface)wolf).live();

        System.out.println("------------");
        AnimalInterface animal2 = new Dog();
        animal2.live();
        ((WolfClass)animal2).live();
        Dog dog = new Dog();
        ((WolfClass)dog).live();
    }
}

class Dog extends WolfClass{

    @Override
    public void eat() {
        System.out.println("Dog eating");
    }

    @Override
    public void live() {
        System.out.println("Dog Living");
    }
}
