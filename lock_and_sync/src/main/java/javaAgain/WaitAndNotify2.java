package main.java.javaAgain;

/**
 * 实现轮流抽签
 */

class WaitAndNotify2 implements Runnable {
    Object lock = new Object();
    int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " " + count--);
                lock.notifyAll();
                try {
                    if (count <= 100) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new WaitAndNotify2()).start();
        Thread.sleep(1); //保重两个线程先后启动
        new Thread(new WaitAndNotify2()).start();
    }
}

