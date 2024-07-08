package az.atlacademy.module01.lesson35;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HashMap02App {

    public static void main(String[] args) {
        final String word = "AZERBAIJAN";
        char[] chars = word.toCharArray();

        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : chars) {
            hashMap.merge(c, 1, Integer::sum);
        }
        System.out.println(hashMap);

        Map<Character, Long> collect = word.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

    }

}
