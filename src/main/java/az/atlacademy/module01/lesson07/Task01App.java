package az.atlacademy.module01.lesson07;

import java.util.Scanner;

public class Task01App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();

        long n = 1;
        for (long i = 2; i > 0; i++) {
            n += i;
            if (n % num == 0) {
                System.out.println(i);
                break;
            }
        }

    }
}
