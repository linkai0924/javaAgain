package main.java.javaAgain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {

    final Semaphore semaphore = new Semaphore(3);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " -----Done");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }
    }
}
