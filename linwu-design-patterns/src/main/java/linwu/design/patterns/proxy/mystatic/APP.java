package linwu.design.patterns.proxy.mystatic;

import linwu.design.patterns.proxy.dynamic.MyDynamicInc;
import linwu.design.patterns.proxy.dynamic.MyDynamicIncProxy;

import java.lang.reflect.Proxy;

public class APP {
    public static void main(String[] args) throws Throwable {
        MyStaticInc inc =
                (MyStaticInc)
                        Proxy.newProxyInstance(
                                MyStaticInc.class.getClassLoader(), // 传入ClassLoader
                                new Class[]{MyStaticInc.class}, // 传入要实现的接口
                                new MyStaticIncProxy()); // 传入处理调用方法的InvocationHandler
        inc.test("linwu");
    }
}
