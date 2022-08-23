package stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Mapper {

    public static void main(String[] args) {

        Function<? super Integer, ?> maper = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString() + "!";
            }
        };
        Stream.iterate(0, n -> n + 1).skip(10).limit(2).map(maper).forEach(System.out::println);

        Stream.of("123","fg", "34g").map(s -> s.replaceAll("g", "xxx")).forEach(System.out::println);

        List<List<String>> list = new ArrayList<>();
        list.add(List.of("asd", "dfg"));
        list.add(List.of("123", "456"));

        Function<? super List<String>, ? extends Stream<?>> maper2 = new Function<List<String>, Stream<?>>() {
            @Override
            public Stream<?> apply(List<String> strings) {
                return strings.stream();
            }
        };
        list.stream().flatMap(maper2).forEach(System.out::println);
        list.stream().flatMap(Collection::stream).forEach(System.out::println);
        list.stream().flatMap(a -> a.stream()).forEach(System.out::println);

        Stream.of("a", "b", "c", "A").mapToDouble(s -> s.length()).forEach(System.out::print);

    }
}
