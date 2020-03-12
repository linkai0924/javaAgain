package javaAgain;

/**
 * Hello world!
 */
public class App {

    public void funcA() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        ClassLoader loader = App.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }

    }
}
