package juc.test;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread {
        public void run() {
            System.out.println("运动员：" + Thread.currentThread().getName() + "到场");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("运动员全部到齐，比赛开始");
            }
        });

        for (int i = 0; i < 5; i++) {
            new CyclicBarrierThread().start();
        }
    }

}
