package javaAgain;

public class TestLoader {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> x = null;
        try {
            x = Class.forName("javaAgain.App");
            App a=(App)x.newInstance();
            a.funcA();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(x);

        try {
            x = ClassLoader.getSystemClassLoader().loadClass("javaAgain.App");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(x);
    }

}
