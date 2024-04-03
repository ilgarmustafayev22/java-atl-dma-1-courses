package az.atlacademy.module01.lesson03;

import java.util.Scanner;

public class Array03App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();

        int[][] table = new int[row][column];

        int counter = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = counter++;
            }
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(table.length);
    }

}
