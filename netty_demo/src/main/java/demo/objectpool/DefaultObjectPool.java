package demo.objectpool;

public class DefaultObjectPool extends ObjectPool<String> {

    @Override
    public PooledObject<String> create() {
        return new PooledObject<>(new String("" + 1));
    }

}
