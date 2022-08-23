package stream;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Peek {

    public static void main(String[] args) {
        Consumer<? super String> actionConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };
        Stream.of("123","fg", "34g").peek(actionConsumer).filter(a -> true).count();
        Stream.of(new ArrayList<String>(),new ArrayList<String>()).peek(a -> a.add("xxx")).forEach(s -> System.out.println(s.size())); // still prints 1

    }
}
