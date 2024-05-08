package az.atlacademy.module01.lesson30;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionApp {

    public static void main(String[] args) throws NoSuchFieldException {
        Person person = new Person("AAA", "BBB");

        Field field = person.getClass().getDeclaredField("name");
        Constructor<?>[] constructors = person.getClass().getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println(field);
    }
}
