package stream;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Filter {

    public static void main(String[] args) {
        Predicate<? super String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("1");
            }
        };
        Stream.of("123","fg", "34g").filter(predicate);
        Stream.of("123","fg", "34g").filter(s-> s.endsWith("g"));

        Stream.of("123","fg", "34g").distinct().count();

        Integer seed = 0;
        UnaryOperator<Integer> operation = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 2;
            }
        };
        Stream.<Integer>iterate(seed, operation).skip(10).limit(10).forEach(System.out::println);
        Stream.<Integer>iterate(0, n -> n + 2).skip(10).limit(10).forEach(System.out::println);

    }
}
