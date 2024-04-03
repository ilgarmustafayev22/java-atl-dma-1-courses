package az.atlacademy.module01.example;

import java.util.Scanner;

public class ScannerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        String myString = sc.nextLine();
        System.out.println(myString);
        int myInt = sc.nextInt();
        System.out.println(myInt);
    }

}
