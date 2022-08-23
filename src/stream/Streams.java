package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * don't do side effects in intermediate operations
 */
public class Streams {

    public static void main(String[] args) {
        var listOf = List.of("one", "two", "three"/*, null*/);

        var count = listOf.stream()
                .peek(System.out::println) // not called. usually just for debug
                .count();

        System.out.println("count = " + count);

        var list = new ArrayList<String>();

        var count2 = listOf.stream()
                .map(s -> { // not called -> not needed in the process of calculating the final result (stream is sized).
                    list.add(s);
                    return s.toUpperCase(Locale.ROOT);
                })
                .count();

        System.out.println("count2 = " + count2);
        System.out.println("list.size() = " + list.size());

        var count3 = listOf.stream()
                .filter(s -> true)
                .map(s -> { // called -> (stream is not sized).
                    list.add(s);
                    return s.toUpperCase(Locale.ROOT);
                })
                .count();

        System.out.println("count3 = " + count2);
        System.out.println("list.size() = " + list.size());

        String ints = """
                1
                2
                3
                4
                5
                """;

        var toList = ints
                .lines()
                .map(Integer::parseInt)
//                .map(i -> null)  // is working
                .toList(); // [optimized] creates an array on the right size //immutable

//        toList.add(10);
        System.out.println("toList = " + toList);

        String ints2 = """
                1
                2
                3
                4
                # NumberFormatException
                5
                """;
        var toList2 = ints
                .lines()
                .flatMap(s -> {
                    try {
                        return Stream.of(Integer.parseInt(s));
                    }catch (NumberFormatException e){
                        return Stream.of();
                    }
                })
                .toList();

        System.out.println("toList2 = " + toList2);

        List<Integer> toList3 = ints
                .lines()
                .<Integer>mapMulti((s, stream) -> {
                    try {
                        stream.accept(Integer.parseInt(s));
                    }catch (NumberFormatException ignored){
                    }
                })
                .toList();

        System.out.println("toList3 = " + toList3);

        int i = 0;
//        toList3.removeIf(a -> a.equals(i++)); // i must be effectively final
    }
}
