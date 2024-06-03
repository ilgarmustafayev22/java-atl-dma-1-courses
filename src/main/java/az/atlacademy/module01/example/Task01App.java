package az.atlacademy.module01.example;

import java.util.ArrayList;
import java.util.List;

public class Task01App {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);

        List<Integer> b = a;
        b.add(6);
        System.out.println("a = " + a + ", b = " + b);


        Car car = new Car("A");
        Car car1 = car;
        car1.name = "B";
        System.out.println(car.name);

        String c = new String("C");
        String d = c;
        d = "D";

        System.out.println(d);
        System.out.println(c);
    }

}
