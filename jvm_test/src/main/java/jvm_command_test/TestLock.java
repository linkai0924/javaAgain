package jvm_command_test;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察JVM的GC状况
 * -Xms20m -Xmx20m -Xmn5m -XX:MetaspaceSize=5m -XX:+PrintGCTimeStamps -XX:+PrintGCDetails
 * 通常用-verbose:gc 替代 -XX:PrintGCxx
 *
 * 流程
 * 1. 确定内存占用 观察活跃数据的大小
 * 2. 延迟调优，minorGc fullGc的频率的时间
 * 3.
 */
public class TestLock {

    static List<Foo> list=new ArrayList<>();

    public static void main(String[] args) {
        TestLock t = new TestLock();
        Thread t1 = new Thread(() -> {
            synchronized (t) {
                try {
                    t.wait(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                for (int i = 0; i < 500; i++) {
                    Foo o = new Foo("bar");
                    list.add(o);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t2.start();

    }
}


class Foo {
    private String bar;

    Foo(String bar) {
        this.bar = bar;
    }

}
