package main.java.javaAgain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABClock2 {
    private int times;
    private int state;
    private Lock lock = new ReentrantLock();

    public ABClock2(int times) {
        this.times = times;
    }

    public void printA() {
        print("A", 0);
    }

    public void printB() {
        print("B", 1);
    }

    public void printC() {
        print("C", 2);
    }

    public void print(String name, int stateNow) {
        for (int i = 0; i < times;) {
            lock.lock();
            if (stateNow == state % 3) {
                state++;
                i++;
                System.out.println(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ABClock2 ABClock2 = new ABClock2(10);
        new Thread(ABClock2::printA).start();
        new Thread(ABClock2::printB).start();
        new Thread(ABClock2::printC).start();

    }

}
