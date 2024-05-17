package az.atlacademy.module01.lesson35;

import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;

public class User implements Comparable<User>{
    private long id;
    private String name;
    private int age;

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User u) {
        return Long.compare(this.age, u.age);
    }
}
