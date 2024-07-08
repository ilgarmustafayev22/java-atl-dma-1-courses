package az.atlacademy.module01.lesson68;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class StreamApp {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 5, 6, 111, 67, 88, 100, 12, 44);

        ArrayList<Integer> oddNums = new ArrayList<>();

        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) % 2 == 0) {
                oddNums.add(integers.get(i));
            }
        }

        Integer max = integers.get(0);
        for (Integer oddNum : oddNums) {
            if (oddNum > max) {
                max = oddNum;
            }
        }
        System.out.println(max);


        Integer max1 = integers.stream()
                .filter(integer -> integer % 2 == 0)
                .max(Integer::compareTo)
                .get();

        System.out.println(max);

    }

}
