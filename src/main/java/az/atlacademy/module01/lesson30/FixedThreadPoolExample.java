package az.atlacademy.module01.lesson30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample implements Runnable {

    private String taskName;

    public FixedThreadPoolExample(String taskName) {
        // TODO Auto-generated constructor stub
        this.taskName = taskName;
    }

    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        System.out.println("Starting: " + taskName);
        for (int i = 0; i <= 5; i++)
        {
            System.out.println("Executing: " + taskName + " with " + Thread.currentThread().getName() + "---" + i);
        }
        System.out.println("End of the loop " + taskName);
    }

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(1);
        for (int i = 0; i <= 6; i++) {
            es.submit(new FixedThreadPoolExample("TaskId"+i));
        }
        es.shutdown();

    }

}