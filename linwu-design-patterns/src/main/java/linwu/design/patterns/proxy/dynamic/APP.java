package linwu.design.patterns.proxy.dynamic;

import java.lang.reflect.Proxy;

public class APP {
    public static void main(String[] args) throws Throwable {
        MyDynamicInc inc =
                (MyDynamicInc)
                        Proxy.newProxyInstance(
                                MyDynamicInc.class.getClassLoader(), // 传入ClassLoader
                                new Class[]{MyDynamicInc.class}, // 传入要实现的接口
                                new MyDynamicIncProxy()); // 传入处理调用方法的InvocationHandler
        inc.test("linwu");
    }
}
