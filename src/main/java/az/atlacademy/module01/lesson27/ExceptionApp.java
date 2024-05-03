package az.atlacademy.module01.lesson27;

import java.util.Scanner;

public class ExceptionApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

       // int num = Integer.parseInt(word);

       try {
           int num = Integer.parseInt(word);
       } catch (NumberFormatException e) {
           System.out.println("111");
       }

    }
}
