package deadlock;

public class DeadLockAPP {
  private static Object L1 = new Object();
  private static Object L2 = new Object();

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> lockO1());
    Thread t2 = new Thread(() -> lockO2());

    Thread.sleep(1000);
    for (int i = 0; i < 10; i++) {
      t1.start();
      t2.start();
    }
  }

  public static void lockO1() {
    synchronized (L1) {
      System.out.println("lockO1-获得 L1");
      synchronized (L2) {
        System.out.println("lockO1-获得 L2");
      }
    }
  }

  public static void lockO2() {
    synchronized (L2) {
      System.out.println("lockO2-获得 L2");
      synchronized (L1) {
        System.out.println("lockO2-获得 L1");
      }
    }
  }
}
