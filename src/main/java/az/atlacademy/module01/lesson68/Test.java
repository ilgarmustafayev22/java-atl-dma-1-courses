package az.atlacademy.module01.lesson68;

public class Test<T> {

    private T age;
    private String name;

    public Test(T age, String name) {
        this.age = age;
        this.name = name;
    }


    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
