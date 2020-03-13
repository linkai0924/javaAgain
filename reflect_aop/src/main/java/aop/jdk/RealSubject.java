package aop.jdk;

/**
 * 目标对象，即需要被代理的对象
 * Created by Kevin on 2017/11/8.
 */
public class RealSubject implements Subject {
    public void sayHello() {
        System.out.println("hello world");
    }
}