package javaAgain.prototype;

/**
 * https://juejin.im/post/5c988a7ef265da6116246d11
 */
public class ProtoType {


    public static void main(String[] args) {
        try {
            RealizeType obj1 = new RealizeType();
            RealizeType obj2;
            obj2 = (RealizeType) obj1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 原型模式的克隆分为浅克隆和深克隆，Java 中的 Object 类提供了浅克隆的 clone() 方法，
 * 具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，这里的 Cloneable 接口就是抽象原型类。其代码如下
 */
class RealizeType implements Cloneable {
    RealizeType() {
    }

    public Object clone() throws CloneNotSupportedException {
        return (RealizeType) super.clone();
    }
}
