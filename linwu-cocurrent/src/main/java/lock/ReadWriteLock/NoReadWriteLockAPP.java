package lock.ReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NoReadWriteLockAPP {
    private List<String> list = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public void add(String str){
        lock.lock();

        list.add(str);
        lock.unlock();
    }

    public void read(){
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        NoReadWriteLockAPP app = new NoReadWriteLockAPP();

        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(()->{
                app.add("1");
            });

            Thread t2 = new Thread(()->{
                app.read();
            });
            t1.start();
            t2.start();
        }

    }
}
