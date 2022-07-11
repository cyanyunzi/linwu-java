package linwu.design.patterns.proxy.mystatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyStaticIncProxy implements MyStaticInc,InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (MyStaticInc.METHOD_NAME.equals(method.getName())) {
      System.out.println("进入静态代理类方法...agr:"+args[0]);
    }
    return proxy;
  }

  @Override
  public void test(String arg) throws Throwable {
    System.out.println("静态代理实现类");
  }
}
