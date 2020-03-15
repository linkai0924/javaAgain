package main.java.javaAgain;

import java.util.concurrent.Semaphore;

public class ABCsemaphore {
    private int times;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public ABCsemaphore(int times) {
        this.times = times;
    }


    public static void main(String[] args) {
        ABCsemaphore ABCsemaphore = new ABCsemaphore(10);
        new Thread(ABCsemaphore::printA).start();
        new Thread(ABCsemaphore::printB).start();
        new Thread(ABCsemaphore::printC).start();
    }

    public void printA() {
        print("A", semaphoreA, semaphoreB);
    }

    public void printB() {
        print("B", semaphoreB, semaphoreC);
    }

    public void printC() {
        print("C", semaphoreC, semaphoreA);
    }


    public void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < times; i++) {
            try {
                current.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(name);
            next.release();
        }

    }
}