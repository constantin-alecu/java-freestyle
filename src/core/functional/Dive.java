package core.functional;

import java.util.function.Consumer;

@FunctionalInterface
public interface Dive {

    void dive();
    String toString();
    abstract int hashCode();
    boolean equals(Object o);
}

@FunctionalInterface
interface Drown {
    void drown(String drowning);
}

interface StringChecker{
    boolean check();
}
//@FunctionalInterface - not working
interface StringChecker2{
    boolean check();
    boolean check2();
}

class Main{
    public static void main(String[] args) {
        dive(() -> System.out.println("functional parameter diving"));
        Dive dive = () -> System.out.println("main diving");
        dive.dive();
        Consumer<Dive> dive1 = Dive::dive;
        dive1.accept(dive);

        String str = "3";
        StringChecker methodReference = str::isEmpty;
        System.out.println(methodReference.check());

        StringChecker lambda = () -> str.isEmpty();
        System.out.println(lambda.check());

        Dive dive2 = System.out::println;
        dive2.dive();

        Drown drown = System.out::println;
        drown.drown("aaaaa drown");
    }

    private static void dive(Dive dive){
        dive.dive();
    }
}
