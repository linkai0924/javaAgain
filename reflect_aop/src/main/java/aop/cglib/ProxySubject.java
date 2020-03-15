package aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理类
 * Created by Kevin on 2017/11/6.
 */
public class ProxySubject implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
        // 用于创建无参的目标对象代理类，
        // 对于有参构造器则调用Enhancer.create(Class[] argumentTypes, Object[] arguments)，
        // 第一个参数表示参数类型，第二个参数表示参数的值。
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("调用后");
        return result;
    }
}