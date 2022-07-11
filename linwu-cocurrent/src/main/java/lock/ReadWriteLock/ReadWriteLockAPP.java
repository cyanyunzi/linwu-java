package lock.ReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockAPP {
    private List<String> list = new ArrayList<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock rlock = readWriteLock.readLock();
    private final Lock wlock = readWriteLock.writeLock();

    public void add(String str){
        wlock.lock();
        
        list.add(str);
        wlock.unlock();
    }

    public void read(){
        rlock.lock();
        System.out.println(list.toString());
        rlock.unlock();
    }

    public static void main(String[] args) {
        ReadWriteLockAPP app = new ReadWriteLockAPP();

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
