package core.polymorphism.override.subclass;

import core.polymorphism.override.Animal;

public class Wolf extends Animal {

    public int x = 10;
    /*private void eat(){ // weaker priviledges not allowed
        System.out.println("Wolf eat");
    }*/

    //    static public void eat(){ //either both static or non-static
//        System.out.println("Animal eat");
//    }
    protected String protec = "wolfProtected";
    @Override
    public void eat(){ // weaker priviledges not allowed
        System.out.println("Wolf eat");
    }

    public static void main(String[] args) {
        Animal animal = new Wolf();
        ((Wolf)animal).eat(); // print Wolf
        System.out.println(animal.x); // print 0
        System.out.println(((Wolf)animal).x); // print 10
//        System.out.println(animal.protec); // complilation error different packages
        System.out.println(((Wolf) animal).protec); // print wolfProtected
//        ((Wolf)animal).defaul_t.length(); // compilation error


        Wolf wolf = new Wolf();
        wolf.eat();// print Wolf
//        ((Animal)wolf).eat();// complilation error
        System.out.println(wolf.x); // print 10
        System.out.println(((Animal)wolf).x); // print 0
    }
}
