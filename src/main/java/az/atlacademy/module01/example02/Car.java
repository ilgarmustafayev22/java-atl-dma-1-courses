package az.atlacademy.module01.example02;

public class Car {
    public static int counter = 1;

    public void foo() {
        System.out.println(counter);
    }

    private String color;
    private String engine;

    private int wheel;

    public Car() {
    }


    public Car(String color, String engine, int wheel) {
        this.color = color;
        this.engine = engine;
        this.wheel = wheel;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }


    @Override
    public String toString() {
        return "Car{color='%s', engine='%s', wheel=%d}".formatted(color, engine, wheel);
    }

    static {
        System.out.println("Carrr");
    }

}
