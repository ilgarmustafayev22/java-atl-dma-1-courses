package az.atlacademy.module01.lesson68;

import java.util.HashMap;
import java.util.List;

public class EqualsAndHashCodeApp {

    public static void main(String[] args) {
        Person a = new Person(1, "A");
        Person b = new Person(1, "A");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

       // System.out.println(a == b);

       // System.out.println(b.equals(a));
       //System.out.println(a.hashCode());
       //System.out.println(b.hashCode());
       //System.out.println(a);

        HashMap<Person, String> personIntegerHashMap = new HashMap<>();
        personIntegerHashMap.put(a, "a");
        personIntegerHashMap.put(b, "b");

        System.out.println(personIntegerHashMap.size());

    }

}
