package az.atlacademy.module01.lesson32;

import az.atlacademy.module01.lesson30.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class File01App {

    public static final String RESOURCE = "src/main/java/az/atlacademy/module01/lesson32/resource/";

    public static void main(String[] args) {

        //Person person = new Person("A", "B");

        try {
            FileOutputStream fos = new FileOutputStream(RESOURCE + "a.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write("Ilqar".getBytes());
            bos.close();
            fos.close();
        } catch (IOException e) {
            e.getMessage();
        }


        try {
            FileInputStream fis = new FileInputStream(RESOURCE + "a.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] bytes = bis.readAllBytes();
            System.out.println(Arrays.toString(bytes));
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            e.getMessage();
        }


    }

}
