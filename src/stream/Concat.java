package stream;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concat {

    public static void main(String[] args) {
        Set<String> set = Set.of("1", "2");
        Set<CharSequence> set1 = Set.of("3","4");
        Stream.<CharSequence>concat(set.stream(), set1.stream()).collect(Collectors.toSet());
//        Stream.<String>concat(set.stream(), set1.stream()).collect(Collectors.toSet());
        System.out.println(Stream.of(set, set1).count());
        Stream.of(set, set1).forEach(System.out::println);
        Function<? super Set<? extends CharSequence>, ? extends Stream<?>> mapper = new Function<Set<? extends CharSequence>, Stream<?>>() {
            @Override
            public Stream<?> apply(Set<? extends CharSequence> charSequences) {
                return charSequences.stream();
            }
        };
        Stream.of(set, set1).flatMap(mapper).forEach(System.out::println);
        Stream.of(set, set1).flatMap((Set a)-> a.stream()).forEach(System.out::println);
    }
}
