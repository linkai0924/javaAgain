package javaAgain.singleton;

/**
 *
 * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，
 * 可以直接用于多线程而不会出现问题
 *
 * 其实有7种，暂时掌握者两种就好了
 * https://blog.csdn.net/itachi85/article/details/50510124
 */
public class HangrySingleTon {
    private static final HangrySingleTon instance = new HangrySingleTon();

    private HangrySingleTon() {
    }

    public static HangrySingleTon getInstance() {
        return instance;
    }
}
