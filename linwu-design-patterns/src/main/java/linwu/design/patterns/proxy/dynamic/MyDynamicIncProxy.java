package linwu.design.patterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyDynamicIncProxy implements MyDynamicInc,InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (MyDynamicInc.METHOD_NAME.equals(method.getName())) {
      System.out.println("进入动态代理类方法...agr:"+args[0]);
    }
    return proxy;
  }

  @Override
  public void test(String arg) throws Throwable {
    System.out.println("进入静态代理实现类方法...agr:"+arg);
  }
}
