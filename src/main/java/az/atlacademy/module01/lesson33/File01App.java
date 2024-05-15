package az.atlacademy.module01.lesson33;

import java.io.*;

public class File01App {
    public static final String RESOURCE = "src/main/java/az/atlacademy/module01/lesson33/resource/";

    public static void main(String[] args) {
        Person person = new Person("John", "Doe", 43);

       try (FileOutputStream fos = new FileOutputStream(RESOURCE + "person.ser");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos)) {
           oos.writeObject(person);
       } catch (IOException e) {
           e.getMessage();
       }

        try (FileInputStream fis = new FileInputStream(RESOURCE + "person.ser");
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            Object object = ois.readObject();
            if (object instanceof Person) {
                System.out.println(object);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
