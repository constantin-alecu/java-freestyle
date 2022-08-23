package stream.boxed;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Boxed {

    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(1,2,3,4);
//        s.boxed();
        Stream.of(1,23,4).map(x -> x.intValue()).peek(System.out::println).forEach(System.out::println); //1,2,23,23,4,4
        IntStream is = IntStream.of(1,2,3,4);
        is.boxed().forEach(System.out::println);
        DoubleStream ds = IntStream.of(1,2,3,4).mapToDouble(x -> x + 0.9);
        ds.mapToInt(x->(int)x).forEach(System.out::println);
    }
}
