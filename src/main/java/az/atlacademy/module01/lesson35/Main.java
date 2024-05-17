package az.atlacademy.module01.lesson35;

import javax.crypto.MacSpi;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<User> treeSet = new TreeSet<>();
        treeSet.add(new User(3,"s", 23));
        treeSet.add(new User(32,"s", 23));
        treeSet.add(new User(1,"s", 23));
        treeSet.add(new User(5,"s", 23));
        System.out.println(treeSet);

    }
}
