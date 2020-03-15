package aop.jdk;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Kevin on 2017/11/8.
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(), new ProxySubject(new RealSubject()));
        subject.sayHello();

        //查看subject对象的类型
        System.out.println(subject.getClass().getName());



    }
}