package az.atlacademy.module01.lesson05;

import java.util.Scanner;

public class SumAndCountApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        while (sc.hasNext()) {

            int a = sc.nextInt();
            count++;
            sum += a;

        }

        System.out.print(count + " " + sum);
    }

}
