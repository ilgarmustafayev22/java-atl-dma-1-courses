package az.atlacademy.module01.lesson04;

public class ArrayApp {

    public static void main(String[] args) {
        int[][] nums = new int[5][5];

        int counter = 0;
        for (int row = 0; row < nums.length; row++) {
            for (int column = 0; column < nums.length; column++) {
                nums[row][column] = counter++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
