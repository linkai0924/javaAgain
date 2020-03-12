package main.java.javaAgain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://www.jianshu.com/p/8327c5c15cb8
 * static方法调用方式是通过class.fun，而非static方法调用是先new出这个对象，再调用。
 * static synchronized是类锁，synchronized是对象锁。
 *
 * 情况1：用类直接在两个线程中调用两个不同的同步方法
 * 结果：会产生互斥。
 * 解释：因为对静态对象加锁实际上对类（.class）加锁，类对象只有一个，可以理解为任何时候都只有一个空间，里面有N个房间，一把锁，因此房间（同步方法）之间一定是互斥的。
 * 注：上述情况和用单例模式声明一个对象来调用非静态方法的情况是一样的，因为永远就只有这一个对象。所以访问同步方法之间一定是互斥的。
 *
 * 情况2：用一个类的静态对象在两个线程中调用静态方法或非静态方法
 * 结果：会产生互斥。
 * 解释：因为是一个对象调用，同上。
 *
 * 情况3：一个对象在两个线程中分别调用一个静态同步方法和一个非静态同步方法
 * 结果：不会产生互斥。
 * 解释：因为虽然是一个对象调用，但是两个方法的锁类型不同，调用的静态方法实际上是类对象在调用，即这两个方法产生的并不是同一个对象锁，因此不会互斥，会并发执行。
 */
public class SynchronizedTest {

    public static SynchronizedTest staticIn = new SynchronizedTest();   //静态对象

    public synchronized void method1() {
        //非静态方法1
        for (int i = 0; i < 10; i++) {
            System.out.println("method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized void method2() {                                   //非静态方法2
        for (int i = 0; i < 10; i++) {
            System.out.println("method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized static void staticMethod1() {                     //静态方法1
        for (int i = 0; i < 10; i++) {
            System.out.println("static method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized static void staticMethod2() {                      //静态方法2
        for (int i = 0; i < 10; i++) {
            System.out.println("static method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(t1);
        exec.execute(t2);
        exec.shutdown();
    }
}

class Thread1 implements Runnable {

    @Override
    public void run() {
//      SynchronizedTest s = SynchronizedTest.getInstance();
//      s.method1();
//      SynchronizedTest s1 = new SynchronizedTest();
//      s1.method1();
        SynchronizedTest.staticIn.method1();

//      SynchronizedTest.staticMethod1();
//      SynchronizedTest.staticMethod2();
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
//      SynchronizedTest s = SynchronizedTest.getInstance();
//      SynchronizedTest s2 = new SynchronizedTest();
//      s2.method1();
//      s.method2();
//      SynchronizedTest.staticMethod1();
//      SynchronizedTest.staticMethod2();
//      SynchronizedTest.staticIn.method2();
        SynchronizedTest.staticIn.staticMethod1();
    }
}