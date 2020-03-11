package main.java.javaAgain;

/**
 * 实现多个线程轮流抽签
 */
public class WaitAndNotify {

    public void test() {
        try {
            wait(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            try {
//                for (int i = 0; i < 10; i++) {
//                    Thread.sleep(1000);
//                    if(i==5){
//
//                    }
//                    System.out.println(Thread.currentThread().getName() + "--waiting--" + i);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        t1.start();
        WaitAndNotify w=new WaitAndNotify();
        w.test();

    }
}

