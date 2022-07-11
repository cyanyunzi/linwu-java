package 线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyAPP {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),new MyThreadFactory());
        for (int i = 0; i < 10; i++) {
            executor.execute(()-> {
                System.out.println("模拟执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

       while (true){
           Thread.sleep(3000);
           main(null);
       }
    }

    static class MyThreadFactory implements ThreadFactory {
        private AtomicInteger count = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            int i = count.incrementAndGet();
            String threadName = "林雾-" + i;
            System.out.println("线程名称: "+threadName);
            Thread thread = new Thread(r, threadName);
            return thread;
        }
    }
}
