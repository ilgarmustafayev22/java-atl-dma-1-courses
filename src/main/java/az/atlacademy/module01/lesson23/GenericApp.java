package az.atlacademy.module01.lesson23;

import java.time.LocalDate;
import java.util.Optional;

public class GenericApp {

    public static void main(String[] args) {
        // requiredNonNull("aa");
        // requiredNonNull(2);
        // requiredNonNull(LocalDate.now());
        // requiredNonNull(Integer.valueOf(null));
        //String s = requiredNonNull("sss");
        //Integer num = requiredNonNull(1);
        //System.out.println(s);
        //System.out.println(num);

        Box<Integer> integerBox = new Box<>(1);
        Box<String> stringBox = new Box<>("aaa");

        // integerBox.setData(true);
        //Box<Box<Integer>> boxBox = new Box<>(integerBox);

       //Box box = new Box(true);
       //box.setData(1);

        Optional<Object> orElse = getOrElse(5);
        System.out.println(orElse);

    }

    // private static void requiredNonNull(String string) {
    //     if (string == null) {
    //         throw new CustomNullPointerException("this object is null");
    //     }
    // }

    // private static void requiredNonNull(Integer integer) {
    //     if (integer == null) {
    //         throw new CustomNullPointerException();
    //     }
    // }

    // private static void requiredNonNull(LocalDate localDate) {
    //     if (localDate == null) {
    //         throw new CustomNullPointerException();
    //     }
    // }
    //
    // private static void requiredNonNull(Object object) {
    //     if (object == null) {
    //         throw new CustomNullPointerException();
    //     }
    // }


    private static <T> T requiredNonNull(T data) {
        if (data == null) {
            throw new CustomNullPointerException();
        }
        return data;
    }

    private static <T> Optional<T> getOrElse(T data) {
        if (data == null) {
            return Optional.empty();
        }
        return Optional.of(data);
    }

}
