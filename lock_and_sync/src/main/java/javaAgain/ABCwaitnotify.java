package main.java.javaAgain;

/**
 * 轮流打印ABC
 * 这种方式实现的轮流打印，线程是同步的，加了2层锁，但没有共用信号量
 */
public class ABCwaitnotify {
    public static void main(String[] args) throws Exception {
        Object A = new Object();
        Object B = new Object();
        Object C = new Object();

        Thread t1 = new Thread(new Print(A, B), "A");
        Thread t2 = new Thread(new Print(B, C), "B");
        Thread t3 = new Thread(new Print(C, A), "C");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("---OK---");

    }
}

class Print implements Runnable {

    private Object self;
    private Object next;

    public Print(Object self, Object next) throws InterruptedException {
        this.self = self;
        this.next = next;

    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (self) {
                synchronized (next) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    next.notify();
                }
                try {
                    if (i < 9) {
                        self.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}