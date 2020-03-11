package javaAgain.singleton;

/**
 * 如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，
 * 否则将存在线程非安全的问题。如果不删除这两个关键字就能保证线程安全，
 * 但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点
 */
public class LazySingleTon {
    private volatile static LazySingleTon instance = null;

    private LazySingleTon() {

    }

    public synchronized static  LazySingleTon getInstance() {
        if (instance == null) {
            instance = new LazySingleTon();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(LazySingleTon.getInstance());
    }
}
