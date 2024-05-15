package az.atlacademy.module01.lesson33;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    public static final String  TEST1 = "TEST";
    public static final long serialVersionUID = 2L;
    private String name;
    private String surname;
    private long age;
    private long age2;

   // private transient int test;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "Person{name='%s', surname='%s', age=%d}".formatted(name, surname, age);
    }

}
