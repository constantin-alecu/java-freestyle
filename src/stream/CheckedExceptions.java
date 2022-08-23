package stream;

import java.io.IOException;
import java.util.stream.Stream;

public class CheckedExceptions {
    public static void main(String[] args) throws IOException{
//        Stream.of("1", "2").map(Animal::create).count();// unhandled exception even main method throws
        Stream.of("1", "2").map(Animal::createSafe).count();
    }
}

class Animal{
    public static Animal create(String s) throws IOException {
        throw new IOException();
    }

    public static Animal createSafe(String s) {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
