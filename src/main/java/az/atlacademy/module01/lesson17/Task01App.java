package az.atlacademy.module01.lesson17;

import java.util.Scanner;

public class Task01App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        int[] nums = new int[length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }


        int counter = 0;
        for (int i = 1; i < length-1; i++) {
            int curr = nums[i];
            if (curr>nums[i+1] && curr>nums[i-1]){
                counter++;
            }
        }
        System.out.println(counter);

    }

}
