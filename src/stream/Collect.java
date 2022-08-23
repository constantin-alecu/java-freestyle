package stream;

import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collect {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("123","fg", "34g");
        Supplier<StringBuilder> sbSupplier = new Supplier<StringBuilder>() {
            @Override
            public StringBuilder get() {
                return new StringBuilder();
            }
        };
//        StringBuilder sb = s.collect(sbSupplier, (a,b) -> a.append(b), (a,b) -> a.append(b));
        StringBuilder sb = s.collect(() -> new StringBuilder(), (a,b) -> a.append(b), (a,b) -> a.append(b));
        System.out.println(sb.toString());

        s = Stream.of("123","fg", "34g");
        TreeSet<String> t = s.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);

        Stream.of("123","fg", "34g").collect(Collectors.toCollection(TreeSet::new));

        System.out.println(Stream.iterate(1, x-> ++x).limit(5).map(i -> i + "").collect(Collectors.joining("?")));

        Stream.of(1,2,3,4).collect(Collectors.partitioningBy(x -> x % 2 ==0));
        Predicate<? super Object> letssee = new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                if(o instanceof Integer){
                    return ((Integer) o).intValue() % 2 == 0;
                }
                return false;
            }
        };
//        IntStream.of(1,2,3,4).collect(Collectors.partitioningBy(letssee));
    }
}
