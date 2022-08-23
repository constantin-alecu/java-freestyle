package core.functional.builtin;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Builtin {
    public static void main(String[] args) {

        Supplier<LocalDate> localDateSupplier = LocalDate::now; // () -> LocalDate.now();
        localDateSupplier.get();

        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("smth");

        BiConsumer<String, Integer> stringBiConsumer = String::format;
       /* var x =*/ stringBiConsumer.accept("aaa %s ", 10);
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> mapConsumer = map::put;

        Predicate<String> stringPredicate = a-> a.startsWith("aaa"); /*String::startsWith("aaa"); not working*/
        BiPredicate<String, String> biPredicate = String::startsWith;//(a, b) -> a.startsWith(b);
        System.out.println(biPredicate.test("Anna is here", "An"));

        Function<Integer, String> intToString = Integer::toHexString;
        System.out.println(intToString.apply(109));
    }
}


