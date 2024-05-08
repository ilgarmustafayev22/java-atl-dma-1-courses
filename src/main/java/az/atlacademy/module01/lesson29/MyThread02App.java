package az.atlacademy.module01.lesson29;

public class MyThread02App {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        boolean daemon = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).isDaemon();
        System.out.println(daemon);

        boolean alive = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).isAlive();
        System.out.println(alive);


    }
}
