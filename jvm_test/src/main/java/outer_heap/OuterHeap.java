package outer_heap;


import java.nio.ByteBuffer;
import java.util.HashMap;

public class OuterHeap {


    public static void main(String[] args) {
        ByteBuffer out_heap = ByteBuffer.allocateDirect(1024);
        out_heap.putChar('A');
        out_heap.putInt(123);
        System.out.println("capacity: " + out_heap.capacity());
        System.out.println("limit: " + out_heap.limit());
        System.out.println("position: " + out_heap.position());
        out_heap.position(0);
        System.out.println(out_heap.getChar());
        System.out.println(out_heap.getInt());

        ByteBuffer heap = ByteBuffer.allocate(1024);
        HashMap<String, String> map = new HashMap<>();
        heap.putInt(1111);
        System.out.println(heap.getInt(0));

        /*
         * https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html
         * Unsafe类为一单例实现，提供静态方法getUnsafe获取Unsafe实例，
         * 当且仅当调用getUnsafe方法的类为引导类加载器所加载时才合法，否则抛出SecurityException异常。
         */
//        System.out.println(Unsafe.getUnsafe().allocateMemory(1000));
    }
}
