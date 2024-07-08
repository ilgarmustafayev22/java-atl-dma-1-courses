package az.atlacademy.module01.lesson68;

import java.util.Random;

public class Stream02App {

    public static void main(String[] args) {
        // new Random().ints(10, 100, 100)
        //         .filter(value -> value%2==0)
        //         .forEach(System.out::println);

        //  StringBuilder stringBuilder = new StringBuilder("Hello");
        //  String s = "Hello";
        //  if (stringBuilder.equals(s)){
        //      System.out.println("1");
        //  } else if (s.equals(stringBuilder)) {
        //      System.out.println("2");
        //  }else {
        //      System.out.println("3");
        //  }

        //  System.out.println(s.hashCode());
        //  System.out.println(stringBuilder.hashCode());

        Test<Integer> test = new Test<Integer>(1, "A");
        //test.setAge("a");

        Test objectTest = new Test(2, "B");
        objectTest.setAge(true);


    }

}
