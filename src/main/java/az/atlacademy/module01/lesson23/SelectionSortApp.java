package az.atlacademy.module01.lesson23;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSortApp {

    public static void main(String[] args) {
        int[] nums = new int[8];
        for (int i = 0; i < 8; i++) {
            nums[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(nums));

        selectionSort(nums);
    }

    private static void selectionSort(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
            System.out.println(Arrays.toString(nums));
        }
    }

}
