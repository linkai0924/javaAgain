package main.java.javaAgain;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t=new Thread(counter);
        t.start();
    }
}
