package az.atlacademy.module01.lesson32;

public class TestApp {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        for (int num : nums) {
            num *= 2;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= 2;
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

}
