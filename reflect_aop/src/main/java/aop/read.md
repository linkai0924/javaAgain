> 参考 https://cloud.tencent.com/developer/article/1017001

> https://segmentfault.com/a/1190000011291179
----

动态代理实际上也是一种结构型的设计模式，JDK中已经为我们准备好了这种设计模式，不过这种JDK为我们提供的动态代理有2个缺点：

* 只能代理实现了接口的目标对象；
* 基于反射，效率低