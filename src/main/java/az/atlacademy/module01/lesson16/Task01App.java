package az.atlacademy.module01.lesson16;

import java.io.Serializable;
import java.util.Scanner;
public class Task01App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double maxSalary = -1;
        double salary;

        while (sc.hasNext()) {
            salary = sc.nextDouble();
            if (maxSalary < salary)
                maxSalary = salary;
        }
        System.out.printf("%.2f", maxSalary);
    }

}
