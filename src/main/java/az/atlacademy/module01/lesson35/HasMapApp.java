package az.atlacademy.module01.lesson35;

import az.atlacademy.module01.lesson34.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class HasMapApp {

    public static void main(String[] args) {

        Hashtable<Long, String> hashtable = new Hashtable<>();
        hashtable.put(1L, "Nihad");
        hashtable.put(6L, "Gunel");
        hashtable.put(2L, "Hasan");
        hashtable.put(5L, "Zeka");
        hashtable.put(3L, "Araz");
        //hashtable.put(null, "Zeka");
        //hashtable.put(4L, null);

        System.out.println(hashtable);

        System.out.println("==================");

        HashMap<Long, String> hashMap = new HashMap<>();
        hashMap.put(5L, "Zeka");
        hashMap.put(1L, "Nihad");
        hashMap.put(2L, "Hasan");
        hashMap.put(3L, "Araz");
        hashMap.put(null, "Zeka");
        hashMap.put(4L, null);
        System.out.println(hashMap);

        System.out.println("==================");

        TreeMap<Long, String> treeMap = new TreeMap<>();
        treeMap.put(5L, "Zeka");
        treeMap.put(1L, "Nihad");
        treeMap.put(2L, "Hasan");
        treeMap.put(3L, "Araz");
        // treeMap.put(null, "Zeka");
       // treeMap.put(4L, null);
        System.out.println(treeMap);

        HashMap<String, Long> hashMap1 = new HashMap<>();
        hashMap1.put("Zeka", 2L);
        hashMap1.put("Araz", 1L);
        hashMap1.put("Hasan", 3L);
        hashMap1.put("AAA", 4L);
        System.out.println(hashMap1);

    }

}
