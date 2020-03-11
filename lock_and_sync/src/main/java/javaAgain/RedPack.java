package main.java.javaAgain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程同时抢红包，保证红包不重复
 */
public class RedPack {

    public static int pack = 1000;
    Lock lock = new ReentrantLock();


    /**
     * 同步方式1 同步块
     */
    public int getPack() {
        //参数是this对象	能实现同步 实现同步的同时，会阻塞其他线程获取这个对象的锁，影响执行效率
        //参数是非this对象 能实现同步 synchronized（非this）代码块中程序与同步方法是异步的，不与其他锁this同步方法争夺this锁，可以提高执行效率
        synchronized (this) {
            pack -= 1;
        }
        return pack;
    }

    /**
     * 同步方式2 同步关键字
     */
    public synchronized int getPack2() {
        pack -= 1;
        return pack;
    }

    /**
     * 同步方式3 ReentrantLock
     */
    public int getPack3() {
        lock.lock();
        try {
            pack -= 1;
        } finally {
            lock.unlock();
        }
        return pack;
    }

    public static void main(String[] args) {
        RedPack r = new RedPack();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                try {
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " " + r.getPack3());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + r.getPack3());
            }
        });

        t1.start();
        t2.start();
    }
}
