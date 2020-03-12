package javaAgain.example2;

/**
 * 入口类，
 * 调用自定义的ClassLoader，
 * 来加载类进行验证
 */
public class MainClassLoader {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CustomerClassLoader cl = new CustomerClassLoader("/Users/linkai/code/javaAgain/classloader/target/classes");
        try {
            Class<?> clazz = cl.findClass("javaAgain.example2.Test");
            try {
                // 此处执行会抛出异常，验证了classLoader的全盘负责机制
                Test cc = (Test) clazz.newInstance();
                cc.self();
                System.out.println("1---belong class loader: " + cc.getClass().getClassLoader().toString());
            } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
                e.printStackTrace();
            }

            // 确保输出顺序
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            clazz = cl.findClass("javaAgain.example2.TestImpl");
            try {
                // 此处正常，通过塑性为基类来绕开全盘负责机制
                ITest ic = (ITest) clazz.newInstance();
                ic.self();
                System.out.println("2---belong class loader: " + ic.getClass().getClassLoader().toString());
            } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}