package jvm_command_test;

public class Metaspace {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("jvm_command_test.TestLock" + i).toClass();
        }
    }
}
