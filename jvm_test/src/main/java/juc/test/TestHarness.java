package juc.test;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            System.out.println(Thread.currentThread().getName() + "开始执行");
                            task.run();
                        } finally {
                            endGate.countDown();
                            System.out.println(Thread.currentThread().getName() + "执行结束");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println("所有线程执行完毕，耗时：" + (end - start));
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(timeTasks(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "————————work");
            }
        }));
    }
}
