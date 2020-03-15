package jvm_command_test;

import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) throws IOException {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("running......");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
//        throw new OutOfMemoryError("dfdfdfdf");
//        throw new RuntimeException("dfdfdfdf");
        throw new IOException("dfdf");
    }
}
