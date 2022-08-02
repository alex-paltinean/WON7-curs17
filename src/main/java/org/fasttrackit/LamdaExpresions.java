package org.fasttrackit;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaExpresions {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        list.stream().map(a -> a + 1).forEach(a -> System.out.println(a));
//        list.stream().map((a) -> a + 1).forEach((Integer a) -> System.out.println(a));
//        list.stream().map(a -> {
//            System.out.print("before: ");
//            System.out.println(a);
//            return a + 1;
//        }).forEach(a -> {
//            System.out.println(a);
//        });
//
//        tryFunction(a -> a + 1);
//        tryFunction(b -> b * 10);
//
//        trySupplier(() -> "Hello");
//        trySupplier(() -> "World");

//        tryConsumer(str -> System.out.println(str + " consumer"));
//        tryConsumer(str -> {
//            int a = str.length();
//            // something else
//            System.out.println(a);
//        });

//        tryPredicate(i -> i > 10);
//        tryPredicate(i -> i % 2 == 0);

        tryMultiple(
                () -> "Anamaria",
                str -> str.length(),
                number -> number > 5,
                number -> System.out.println("Este mai mare de 5"),
                () -> System.out.println("Nu este mai mare de 5")
        );
    }

    private static void tryMultiple(
            Supplier<String> supplier,
            Function<String, Integer> transformer,
            Predicate<Integer> tester,
            Consumer<Integer> intConsumer,
            Runnable runnable) {
        Integer value = transformer.apply(supplier.get());
        if (tester.test(value)) {
            intConsumer.accept(value);
        } else {
            runnable.run();
        }
    }

    private static void tryPredicate(Predicate<Integer> integerTester) {
        int a = 13; // obtained from lines above
        if (integerTester.test(13)) {
            System.out.println("WON");
        } else {
            System.out.println("LOSE");
        }
    }

    private static void tryConsumer(Consumer<String> stringConsumer) {
        // 100 lines of code
        stringConsumer.accept("something");
        // 100 lines of code
        stringConsumer.accept("another one");
        // 100 lines of code
    }

    public static void trySupplier(Supplier<String> stringSupplier) {
        String value = stringSupplier.get();
        if (value.startsWith("H")) {
            System.out.println(value.toLowerCase());
        } else {
            System.out.println("Not H");
        }
    }

    public static void tryFunction(Function<Integer, Integer> incrementor) {
        // 100 lines of code
        System.out.println(incrementor.apply(4));
        // 100 lines of code
    }
}
