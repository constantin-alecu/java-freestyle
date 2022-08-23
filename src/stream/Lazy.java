package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lazy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Stream s = list.stream();
        list.add("3");
        System.out.println(s.count());//3
    }
}
