package demo.objectpool;


/**
 * https://www.jianshu.com/p/38c5bccf892f
 */
public class Test {
    public static void main(String[] args) {
        ObjectPool<String> objPool = new DefaultObjectPool();
        objPool.createPool();
        String obj = objPool.getObject();
        objPool.returnObject(obj);
        objPool.closeObjectPool();
    }
}
