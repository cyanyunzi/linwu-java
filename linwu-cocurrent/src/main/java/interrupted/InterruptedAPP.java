package interrupted;

public class InterruptedAPP {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 =
        new Thread(
            () -> {
              try {
                method1();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
    t1.start();
    Thread.sleep(1000L);
    t1.interrupt();
  }

  public static void method1() throws InterruptedException {
    int i = 0;
    while (true) {
      if (Thread.currentThread().isInterrupted()) {
        throw new InterruptedException("线程被中断");
      }
      i++;
      System.out.println(i);
    }
  }
}
