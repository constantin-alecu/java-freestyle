package core.abstracts;

public abstract class AnimalClass {
//    private abstract void eat(); //private abstract not compatible
//    abstract static void eat(); //static abstract not compatible

    abstract void eat();

    public void live(){
        System.out.print("Living and ");
        eat();
    }
}


class Wolf extends AnimalClass{

    @Override
    void eat() {
        System.out.println("Wolf eating");
    }
}

class Main{
    public static void main(String[] args) {
        AnimalClass animal = new Wolf();
        animal.live();
        ((Wolf)animal).live();
        Wolf wolf = new Wolf();
        ((AnimalClass)wolf).live();
    }
}
