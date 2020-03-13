package reflect;
//这些api都是在java.beans下（rt.jar包下）

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class IntrospectorDemo {
    String name;

    public static void main(String[] args) throws Exception {
        IntrospectorDemo demo = new IntrospectorDemo();
        // 如果不想把父类的属性也列出来的话，
        //那 getBeanInfo 的第二个参数填写父类的信息
        BeanInfo bi = Introspector.getBeanInfo(demo.getClass(), Object.class);//Object类是所有Java类的根父类
        PropertyDescriptor[] props = bi.getPropertyDescriptors();//获得属性的描述器
        for (int i = 0; i < props.length; i++) {
            System.out.println("获取属性的Class对象：" + props[i].getPropertyType());
            props[i].getWriteMethod().invoke(demo, "酸辣汤");//获得setName方法，并使用invoke调用
            System.out.println("读取属性值：" + props[i].getReadMethod().invoke(demo, null));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

