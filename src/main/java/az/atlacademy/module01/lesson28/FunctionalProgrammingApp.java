package az.atlacademy.module01.lesson28;

import az.atlacademy.module01.example02.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalProgrammingApp {

    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }

        };

        Consumer<String> consumer2 = string -> System.out.println(string);
        Consumer<String> consumer3 = System.out::println;


        Function<Integer, String> function = new Function<>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };

        Function<Integer, String> function2 = String::valueOf;

        BiFunction<Integer, Integer, String> biFunction = new BiFunction<>() {
            @Override
            public String apply(Integer integer, Integer integer2) {
                return integer + " " + integer2;
            }
        };

        BiFunction<Integer, Integer, String> biFunction2 = (integer, integer2) -> integer + " " + integer2;

        Predicate<String> predicate = new Predicate<>() {
            @Override
            public boolean test(String string) {
                return string.length() > 5;
            }
        };
        boolean test = predicate.test("ATL Academy");
        System.out.println(test);

        Predicate<String> predicate2 = string -> string.length() > 5;

        BiPredicate<Integer, Integer> biPredicate = new BiPredicate<>() {
            @Override
            public boolean test(Integer integer, Integer integer2) {
                return integer > integer2;
            }
        };

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(310);
        List<Integer> list1 = list.stream()
                .filter(l -> l < 4)
                .collect(Collectors.toList());
        System.out.println(list1);

    }

}
