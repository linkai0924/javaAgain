package javaAgain.example2;

/**
 * @desc 自我介绍测试实现类
 */
public class TestImpl implements ITest {

    /* (non-Javadoc)
     * @see com.chq.study.cl.ITest#self()
     */
    @Override
    public void self() {
        System.out.println("this is from TestImpl instance " + this);
    }

}