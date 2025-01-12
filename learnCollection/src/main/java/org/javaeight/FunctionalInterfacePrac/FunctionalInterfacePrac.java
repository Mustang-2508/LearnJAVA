package org.javaeight.FunctionalInterfacePrac;

import java.util.function.*;


public class FunctionalInterfacePrac {
    public static void main(String[] args) {

        /**
         * Predicate : Takes one argument and returns Boolean. contains abstract method test().
         * Function : Takes one argument and returns result. contains abstract method apply().
         * Consumer : Takes one argument and returns void. contains abstract method accept().
         * Supplier : Takes nothing and returns Something. contains abstract method get().
         * */
        Predicate<Integer> predicate = (x)-> x%2 ==0;
        System.out.println(predicate.test(10));

        Function<String, Integer> function = (s) -> s.length();
        System.out.println(function.apply("Mustang"));

        Consumer<String> consumer = x -> System.out.println("From Consume: "+x);
        consumer.accept("Mustang");

        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());

        /**
         * BiPredicate : Takes two argument and returns Boolean. contains abstract method test().
         * BiFunction : Takes two argument and returns result. contains abstract method apply().
         * BiConsumer : Takes two argument and returns void. contains abstract method accept().
         * */

        BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a+b)%2 ==0;
        System.out.println("Is sum Even: "+biPredicate.test(10,20));

        BiFunction<String, String, Integer> biFunction = (x, y)-> x.length()+y.length();
        System.out.println("Length of \"Ford\" and \"Mustang\": " + biFunction.apply("Ford", "Mustang"));

        BiConsumer<String, Integer> biConsumer = (s, i)-> {
            System.out.println("From BiConsumer: "+s);
            System.out.println("From BiConsumer: "+i);
        };
        biConsumer.accept("Sukhoi", 30);

        /**
         * UnaryOperator: Represents an operation on a single operand that produces a result of the same type as its operand.
         *                Similar to Function<Integer, Integer> with Same input and Output type
         *                Just reduces efforts of writing parameter and return type twice if they are similar.
         * BinaryOperator: Represents an operation upon two operands of the same type, producing a result of the same type.
         *                 Similar to BiFunction<Integer, Integer> with Same input and Output type
         *                 Just reduces efforts of writing parameter and return type twice if they are similar.
         * */

        Function<Integer, Integer> doubleIt = (a) -> 2*a;
        System.out.println("With Function: "+doubleIt.apply(4));
        UnaryOperator<Integer> unaryOperator = (a) -> 2*a;
        System.out.println("With UnaryOperator: "+unaryOperator.apply(4));

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a+b;
        System.out.println("With BiFunction: "+sum.apply(10, 10));
        BinaryOperator<Integer> binaryOperator = (a, b) -> a+b;
        System.out.println("With BinaryOperator: "+binaryOperator.apply(10, 10));
    }

}
























