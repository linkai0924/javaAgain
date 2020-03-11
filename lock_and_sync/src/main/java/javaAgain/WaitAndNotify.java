package main.java.javaAgain;

/**
 * wait notify 简单实现
 */
public class WaitAndNotify {

    /**
     * wait方法是一个本地方法，其底层是通过一个叫做监视器锁的对象来完成的。
     * 所以上面之所以会抛出异常，是因为在调用wait方式时没有获取到monitor对象的所有权，
     * 那如何获取monitor对象所有权？Java中只能通过Synchronized关键字来完成，增加Synchronized关键字
     */
    public synchronized void waitFunc() {
        System.out.println(Thread.currentThread().getName() + " Start-----");
        try {
            wait(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End-----");
    }

    /**
     * 有了对wait方法原理的理解，notify方法和notifyAll方法就很容易理解了。
     * 既然wait方式是通过对象的monitor对象来实现的，所以只要在同一对象上去调用notify/notifyAll方法，
     * 就可以唤醒对应对象monitor上等待的线程了。
     * notify和notifyAll的区别在于前者只能唤醒monitor上的一个线程，
     * 对其他线程没有影响，而notifyAll则唤醒所有的线程
     */
    public void notifyFunc() {

    }

    public static void main(String[] args)throws InterruptedException {
        WaitAndNotify w = new WaitAndNotify();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                w.waitFunc();
            });
            t.start();
        }

        synchronized (w) {
            w.notify();
        }
        Thread.sleep(3000);
        System.out.println("--------------");
        synchronized (w){
            w.notifyAll();
        }

    }
}

