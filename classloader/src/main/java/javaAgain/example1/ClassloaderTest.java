package javaAgain.example1;

import javaAgain.App;

public class ClassloaderTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        FileSystemClassLoader cl = new FileSystemClassLoader("/Users/linkai/code/javaAgain/classloader/target/classes");
        Class<?> clazz = cl.findClass("javaAgain.App");
        App c = null;
        try {
            c = (App) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        System.out.println(c);

    }
}
