package main.java.javaAgain;

/**
 * 首先，一个线程不应该由其他线程来强制中断或停止，而是应该由线程自己自行停止。
 * 所以，Thread.stop, Thread.suspend, Thread.resume 都已经被废弃了。
 * 而 Thread.interrupt 的作用其实也不是中断线程，而是「通知线程应该中断了」，
 * 具体到底中断还是继续运行，应该由被通知的线程自己处理。
 *
 * 如果线程处于被阻塞状态（例如处于sleep, wait, join 等状态），
 * 那么线程将立即退出被阻塞状态，并抛出一个InterruptedException异常。仅此而已
 * 如果线程处于正常活动状态，那么会将该线程的中断标志设置为 true，仅此而已。
 * 被设置中断标志的线程将继续正常运行，不受影响
 */
public class Interrupt {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t.interrupt();
    }
}
