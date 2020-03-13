package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clz = Class.forName("reflect.Apple");
        Method method = clz.getMethod("setPrice", int.class);
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object, 4);

    }
}
