package core.optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) throws Throwable {
        DoubleSupplier supplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return 0.0;
            }
        };
        System.out.println(DoubleStream.of(12.0, 12.1).average().orElseGet(supplier));
        OptionalDouble optionalDouble = DoubleStream.of(12.0, 12.1).average();
        optionalDouble.ifPresent(System.out::println);
        System.out.println(DoubleStream.of(12.0, 12.1).sum());
        optionalDouble.orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new Throwable();
            }
        });
        optionalDouble.orElseThrow(Throwable::new);

        DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() {
            @Override
            public double applyAsDouble(double operand) {
                return operand + 10;
            }
        };
        optionalDouble.stream().map(doubleUnaryOperator);
        optionalDouble.stream().mapToObj(s -> s + "").filter(s -> s.length() > 4);// not having .ifPresent
        Optional<Integer> optionalInteger= Optional.empty();
        optionalInteger.map(s->s+"").filter(s->s.length()>2).ifPresent(System.out::println);
    }
}
