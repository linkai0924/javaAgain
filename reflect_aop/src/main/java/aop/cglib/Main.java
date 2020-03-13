package aop.cglib;

public class Main {
    public static void main(String[] args) {
        RealSubject subject = (RealSubject) new ProxySubject().getProxy(RealSubject.class);
        subject.sayHello();
        System.out.println(subject.getClass().getName());
    }
}