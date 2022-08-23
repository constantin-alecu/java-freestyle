package stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Sorting {

    public static void main(String[] args) {
        Stream.of("a", "b", "c", "A").sorted().forEach(System.out::print);
        Stream.of("a", "b", "c", "A").sorted(Comparator.reverseOrder()).forEach(System.out::print);
        Comparator<? super String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Stream.of("a", "b", "c", "A").sorted(comparator).forEach(System.out::print);

    }
}
