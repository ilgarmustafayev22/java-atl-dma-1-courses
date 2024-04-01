package az.atlacademy.module01.lesson01;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = sc.next();

        if ("toplama".equals(menu.toLowerCase())){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            toplama(num1, num2);
        }else if ("cixma".equals(menu.toLowerCase())){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            cixma(num1, num2);
        } else if ("vurma".equals(menu.toLowerCase())) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            vurma(num1, num2);
        } else if ("bolme".equals(menu.toLowerCase())) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            bolme(num1, num2);
        }else {
            System.out.println("Invalid operation!!!");
        }

    }

    public static void toplama(int a, int b) {
        System.out.println(a + b);
    }

    public static void cixma(int a, int b) {
        System.out.println(a - b);
    }

    public static void vurma(int a, int b) {
        System.out.println(a * b);
    }

    public static void bolme(int a, int b) {
        System.out.println(a / b);
    }

}
