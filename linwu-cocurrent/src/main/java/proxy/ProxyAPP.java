package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyAPP {
  static interface ProxyIfc {
    void say();
  }

  static class ProxyIfcInvocationHandler implements InvocationHandler {
    private ProxyIfc ifc;
    public ProxyIfcInvocationHandler(ProxyIfc ifc){
      this.ifc = ifc;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      System.out.println("代理前");
      method.invoke(ifc, args);
      System.out.println("代理后");
      return null;
    }
  }

  public static void main(String[] args) {

    ProxyIfc o =
        (ProxyIfc)
            Proxy.newProxyInstance(
                ProxyIfc.class.getClassLoader(),
                new Class[] {ProxyIfc.class},
                new ProxyIfcInvocationHandler(() -> System.out.println("hahaha")));
    o.say();
    Class<?> proxyClass = Proxy.getProxyClass(ProxyAPP.class.getClassLoader(), ProxyIfc.class);


    System.out.println(1);
  }
}
