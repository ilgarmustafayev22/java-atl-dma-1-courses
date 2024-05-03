package az.atlacademy.module01.lesson19;

import az.atlacademy.Main;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collections;

public class StringApp {

    public static void main(String[] args) {
        String s = new String("A");//A
        String a1 = "A"; //A
        String aa = "A"; //A

        String s1 = "A" + "A";//AA

        String a2 = a1 + a1; //AA

        String a3 = a1.concat(a1).concat(a1); //AAA
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        String sb = new StringBuilder()
                .append(1)
                .append("1")
                .append(true)
                .toString();
        System.out.println(sb);

        String sbf = new StringBuffer()
                .append(2)
                .append("2")
                .append(false)
                .toString();
        System.out.println(sbf);

    }

}
