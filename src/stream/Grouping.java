package stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grouping {

    public static void main(String[] args) {

        Function<? super String, Integer> classifier = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Collector<? super String, ? extends Object, Map<Integer, List<String>>> collector = Collectors.groupingBy(classifier);
        var collection = Stream.of("1", "2", "10", "100").collect(collector);
        System.out.println(collection.get(1));
        Stream.of("1", "2", "10", "100").collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));



        Collector<? super String, ?, ?> smth = new Collector<String, Object, Object>() {
            @Override
            public Supplier<Object> supplier() {
                return null;
            }

            @Override
            public BiConsumer<Object, String> accumulator() {
                return null;
            }

            @Override
            public BinaryOperator<Object> combiner() {
                return null;
            }

            @Override
            public Function<Object, Object> finisher() {
                return null;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return null;
            }
        };
        Collectors.groupingBy(String::length, TreeMap::new, smth);
    }
}
