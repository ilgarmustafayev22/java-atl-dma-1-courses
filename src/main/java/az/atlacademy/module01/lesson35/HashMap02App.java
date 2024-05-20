package az.atlacademy.module01.lesson35;

import java.util.HashMap;
import java.util.Map;

public class HashMap02App {

    public static void main(String[] args) {
        final String word = "AZERBAIJAN";
        char[] chars = word.toCharArray();

        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : chars) {
            hashMap.merge(c, 1, Integer::sum);
        }
        System.out.println(hashMap);
    }

}
