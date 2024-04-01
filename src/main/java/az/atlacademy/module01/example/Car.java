package az.atlacademy.module01.example;

import java.util.Objects;

public class Car {

    static {
        System.out.println("1111");
    }

    public static final String SOME = "blanaak";
    private String engine;
    public String color;
    public int wheel;

    @Override
    public String toString() {
        return "Car{engine='%s', color='%s', wheel=%d}".formatted(engine, color, wheel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return wheel == car.wheel && Objects.equals(engine, car.engine) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, color, wheel);
    }

    public Car(String engine, String color, int wheel) {
        this.engine = engine;
        this.color = color;
        this.wheel = wheel;
    }


    public Car(String engine) {
        this.engine = engine;
    }

    public Car(String color, int wheel) {
        this.color = color;
        this.wheel = wheel;
    }

    public Car() {
    }

}
