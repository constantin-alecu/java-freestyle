package core.collections.generics;

import core.polymorphism.override.Animal;
import core.polymorphism.override.subclass.Wolf;


public class Cage<T> {

    private T animal;

    public void putInCage(T t){
        this.animal = t;
    }

    public T getAnimal(){
        return this.animal;
    }

    public static void main(String[] args) {
        Cage<Wolf> cage = new Cage<>();
        cage.putInCage(new Wolf());
        cage.getAnimal().eat();

        Cage<Animal> cageGeneric = new Cage<>();
        cageGeneric.putInCage(new Wolf());
        ((Wolf)cageGeneric.getAnimal()).eat();

        Cage<?> c1 = new Cage<>();
        Cage<?> c2 = new Cage<Animal>();
        Cage<? extends A> c3 = new Cage<A>();
//        Cage<? extends A> c4 = new Cage<Animal>();
        Cage<? extends A> c5 = new Cage<B>();
        Cage<? extends A> c6 = new Cage<C>();
//        upperBound(new Animal());
        upperBound(new B());
        upperBound(new A());
        upperBound(new C());
//        Cage<? super B> c7 = new Cage<C>();
        Cage<? super B> c8 = new Cage<B>();
        Cage<? super B> c9 = new Cage<A>();

        Cage caget = new Cage();
        caget.putInCage(new String("smth"));
//        String smth = caget.getAnimal(); // cast (String)object
        System.out.println(caget.getAnimal());
    }

    static <P extends A> void upperBound(P animal){

    }

    static class A {}
    static class B extends A {}
    static class C extends B {}
//    private void addRandomAnimal(List<T> list){}   // clashes with each other. Type erasure
//    private void addRandomAnimal(List<Wolf> list){}// compiler will replace <xx> with <Object> for backwards compatibility
}
