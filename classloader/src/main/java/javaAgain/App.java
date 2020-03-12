package javaAgain;

/**
 * Hello world!
 */
public class App {

    public void funcA() {
        System.out.println("A");
    }

    /**
     *  全盘负责：即是当一个classloader加载一个Class的时候，
     *  这个Class所依赖的和引用的其它Class通常也由这个classloader负责载入。
     *
     *  委托机制：先让parent（父）类加载器 寻找，
     *  只有在parent找不到的时候才从自己的类路径中去寻找。
     */
    public static void main(String[] args) {
        ClassLoader loader = App.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }

        System.out.println(App.class.getPackage().getName());

    }
}
