package az.atlacademy.module01.lesson18;

import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquareApp {

    public static void main(String[] args) {
        char[][] table = new char[5][5];

        final int row = (int) (Math.random() * 5);
        final int col = (int) (Math.random() * 5);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = '-';
            }
        }
        printTable(table);

        Scanner sc = new Scanner(System.in);

        int guessedRow;
        int guessedColumn;
        while (true) {
            guessedRow = sc.nextInt();
            guessedColumn = sc.nextInt();

            if (row == guessedRow && col == guessedColumn) {
                table[row][col]='x';
                printTable(table);
                System.out.println("You have won!");
                break;
            }else {
                table[guessedRow][guessedColumn] = '*';
                printTable(table);
            }
        }


    }


    private static void printTable(char[][] table) {
        for (int i = 0; i <= 5; i++) {
            System.out.print(i + " | ");
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1 + " | ");
            for (int j = 0; j < 5; j++) {
                System.out.print(table[i][j] + " | ");
            }
            System.out.println();
        }
    }


}
