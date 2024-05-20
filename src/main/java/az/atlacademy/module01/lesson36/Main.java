package az.atlacademy.module01.lesson36;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 6, 3, 11, 1, 12};
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        String[] letters = {"Z", "C", "A", "B"};
        System.out.println(Arrays.toString(letters));
        Arrays.sort(letters);
        System.out.println(Arrays.toString(letters));


    }
}
