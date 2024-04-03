package az.atlacademy.module01.lesson03;

import java.util.Arrays;
import java.util.Scanner;

public class Array02App {

    public static void main(String[] args) {
        int[] nums = {123, 45, 3, 1, 32, 16};
        System.out.println(Arrays.toString(nums));

        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                nums[i] = min;
            } else if (nums[i] == min) {
                nums[i] = max;
            }
        }
        System.out.println(Arrays.toString(nums));

    }
}
