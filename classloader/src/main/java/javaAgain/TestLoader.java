package javaAgain;

public class TestLoader extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> x = Class.forName("App.class");
        System.out.println(x);

        x = ClassLoader.getSystemClassLoader().loadClass("App.class");
        System.out.println(x);
    }
}
