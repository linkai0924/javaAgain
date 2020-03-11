package main.java.javaAgain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 轮流打印ABC
 * 这种方式不是很优雅，每次取模打印，并没有线程的执行顺序
 */
public class ABClock {
    private static int state = 0;

    public static void main(String[] args) {
        final Lock l = new ReentrantLock();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    l.lock();
                    if (state % 3 == 0) {
                        System.out.println("A");
                        state++;
                    }
                    l.unlock();
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    l.lock();
                    if (state % 3 == 1) {
                        System.out.println("B");
                        state++;
                    }
                    l.unlock();
                }
            }
        });
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    l.lock();
                    if (state % 3 == 2) {
                        System.out.println("C");
                        state++;
                    }
                    l.unlock();
                }
            }
        });
        A.start();
        B.start();
        C.start();
    }

}