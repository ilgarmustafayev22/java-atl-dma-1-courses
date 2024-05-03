package az.atlacademy.module01.lesson22;

import java.util.Scanner;

public class SearchApp {

    public static void main(String[] args) {

        for (int i = 0; i <= 10000000; i++) {
            if (i == 1000000) {
                System.out.println(i);
            }
        }

    }


    private static int findNum(int[] nums, int num) {
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < num) {
                count++;
                start = (mid + 1);
            } else if (nums[mid] > num) {
                count++;
                end = (mid - 1);
            } else {
                System.out.println(count);
            }
        }
        return -1;
    }

}
