package atlacademy.lesson01;

import java.util.Scanner;

public class Task02App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int a = num % 10;
        int b = num / 100;

        if (a > b) {
            System.out.println(a);
        } else if (a < b) {
            System.out.println(b);
        } else {
            System.out.println("=");
        }

    }

}
