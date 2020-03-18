package juc.test;

import java.util.concurrent.*;

/**
 * https://www.jianshu.com/p/b1408e3e3bb4
 */
public class SynchronousQueueQuiz {
    public static void main(String[] args) throws Exception {
//        BlockingQueue<Integer> queue = new PriorityBlockingQueue(1);
//        BlockingQueue<Integer> queue = new DelayQueue();
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue(1);
//        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.print(queue.offer(1) + " ");
        System.out.print(queue.offer(2) + " ");
        System.out.print(queue.offer(3) + " ");
        System.out.print(queue.take() + " ");
        System.out.println(queue.size());
    }
}