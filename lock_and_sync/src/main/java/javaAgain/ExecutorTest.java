package main.java.javaAgain;

/**
 * java线程池
 * https://blog.csdn.net/riemann_/article/details/97617432
 *
 * newSingleThreadExecutor返回一个包含单线程的Executor,将多个任务交给此Executor时，这个线程处理完一个任务后接着处理下一个任务，若该线程出现异常，将会有一个新的线程来替代。
 * newFixedThreadPool返回一个包含指定数目线程的线程池，如果任务数量多于线程数目，那么没有执行的任务必须等待，直到有任务完成为止。
 * newCachedThreadPool根据用户的任务数创建相应的线程来处理，该线程池不会对线程数目加以限制，完全依赖于JVM能创建线程的数量，可能引起内存不足，线程自动回收。
 * 底层是基于ThreadPoolExecutor实现，借助reentrantlock保证并发。
 * coreSize核心线程数，maxsize最大线程数。
 */
public class ExecutorTest {
}
