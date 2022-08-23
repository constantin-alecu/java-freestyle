package stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Match {

    public static void main(String[] args) {
        Predicate<? super String> startWith7 = x -> x.startsWith("7");
        System.out.println(Stream.of("71","71","61","51","41","31","21").anyMatch(startWith7));
        Predicate<? super String> endWith1 = a -> a.endsWith("1");
        System.out.println(Stream.of("71","71","61","51","41","31","21").allMatch(endWith1));
        System.out.println(Stream.of("71","71","61","51","41","31","21").noneMatch(endWith1));
    }
}
