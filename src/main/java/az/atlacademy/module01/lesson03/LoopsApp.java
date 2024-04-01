package az.atlacademy.module01.lesson03;

import java.util.Scanner;

public class LoopsApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int counter = 0;

        do {
            num /= 10;
            counter++;
        } while (num > 0);
        System.out.println(counter);



        for (int i = 0; i < 9; i++) {
            System.out.println(i);
        }


        int i = 0;
        while (i<9){
            i++;
            System.out.println(i);
        }



    }
}
