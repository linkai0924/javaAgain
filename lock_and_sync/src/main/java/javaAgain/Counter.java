package main.java.javaAgain;

public class Counter implements Runnable{
    private int count = 0;
    private int count2 = 0;


    public synchronized int incr() {
        count += 1;
        return count;
    }

    public int incrNoSync() {
        count2 += 1;
        return count2;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+this.incr()+" "+this.incrNoSync());
    }
}
