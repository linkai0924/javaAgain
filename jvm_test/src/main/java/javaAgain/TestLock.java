package javaAgain;

public class TestLock {


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
                Foo o = new Foo("bar");
                System.out.println(o);
                try {
                    Thread.sleep(5000);
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
