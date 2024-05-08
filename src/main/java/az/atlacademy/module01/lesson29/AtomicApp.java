package az.atlacademy.module01.lesson29;

public class AtomicApp {

    public static int counter = 0;
    public static void main(String[] args) {
        new Thread(() -> counter++).start();
    }
}
