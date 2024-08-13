package az.atlacademy.module01.lesson29;

import java.util.UUID;
import java.util.concurrent.Callable;

public class MyThreadApp {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("2");
        int priority = myThread.getPriority();
        System.out.println(priority);
        myThread.setPriority(10);
        int priority2 = myThread.getPriority();
        System.out.println(priority2);
        // new MyThread("Aqil").start();
       // new MyThread("Zeka").start();
       // new MyThread("Ilqar").start();

        new MyThread("1").run();

        String call = new MyThread2().call();
        System.out.println(call);

    }

    public static class MyThread extends Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread name:" + Thread.currentThread().getName());
            }
        }

        @Override
        public synchronized void start() {
            super.start();
        }
    }

    public static class MyThread2 implements Callable<String> {

        @Override
        public String call() {
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        }

    }


}
