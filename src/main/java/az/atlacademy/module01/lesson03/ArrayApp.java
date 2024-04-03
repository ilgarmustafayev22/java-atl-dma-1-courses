package az.atlacademy.module01.lesson03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }

        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }

        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        int prod = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            prod *= nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }

            if (min > nums[i]) {
                min = nums[i];
            }
        }

        System.out.println(prod);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);


    }

}
