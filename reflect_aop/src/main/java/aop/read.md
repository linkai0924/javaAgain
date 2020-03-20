> 参考 https://cloud.tencent.com/developer/article/1017001

> https://segmentfault.com/a/1190000011291179
----

动态代理实际上也是一种结构型的设计模式，JDK中已经为我们准备好了这种设计模式，不过这种JDK为我们提供的动态代理有2个缺点：

* 只能代理实现了接口的目标对象；
* 基于反射，效率低

----
1. jdk动态代理实现了被代理对象的接口，cglib是继承了被代理的对象【通过字节码技术创建这个类的子类，实现动态代理】

2. 都是在运行期间，jdk是直接写class字节码，cglib使用asm框架写字节码，实现更复杂

3. java动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法时用InvokeHandler，cglib是通过继承要被代理类的机制

4. jdk动态代理要求
    1. 【必须】
    2. 被代理的类必须要实现一个接口
    3. 使用Proxy.newProxyInstance产生代理对象

5. cglib要求
    1. jdk动态代理类库中已有，而cglib必须加入第三方依赖(cglib、asm)
    2. jdk调用代理方法，通过反射机制，cglib通过fastclass机制直接调用方法，这方面cglib执行效率更高。

