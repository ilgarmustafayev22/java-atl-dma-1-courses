package az.atlacademy.module01.lesson30;

import java.util.function.BiFunction;

public class FunctionalProgrammingApp {

    public static void main(String[] args) {
        BiFunction<Integer, Double, String> biFunction = (integer, aDouble) -> integer + " " + aDouble;


    }

}
