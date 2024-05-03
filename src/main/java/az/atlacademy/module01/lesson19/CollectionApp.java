package az.atlacademy.module01.lesson19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionApp {

    public static void main(String[] args) {
        List<Integer> integers = oddNumbers(6, 15);
        System.out.println(Arrays.toString(integers.toArray()));
    }
    public static List<Integer> oddNumbers(int l, int r) {
        l = l % 2 == 0 ? l + 1 : l;
        r = r % 2 == 0 ? r - 1 : r;

        List<Integer> odds = new ArrayList<>();
        for (int i = l; i <= r; i += 2) {
            odds.add(i);
        }

        return odds;
    }
}
