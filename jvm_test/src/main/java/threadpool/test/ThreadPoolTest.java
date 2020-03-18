package threadpool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest implements Runnable {
    @Override
    public void run() {
        try {
//            for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000000);
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final ThreadPoolTest demo = new ThreadPoolTest();
        for (int i = 0; i < 5; i++) {
            executorService.submit(demo);
        }
        executorService.shutdownNow();
//        while (true) {
//            try {
//                if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) break;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("线程池没有关闭");
//        }

    }
}
